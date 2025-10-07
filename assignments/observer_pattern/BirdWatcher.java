package assignments.observer_pattern;

public class BirdWatcher implements WeatherObserver, Occupation {
    private WeatherData weatherData;
    private String timeOfDay = "0";
    private String temperature = "0";
    private String clouds = "0";

    public BirdWatcher(WeatherData weatherData) {
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
        if (!timeOfDay.equalsIgnoreCase("4")) {
            if (temperature.equals("4") || temperature.equals("5")) {
                System.out.println("The Birdwatcher is putting on a jacket.");
            }

            if (clouds.equals("4")) {
                System.out.println("The Birdwatcher is waiting inside for the storm to pass");
            } else {
                System.out.println("The Birdwatcher is excited to watch and record many birds!");
            }

        } else {
            System.out.println("The Birdwatcher is sleeping.");
        }
    }
}
