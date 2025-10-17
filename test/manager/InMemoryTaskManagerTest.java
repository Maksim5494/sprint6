
package manager;

import model.Task;
import model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryTaskManagerTest {

    private InMemoryTaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    public void shouldCreateAndRetrieveTask() {
        Task task = new Task("Test", "Description", TaskStatus.NEW);
        taskManager.createTask(task);

        Task retrieved = taskManager.getTask(task.getId());
        assertEquals(task, retrieved);
    }

    @Test
    public void shouldDeleteTask() {
        Task task = new Task("ToDelete", "desc", TaskStatus.NEW);
        taskManager.createTask(task);

        taskManager.deleteTask(task.getId());
        assertNull(taskManager.getTask(task.getId()));
    }

    @Test
    public void shouldReturnAllTasks() {
        Task task1 = new Task("Task1", "desc", TaskStatus.NEW);
        Task task2 = new Task("Task2", "desc", TaskStatus.NEW);
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }
}
