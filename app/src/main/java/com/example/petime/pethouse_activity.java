package com.example.petime;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class pethouse_activity extends Activity {
    private SlidingDrawer mDrawer;
    private ImageButton imbg;
    private Boolean flag=false;
    private LinearLayout linearLayout;
    private SeekBar seek;
    private TextView myTextView;
    private TextView award;
    private int award_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_house);

        imbg=(ImageButton)findViewById(R.id.handle);//button
        mDrawer=(SlidingDrawer)findViewById(R.id.slidingdrawer);//drawer

        mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener()
        {
            @Override
            public void onDrawerOpened() {
                flag=true;
                imbg.setImageResource(R.drawable.ic_pet);
            }

        });

        mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener(){
            @Override
            public void onDrawerClosed() {
                flag=false;
                imbg.setImageResource(R.drawable.ic_pet);
            }

        });

        final Data data=new Data();
        award_data=data.getArwad();
        award=findViewById(R.id.award);
        award.setText("能量值为:"+award_data);
        myTextView = (TextView) findViewById(R.id.myTextView);
        seek = (SeekBar) findViewById(R.id.mySeekBar);
        linearLayout=(LinearLayout)findViewById(R.id.content_pet);
//        LottieAnimationView lottie_cat=(LottieAnimationView )linearLayout.findViewById(R.id.lottie_cat);
        LottieAnimationView lottie_cat=(LottieAnimationView )findViewById(R.id.lottie_cat);
        lottie_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose cat", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                myTextView.setText("宠物心情值为: " + data.getData_cat());
                seek.setProgress(data.getData_cat());
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_cat(data.getData_cat()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_cat());
                        seek.setProgress(data.getData_cat());
                    }
                });
                lottie.setAnimation("cat.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_rabbit=(LottieAnimationView )findViewById(R.id.lottie_rabbit);
        lottie_rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose rabbit", Toast.LENGTH_SHORT).show();
                myTextView.setText("宠物心情值为: " + data.getData_rabbit());
                seek.setProgress(data.getData_rabbit());
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_rabbit(data.getData_rabbit()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_rabbit());
                        seek.setProgress(data.getData_rabbit());
                    }
                });
                lottie.setAnimation("rabbit.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_fox=(LottieAnimationView )findViewById(R.id.lottie_fox);
        lottie_fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose fox", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                myTextView.setText("宠物心情值为: " + data.getData_fox());
                seek.setProgress(data.getData_fox());
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_fox(data.getData_rabbit()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_fox());
                        seek.setProgress(data.getData_fox());
                    }
                });
                lottie.setAnimation("fox.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_dog=(LottieAnimationView )findViewById(R.id.lottie_dog);
        lottie_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose dog", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                myTextView.setText("宠物心情值为: " + data.getData_dog());
                seek.setProgress(data.getData_dog());
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_dog(data.getData_dog()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_dog());
                        seek.setProgress(data.getData_dog());
                    }
                });
                lottie.setAnimation("dog.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_unicorn=(LottieAnimationView )findViewById(R.id.lottie_unicorn);
        lottie_unicorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose unicorn", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                myTextView.setText("宠物心情值为: " + data.getData_unicorn());
                seek.setProgress(data.getData_unicorn());
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_unicorn(data.getData_rabbit()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_unicorn());
                        seek.setProgress(data.getData_unicorn());
                    }
                });
                lottie.setAnimation("unicorn.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_squirrel=(LottieAnimationView )findViewById(R.id.lottie_squirrel);
        lottie_squirrel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose squirrel", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
                myTextView.setText("宠物心情值为: " + data.getData_squirrel());
                seek.setProgress(data.getData_squirrel());
                Button button=findViewById(R.id.buttonFood);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        award_data-=10;
                        award.setText("能量值为:"+award_data);
                        data.setData_squirrel(data.getData_rabbit()+10);
                        myTextView.setText("宠物心情值为: " + data.getData_squirrel());
                        seek.setProgress(data.getData_squirrel());
                    }
                });
                lottie.setAnimation("squirrel.json");
                lottie.playAnimation();
            }
        });
    }
}