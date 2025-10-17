package manager;

import model.Task;
import model.TaskStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InMemoryHistoryManagerTest {

        @Test
        public void testCreateTask() {
             TaskManager taskManager = Managers.getDefault();
             taskManager.createTask(new Task("name", "desk", TaskStatus.NEW));
            List<Task> tasks = taskManager.getTasks();
            Assertions.assertEquals(1, tasks.size());
    }
        @Test
         public void testAddSeveralTasksToHistory() {
        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("Task 1", "Desc 1", TaskStatus.NEW);
        Task task2 = new Task("Task 2", "Desc 2", TaskStatus.NEW);
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        taskManager.getTask(task1.getId());
        taskManager.getTask(task2.getId());

        List<Task> history = taskManager.getHistory();
        Assertions.assertEquals(2, history.size());
        Assertions.assertEquals(task1.getId(), history.get(0).getId());
        Assertions.assertEquals(task2.getId(), history.get(1).getId());
    }

    @Test
    public void testHistoryLimit() {
        TaskManager taskManager = Managers.getDefault();

        for (int i = 0; i < 15; i++) {
            Task task = new Task("Task " + i, "Desc", TaskStatus.NEW);
            taskManager.createTask(task);
            taskManager.getTask(task.getId());
        }
        List<Task> history = taskManager.getHistory();
        Assertions.assertEquals(10, history.size());
        Assertions.assertEquals("Task 5", history.get(0).getName());
    }

    @Test
    public void testDeleteTaskRemovesFromHistory() {
        TaskManager taskManager = Managers.getDefault();
        Task task = new Task("To Delete", "Desc", TaskStatus.NEW);
        taskManager.createTask(task);
        taskManager.getTask(task.getId());
        taskManager.deleteTask(task.getId());
        List<Task> history = taskManager.getHistory();
        Assertions.assertTrue(history.contains(task));
    }

    @Test
    public void testUpdateTaskIsInHistory() {
        TaskManager taskManager = Managers.getDefault();

        Task task = new Task("To Update", "Desc", TaskStatus.NEW);
        taskManager.createTask(task);
        taskManager.getTask(task.getId());

        Task updatedTask = new Task(task.getId(), "Updated", "Updated Desc", TaskStatus.IN_PROGRESS);
        taskManager.updateTask(updatedTask);

        List<Task> history = taskManager.getHistory();

        Assertions.assertFalse(history.contains(updatedTask));
    }

}
