package id.fahmi.abkberbakat;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

import static android.app.Service.START_STICKY;

/**
 * Created by Fahmi on 6/28/2017.
 */

public class AudioBackground extends Service{
    //creating a mediaplayer object
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        ///player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player = MediaPlayer.create(this, R.raw.audio_background);
        //setting loop play to true
        //this will make the ringtone continuously playing
        player.setLooping(true);

        //staring the player
        player.start();

        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed
        //player.pause();
        player.stop();
    }

}