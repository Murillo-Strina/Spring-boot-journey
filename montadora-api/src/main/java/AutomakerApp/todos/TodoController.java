package AutomakerApp.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e) {
            var errorMessage = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, errorMessage);
        }
    }

    @PutMapping("{id}")
    public void updateStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.updateStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity search(@PathVariable("id") Integer id) {
        return service.searchById(id);
    }
}
