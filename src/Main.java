import manager.Managers;
import manager.TaskManager;
import model.Task;
import model.TaskStatus;




public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        System.out.println("создать таску");
        Task taskForCreate = new Task ("Name", "Desc", TaskStatus.NEW);
        taskManager.createTask(taskForCreate);
        System.out.println(taskManager.getTasks());
        System.out.println();

        System.out.println("получить таску");
        System.out.println(taskManager.getTask(taskForCreate.getId()));
        System.out.println();

        System.out.println("проверим обновления");
        Task taskForUpdate = new Task(taskForCreate.getId(), "New name", taskForCreate.getDescription(), TaskStatus.IN_PROGRESS);
        taskForUpdate = taskManager.updateTask(taskForUpdate);
        System.out.println(taskManager.getTasks());
        System.out.println();

        System.out.println("удаляем таску");
        taskManager.deleteTask(taskForUpdate.getId());
        System.out.println(taskManager.getTasks());
        System.out.println();

        System.out.println("Проверяем историю");
        System.out.println(taskManager.getHistory());
        System.out.println();
    }
}
