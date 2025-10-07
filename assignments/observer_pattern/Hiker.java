package assignments.observer_pattern;

public class Hiker implements WeatherObserver, Occupation {
    private WeatherData weatherData;
    private String timeOfDay = "0";
    private String temperature = "0";
    private String clouds = "0";

    public Hiker(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(String timeOfDay, String temperature, String clouds) {
        this.timeOfDay = timeOfDay;
        this.temperature = temperature;
        this.clouds = clouds;
        display();
    }

    @Override
    public void display() {
        if (timeOfDay.equalsIgnoreCase("4")) {
            System.out.println("The Hiker is sleeping.");

        } else {
            if (!clouds.equals("4") || !temperature.equals("5") || !temperature.equals("1")) {
                System.out.println("The Hiker is hiking.");
            } else {
                System.out.println("The Hiker decided the conditions aren't safe to hike.");
            }
        }
    }
}