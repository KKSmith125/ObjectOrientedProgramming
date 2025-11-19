package assignments.adapter_pattern;

public class VLCAdapter implements AudioMediaPlayer {
    VLCPlayer vlcPlayer;

    public VLCAdapter(VLCPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    public void decodeAudio() {
        vlcPlayer.decodeVideo();
        vlcPlayer.decodeAdvancedAudio();
    }

    public void playBackAudio() {
        vlcPlayer.playBackAudioVideo();
    }
}