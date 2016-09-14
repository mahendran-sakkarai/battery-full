package com.mahendran_sakkarai.battery_full;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mahendran_sakkarai.battery_full.databinding.AlarmActivityBinding;

/**
 * Created by Nandakumar on 9/14/2016.
 */
public class AlarmActivity extends AppCompatActivity implements Animation.AnimationListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private Animation bounceAnimation;
    private AlarmActivityBinding binding;
    int n = 1;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        binding = DataBindingUtil.setContentView(this, R.layout.alarm_activity);
        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimation.setAnimationListener(this);
        binding.alarmclock.startAnimation(bounceAnimation);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.default_tone);
        if (mp != null) {
            mp.setOnCompletionListener(this);
            mp.start();
        }

        binding.fab.setOnClickListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == bounceAnimation) {
            binding.alarmclock.startAnimation(bounceAnimation);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        if(mediaPlayer != null && n <= 3) {
            mediaPlayer.start();
            n++;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mp != null)
            mp.stop();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            this.finish();
        }
    }
}
