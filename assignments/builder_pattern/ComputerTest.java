package assignments.builder_pattern;

public class ComputerTest {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        IComputerBuilder builder = new SurfaceLaptop7Builder();

        Computer computer = director.createMicrosoftComputer(builder);

        System.out.println(computer);

        builder = new MacBookAirBuilder();
        computer = director.createAppleComputer(builder);

        System.out.println(computer);
    }
}