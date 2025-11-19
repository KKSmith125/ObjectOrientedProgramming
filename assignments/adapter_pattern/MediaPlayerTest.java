package assignments.adapter_pattern;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerTest {
    
    public static void main(String[] args) {
            AudioMediaPlayer mp3Player = new MP3Player();
            AdvancedMediaPlayer mp4Player = new MP4Player();
            AdvancedMediaPlayer vlcPlayer = new VLCPlayer();
            AudioMediaPlayer mp4Adapter = new MP4Adapter(mp4Player);
            AudioMediaPlayer vlcAdapter = new VLCAdapter(vlcPlayer);

            List<AudioMediaPlayer> allAudioMediaPlayers = new ArrayList<>();

            allAudioMediaPlayers.add(mp3Player);
            allAudioMediaPlayer.add(mp4Adapter);
            allAudioMediaPlayer.add(vlcAdapter);

            for (AudioMediaPlayer audioMediaPlayer : allAudioMediaPlayers) {
                audioMediaPlayer.decodeAudio();
                audioMediaPlayer.playBackAudio();
            }
    }
}