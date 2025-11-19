public class MP4Adapter implements AudioMediaPlayer() {
    MP4Player mp4Player;

    public MP4Adapter(MP4Player mp4Player) {
        this.mp4Player = mp4Player;
    }

    public void decodeAudio() {
        mp4Player.decodeVideo();
        mp4Player.decodeAdvancedAudio();
    }

    public void playBackAudio() {
        mp4Player.playBackAudioVideo();
    }
}