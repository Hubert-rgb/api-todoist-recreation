package HubertRoszyk.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping
    public Task saveTask(@RequestBody String jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(jsonInput);
        try {
            Task task = objectMapper.readValue(
                    jsonInput, Task.class
            );
            return taskService.saveTask(task);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

