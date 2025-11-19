public class VLCAdapter implements AudioMediaPlayer() {
    VLCPlayer VLCPlayer;

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