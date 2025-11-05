package assignments.singleton_pattern;

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
        System.out.println("Level: " + level);
        System.out.println("Statement: " + statement);
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
