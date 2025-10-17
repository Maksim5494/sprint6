package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private HashMap<Long, Task> tasks = new HashMap<>();
    private HashMap<Long, Epic> epics = new HashMap<>();
    private HashMap<Long, Subtask> subtasks = new HashMap<>();

    private long generatorId = 1;
    private final HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public Task getTask(long id) {
        Task task = tasks.get(id);
        addHistory(task);
        return task;
    }

    @Override
    public Epic getEpic(long id) {
        Epic epic = epics.get(id);
        addHistory(epic);
        return epic;
    }

    @Override
    public Subtask getSubtask(long id) {
        Subtask subtask = subtasks.get(id);
        addHistory(subtask);
        return subtask;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task createTask(Task task) {
        task.setId(getNextId());
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task deleteTask(long id) {
        return tasks.remove(id);
    }

    @Override
    public void deleteTasks() {
        tasks.clear();
    }

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    private void addHistory(Task task) {
        if (task != null) {
            historyManager.add(task);
        }
    }

    private long getNextId() {
        return generatorId++;
    }
}