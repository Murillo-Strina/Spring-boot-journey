package AutomakerApp.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity newTodoEntity) {
        validator.validate(newTodoEntity);
        return repository.save(newTodoEntity);
    }

    public void updateStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluded() == Boolean.TRUE ? "Concluded" : "Not Concluded";
        mailSender.sendEmail("Todo " + todo.getDescription() + " was updated to" + status);
    }

    public TodoEntity searchById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
