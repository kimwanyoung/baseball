package domain.log;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private final List<Log> logs;

    public Logs(List<Log> logs) {
        this.logs = logs;
    }

    public void save(Log log) {
        this.logs.add(log);
    }

    public List<String> getLogsPrintFormat() {
        List<String> logsStringFormat = new ArrayList<>();
        for(int i = 0; i < logs.size(); i++) {
            logsStringFormat.add((i + 1) + "번째 게임 : " + logs.get(i));
        }
        return logsStringFormat;
    }
}
