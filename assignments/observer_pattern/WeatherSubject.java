package assignments.observer_pattern;

public interface WeatherSubject {
    public void registerObserver(WeatherObserver occupation);

    public void removeObserver(WeatherObserver occupation);

    public void notifyObservers();
}
