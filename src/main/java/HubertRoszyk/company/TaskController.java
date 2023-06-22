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

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasksTodo();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public Task saveTask(@RequestBody String jsonInput){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(jsonInput);
        try {
            Task task = objectMapper.readValue(
                    jsonInput, Task.class
            );
            task.setTaskStatus(TaskStatus.TODO);
            return taskService.saveTask(task);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{taskId}")
    public Task completeTask(@PathVariable long taskId){
        Task task = taskService.getTaskById(taskId);
        task.setTaskStatus(TaskStatus.DONE);
        taskService.saveTask(task);

        return task;
    }
}

