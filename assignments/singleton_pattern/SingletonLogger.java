package assignments.singleton_pattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SingletonLogger {
    private static SingletonLogger singletonLoggerInstance;
    String level;
    String statement;

    private SingletonLogger() {
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void log(String level, String statement) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("[" + timestamp + "] [" + level + "]" + statement);
    }

    public static SingletonLogger getInstance() {
        if (singletonLoggerInstance == null) {
            synchronized (SingletonLogger.class) {
                if (singletonLoggerInstance == null) {
                    singletonLoggerInstance = new SingletonLogger();
                }
            }
        }

        return singletonLoggerInstance;
    }
}
