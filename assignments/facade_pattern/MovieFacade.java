package assignments.facade_pattern;

public class MovieFacade {
    private PopcornMaker popcornMaker;
    private TheaterLights theaterLights;
    private ProjectorTV projectorTV;
    private SoundSystem soundSystem;
    private StreamingPlayer streamingPlayer;

    public MovieFacade (PopcornMaker popcornMaker, TheaterLights theaterLights, ProjectorTV projectorTV, SoundSystem soundSystem, StreamingPlayer streamingPlayer) {
        this.popcornMaker =  popcornMaker;
        this.theaterLights = theaterLights;
        this.projectorTV = projectorTV;
        this.soundSystem = soundSystem;
        this.streamingPlayer = streamingPlayer;
    }

    public void getReady() {
        theaterLights.turnOnLights();
        popcornMaker.fillPopcornMaker();
        projectorTV.turnOnProjector();
        soundSystem.turnOnSpeakers();
        streamingPlayer.findMovie();
        popcornMaker.popPopcorn();
    }

    public void playMovie() {
        popcornMaker.emptyPopcornMaker();
        theaterLights.turnOffLights();
        soundSystem.raiseVolume(20);
        streamingPlayer.startMovie();
    }

    public void pauseMovie() {
        soundSystem.lowerVolume(15);
        streamingPlayer.pauseMovie();
        theaterLights.turnOnLights();
        popcornMaker.fillPopcornMaker();
        popcornMaker.popPopcorn();            
    }

    public void resumeMovie() {
        popcornMaker.emptyPopcornMaker();
        theaterLights.turnOffLights();
        soundSystem.raiseVolume(15);
        streamingPlayer.resumeMovie();
    }

    public void finishMovie() {
        projectorTV.turnOffProjector();
        streamingPlayer.turnOffSteamingPlayer();
        theaterLights.turnOnLights();
    }
}
