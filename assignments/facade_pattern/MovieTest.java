package assignments.facade_pattern;

public class MovieTest {
    public static void main(String[] args) {
        PopcornMaker popcornMaker = new PopcornMaker();
        TheaterLights theaterLights = new TheaterLights();
        ProjectorTV projectorTV =  new ProjectorTV();
        SoundSystem soundSystem = new SoundSystem();
        StreamingPlayer streamingPlayer = new StreamingPlayer();

        MovieFacade movieFacade = new MovieFacade(popcornMaker, theaterLights, projectorTV, soundSystem, streamingPlayer);

        movieFacade.getReady();
        movieFacade.playMovie();
        movieFacade.pauseMovie();
        movieFacade.resumeMovie();
        movieFacade.finishMovie();
    }
}