package assignments.observer_pattern;

public interface WeatherObserver {
    public void update(String timeOfDay, String temperature, String clouds);
}
