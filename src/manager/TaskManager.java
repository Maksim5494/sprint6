package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {

    Task getTask(long id);

    Epic getEpic(long id);

    Subtask getSubtask (long id);

    ArrayList<Task> getTasks();

    Task createTask(Task task);

    Task updateTask(Task task);

    Task deleteTask(long id);

    void deleteTasks();

    List<Task> getHistory();
}
