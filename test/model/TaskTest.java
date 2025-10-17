package model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskConstructorAndGetters() {
        Task task = new Task("Test task", "Description", TaskStatus.NEW);
        assertEquals("Test task", task.getName());
        assertEquals("Description", task.getDescription());
    }
    @Test
    public void testTaskCreation() {
        String name = "Test Task";
        String description = "This is a test task.";
        TaskStatus status = TaskStatus.NEW;
        Task task = new Task(name, description, status); // Все необходимые параметры переданы
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task.", task.getDescription());
    }

    @Test
    public void testSetters() {
        Task task = new Task("Initial", "Init", TaskStatus.NEW);
        task.setName("Updated");
        task.setDescription("Updated desc");
        task.setName(String.valueOf(TaskStatus.DONE));
        assertEquals("DONE", task.getName());
        assertEquals("Updated desc", task.getDescription());
    }

    @Test
    public void testEqualsAndHashCode() {
        Task task1 = new Task("Same", "Same", TaskStatus.NEW);
        Task task2 = new Task("Same", "Same", TaskStatus.NEW);
        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }
}

