
package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskStatusTest {

    @Test
    public void testTaskStatusValues() {
        assertNotNull(TaskStatus.valueOf("NEW"));
        assertNotNull(TaskStatus.valueOf("IN_PROGRESS"));
        assertNotNull(TaskStatus.valueOf("DONE"));
    }
}
