package assignments.observer_pattern;

import java.util.List;
import java.util.ArrayList;

public class WeatherData implements WeatherSubject {
    private List<WeatherObserver> occupations;
    private String timeOfDay;
    private String temperature;
    private String clouds;

    public WeatherData() {
        occupations = new ArrayList<>();
    }

    @Override
    public void registerObserver(WeatherObserver occupation) {
        occupations.add(occupation);
    }

    @Override
    public void removeObserver(WeatherObserver occupation) {
        occupations.remove(occupation);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver occupation : occupations) {
            occupation.update(timeOfDay, temperature, clouds);
        }
    }

    public void weatherChanged() {
        notifyObservers();
    }

    public void setWeather(String timeOfDay, String temperature, String clouds) {
        this.timeOfDay = timeOfDay;
        this.temperature = temperature;
        this.clouds = clouds;
        weatherChanged();
    }
}
