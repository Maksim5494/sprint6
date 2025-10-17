package manager;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagersTest {
@Test
public void shouldReturnDefaultTaskManager() {
    TaskManager taskManager = Managers.getDefault();
    assertNotNull(taskManager);
}

@Test
public void shouldReturnDefaultHistoryManager() {
    HistoryManager historyManager = Managers.getDefaultHistory();
    assertNotNull(historyManager);
}

}