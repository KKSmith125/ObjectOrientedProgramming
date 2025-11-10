package assignments.singleton_pattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SingletonLogger {
    private static SingletonLogger singletonLoggerInstance;
    String level = "INFO";
    String statement;

    private SingletonLogger() {
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private int getLevelNumber(String level) {
        if (level.equals("INFO")) {
            return 1;
        } else if (level.equals("WARN")) {
            return 2;
        } else if (level.equals("CRITICAL")) {
            return 3;
        } else {
            return 0;
        }
    }

    public void log(String level, String statement) {
        int currentLevel = getLevelNumber(this.level);
        int newLevel = getLevelNumber(level);

        if (newLevel >= currentLevel) {
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("[" + timestamp + "] [" + level + "]" + statement);
        }
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
