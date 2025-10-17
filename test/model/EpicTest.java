package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class EpicTest {

    @Test
     public void testEpicConstructorAndGetters() {
        Epic epic = new Epic("Epic Task", "Big task");
        assertEquals("Epic Task", epic.getName());
        assertEquals("Big task", epic.getDescription());
        assertEquals(TaskStatus.NEW, epic.getTaskStatus());
        assertTrue(epic.getSubtaskIds().isEmpty());
    }

    @Test
     public void testAddAndRemoveSubtasks() {
        Epic epic = new Epic("Epic", "Test epic");
        epic.addSubtask(1L);
        epic.addSubtask(2L);
        assertEquals(2, epic.getSubtaskIds().size());
        epic.removeSubtask(1L);
        assertFalse(epic.getSubtaskIds().contains(1L));
    }

}