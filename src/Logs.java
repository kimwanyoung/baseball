import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Logs {
    private final List<Log> logs;

    public Logs(List<Log> logs) {
        this.logs = logs;
    }

    public void save(Log log) {
        this.logs.add(log);
    }

    public List<Log> getAllLogs() {
        return Collections.unmodifiableList(logs);
    }
}
