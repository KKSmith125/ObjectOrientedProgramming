package assignments.observer_pattern;

public class Meteorologist implements WeatherObserver, Occupation {
    private WeatherData weatherData;
    private String timeOfDay = "0";
    private String temperature = "0";
    private String clouds = "0";

    public Meteorologist(WeatherData weatherData) {
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
            System.out.println("The Meteorologist is getting ready for their morning forecast.");

        } else if (timeOfDay.equalsIgnoreCase("1")) {
            System.out.println("The Meteorologist is giving their morning report.");

            if (clouds.equals("4")) {
                System.out.println("The Meteorologist is warning people of the coming storm!");
            } else if (clouds.equals("1")) {
                System.out.println("The Meteorologist is celebrating the great weather!");
            }
            if (temperature.equals("5")) {
                System.out.println("The Meteorologist is warning people of the freezing temperatures!");
            } else if (clouds.equals("1")) {
                System.out.println("The Meteorologist is warning people of the extreme heat!");
            }
        } else {
            System.out.println("The Meteorologist is sleeping.");
        }
    }
}