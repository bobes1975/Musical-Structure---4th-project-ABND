package com.example.android.project_04_nd_musicalstructure_classicalmusic;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import static android.media.AudioManager.STREAM_MUSIC;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {

    private AudioManager audioManager = null;

    private ImageButton mPlay;
    private ImageButton mStop;
    private ImageButton mPause;

    private String namePlaying;
    private String compositionPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] intentMsgArray;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        setContentView(R.layout.now_playing);
        setVolumeControlStream(STREAM_MUSIC);

        mPlay = findViewById(R.id.play);
        mPause = findViewById(R.id.pause);
        mStop = findViewById(R.id.stop);
        ImageButton mHome = findViewById((R.id.categoryButton));

        // Set OnClickListeners on clickable items
        mPlay.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mPause.setOnClickListener(this);


        //get info from CompositionList
        Bundle bundle = getIntent().getExtras();

        String mIntentMessage = null;
        if (bundle != null) {
            mIntentMessage = bundle.getString(Util.INTENT_KEY_NAME);
        }

        // Splits intent message received into composer name, composition
        assert mIntentMessage != null;
        intentMsgArray = mIntentMessage.split("\\|");
        namePlaying = intentMsgArray[0];
        compositionPlaying = intentMsgArray[1];


        //home button to category_list
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToCategory = new Intent(NowPlaying.this, CategoryList.class);
                NowPlaying.this.startActivity(backToCategory);
            }
        });
        playingNow();
        volumeControl();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

        if (v.equals(mPlay)) {
            Toast.makeText(this, getString(R.string.playing), Toast.LENGTH_SHORT).show();
        }
        if (v.equals(mPause)) {
            Toast.makeText(this, getString(R.string.pausing), Toast.LENGTH_SHORT).show();
        }

        if (v.equals(mStop)) {
            Toast.makeText(this, getString(R.string.stopping), Toast.LENGTH_SHORT).show();

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

