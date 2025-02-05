package AutomakerApp.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private final TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validate(TodoEntity todo) {
        if (duplicatedTodoDescription(todo.getDescription())) {
            throw new IllegalArgumentException("This description already exists!");
        }
    }

    private boolean duplicatedTodoDescription(String description) {
        return repository.existsByDescription(description);
    }
}
