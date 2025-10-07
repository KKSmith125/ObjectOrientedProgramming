package assignments.observer_pattern;

import java.util.Scanner;

public class WeatherWatchers {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Stargazer stargazer = new Stargazer(weatherData);
        BirdWatcher birdWatcher = new BirdWatcher(weatherData);
        Meteorologist meteorologist = new Meteorologist(weatherData);
        Hiker hiker = new Hiker(weatherData);
        String userInput = "";

        Scanner scnr = new Scanner(System.in);

        System.out.println(
                "Hello! If you tell me the weather outside I can tell you what The Weather Watchers are doing!");
        System.out.println("To quit, type quit.");

        while (!userInput.equalsIgnoreCase("quit")) {
            String timeOfDay = askQuestion(scnr, "What time of day is it? Enter the number",
                    new String[] { "Morning", "Noon", "Evening", "Night" });
            if (timeOfDay.equals("quit"))
                break;

            String temperature = askQuestion(scnr, "What is the temperature out? Enter the number",
                    new String[] { "Greater than 100F: VERY HOT!!!", "87F - 99F: Hot", "59F - 86F: Nice",
                            "40F - 58F Cold", "Below 39F: VERY COLD!" });
            if (temperature.equals("quit"))
                break;

            String clouds = askQuestion(scnr, "What are the clouds like? Enter the number",
                    new String[] { "Clear skies!", "Some nice clouds.", "Cloudy.", "Thunderstorm Clouds!" });
            if (clouds.equals("quit"))
                break;

            System.out.println();

            weatherData.setWeather(timeOfDay, temperature, clouds);

            System.out.println("\nType quit to quit and anything else to continue:");
            userInput = scnr.nextLine().trim();
        }

        scnr.close();
    }

    private static String askQuestion(Scanner scnr, String prompt, String[] options) {
        String userInput = "";
        while (true) {
            System.out.println("\n" + prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }

            userInput = scnr.nextLine().trim();
            if (userInput.equalsIgnoreCase("quit")) {
                return "quit";
            } else if (userInput.matches("[1-" + options.length + "]")) {
                return userInput;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}