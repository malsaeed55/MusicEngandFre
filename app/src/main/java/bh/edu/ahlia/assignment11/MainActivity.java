package bh.edu.ahlia.assignment11;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.os.ConfigurationCompat;

import java.util.Locale;

public class MainActivity extends Activity implements View.OnClickListener {
    Button play, pause, stop;
    MediaPlayer mediaPlayer;
    int pausePosition;
    Locale locale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        play = findViewById( R.id.play );
        pause = findViewById( R.id.pause );
        stop = findViewById( R.id.stop );

        play.setOnClickListener( this );
        pause.setOnClickListener( this );
        stop.setOnClickListener( this );

        locale = ConfigurationCompat.getLocales( Resources.getSystem().getConfiguration() ).get( 0 );

    }

    @Override
    public void onClick(View view) {

    if (locale.getLanguage().equals( "fr" )) {
        switch (view.getId()) {
            case R.id.play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.french );
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo( pausePosition );
                    mediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }
    } else  {

        switch (view.getId()) {
            case R.id.play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.english );
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo( pausePosition );
                    mediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }


    }

        }
    }

