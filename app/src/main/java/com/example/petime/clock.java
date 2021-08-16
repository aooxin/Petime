package com.example.petime;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.time.Clock;

public class clock extends AppCompatActivity {
    TextView textView;
    MediaPlayer mediaPlayer;
    private PopupWindow mPopWindow;
    private TextView last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Intent intent = getIntent();
        int time= intent.getIntExtra("data",20);
        final LinearLayout clockout;
        clockout = (LinearLayout) findViewById(R.id.clockout);
        final LayoutInflater inflater1 = LayoutInflater.from(this);
        CountDownView ly = (CountDownView) inflater1.inflate(R.layout.activity_count_down_view, clockout, false).findViewById(R.id.CountDownView);
        ImageButton btn=(ImageButton)findViewById(R.id.music);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       showPopupWindow();
                                   }
                               });
        ly.mCountdownTime=time;
        clockout.addView(ly);
        ly.setAddCountDownListener(new CountDownView.OnCountDownFinishListener() {
            @Override
            public void countDownFinished() {
                Toast.makeText(clock.this, "倒计时结束", Toast.LENGTH_SHORT).show();
                finish();
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();}
            }
        });
        ly.startCountDown();
    }

    @Override
    public void onBackPressed() {

    }
    @Override
    protected void onPause() {
        super.onPause();
        for (int j = 0; j < 50; j++){
            ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(this.ACTIVITY_SERVICE);
            activityManager.moveTaskToFront(getTaskId(), 0);
        }
    }
    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(clock.this).inflate(R.layout.activity_music, null);
        mPopWindow = new PopupWindow(contentView,
                650, 1000, true);
        mPopWindow.setContentView(contentView);
        TextView tv1 = (TextView)contentView.findViewById(R.id.stop);
        TextView last = (TextView)contentView.findViewById(R.id.r1se);
        TextView tv2 = (TextView)contentView.findViewById(R.id.rain);
        TextView tv3 = (TextView)contentView.findViewById(R.id.piano);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();}
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.lastmoment);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.rain);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(R.raw.piano);
            }
        });
        View rootview = LayoutInflater.from(clock.this).inflate(R.layout.activity_clock, null);
        mPopWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
    }




    private MediaPlayer playMusic(int uri){
        if(mediaPlayer==null){
            mediaPlayer=MediaPlayer.create(clock.this,uri);//重新设置要播放的音频
            mediaPlayer.start();
        }
        else if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer=MediaPlayer.create(clock.this,uri);
            mediaPlayer.start();
        }
        return mediaPlayer;
    }
}
