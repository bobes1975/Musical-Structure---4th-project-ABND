package com.example.android.project_04_nd_musicalstructure_classicalmusic;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import static android.media.AudioManager.STREAM_MUSIC;

public class now_playing extends AppCompatActivity implements View.OnClickListener {

    private AudioManager audioManager = null;

    private ImageButton play;
    private ImageButton stop;
    private ImageButton pause;

    private String namePlaying;
    private String compositionPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] intentMsgArray;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        setContentView(R.layout.now_playing);
        setVolumeControlStream(STREAM_MUSIC);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        // Set OnClickListeners on clickable items
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);


        //get info from CompositionList
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String mIntentMessage = bundle.getString("message");

        // Splits intent message received into composer name, composition
        assert mIntentMessage != null;
        intentMsgArray = mIntentMessage.split("\\|");
        namePlaying = intentMsgArray[0];
        compositionPlaying = intentMsgArray[1];

        playingNow();
        volumeControl();
    }

    public void playingNow() {

        //rebuild composer name to lowerCase and replace space with _

        String nameComposerForPlaying = namePlaying.replaceAll(" ", "_").toLowerCase();
        String nameCompositionForPlaying = compositionPlaying.replaceAll(" ", "_").toLowerCase();

        //create name of composition for playing
        String compositionForPlaying = nameComposerForPlaying + "_" + nameCompositionForPlaying;

        //identify composerPicture, Composer and Composition
        ImageView composerPicture = findViewById(R.id.composerImage);
        TextView composition = findViewById(R.id.composition);
        TextView composer = findViewById(R.id.composer);

        //create link for composer image from drawable
        Context context = getApplicationContext();
        int id = context.getResources().getIdentifier("drawable/" + nameComposerForPlaying, null, context.getPackageName());
        composerPicture.setImageResource(id);

        //display composer name and composition
        composition.setText(compositionPlaying);
        composer.setText(namePlaying);
    }

    //This method is for playing, pausing or stopping composition playing

    @Override
    public void onClick(View v) {

        if (v.equals(play)) {
            Toast.makeText(this, "Here will be code for playing", Toast.LENGTH_SHORT).show();
        }
        if (v.equals(pause)) {
            Toast.makeText(this, "Here will be code for pausing", Toast.LENGTH_SHORT).show();
        }

        if (v.equals(stop)) {
            Toast.makeText(this, "Here will be code for stopping", Toast.LENGTH_SHORT).show();

        }
    }

    // volume control SeekBar

    private void volumeControl() {
        try {
            SeekBar volumeMusicSeekBar = findViewById(R.id.seekMusic);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            assert audioManager != null;
            volumeMusicSeekBar.setMax(audioManager.getStreamMaxVolume(STREAM_MUSIC));
            volumeMusicSeekBar.setProgress(audioManager.getStreamVolume(STREAM_MUSIC));

            volumeMusicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

