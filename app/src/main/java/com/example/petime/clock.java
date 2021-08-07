package com.example.petime;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class clock extends AppCompatActivity {
    TextView textView;
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
        ly.mCountdownTime=time;
        clockout.addView(ly);
        ly.setAddCountDownListener(new CountDownView.OnCountDownFinishListener() {
            @Override
            public void countDownFinished() {
                Toast.makeText(clock.this, "倒计时结束", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        ly.startCountDown();
    }
}
