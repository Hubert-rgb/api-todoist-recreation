package HubertRoszyk.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM Task WHERE task_status = \"TODO\"", nativeQuery = true)
    List<Task> getTasksByStatusTodo();
}
