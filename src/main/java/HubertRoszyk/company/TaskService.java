package HubertRoszyk.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasksTodo(){
        return repository.getTasksByStatusTodo();
    }
    public Task saveTask(Task task){
        return repository.save(task);
    }
    public Task getTaskById(long id){
        return repository.findById(id).orElse(null);
    }
}
