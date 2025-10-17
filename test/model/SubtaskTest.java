
package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtaskTest {

    @Test
    public void testSubtaskConstructorAndGetters() {
        Subtask subtask = new Subtask("Sub", "Desc", TaskStatus.NEW, 1L);
        assertEquals("Sub", subtask.getName());
        assertEquals("Desc", subtask.getDescription());
        assertEquals(1L, subtask.getEpicid());
    }

    @Test
    public void testSetters() {
        Subtask subtask = new Subtask("Old", "Old", TaskStatus.NEW, 1L);
        subtask.setName("New");
        subtask.setDescription("New desc");
        subtask.setName(String.valueOf(TaskStatus.DONE));
        assertEquals("DONE", subtask.getName());
        assertEquals("New desc", subtask.getDescription());
    }
}
