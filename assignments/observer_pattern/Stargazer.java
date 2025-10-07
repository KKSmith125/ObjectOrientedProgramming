package assignments.observer_pattern;

public class Stargazer implements WeatherObserver, Occupation {
    private WeatherData weatherData;
    private String timeOfDay = "0";
    private String temperature = "0";
    private String clouds = "0";

    public Stargazer(WeatherData weatherData) {
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
            if (temperature.equals("4") || temperature.equals("5")) {
                System.out.println("The Stargazer is putting on a jacket.");
            }

            if (clouds.equals("1") || clouds.equals("2")) {
                System.out.println("The Stargazer is enjoying the night sky");
            } else {
                System.out.println("The Stargazer is waiting for the clouds to clear");
            }

        } else {
            System.out.println("The Stargazer is sleeping.");
        }
    }
}
