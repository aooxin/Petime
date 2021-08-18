package com.example.petime;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class pethouse_activity extends Activity {
    private SlidingDrawer mDrawer;
    private ImageButton imbg;
    private Boolean flag=false;
    private LinearLayout linearLayout;
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

        linearLayout=(LinearLayout)findViewById(R.id.content_pet);
//        LottieAnimationView lottie_cat=(LottieAnimationView )linearLayout.findViewById(R.id.lottie_cat);
        LottieAnimationView lottie_cat=(LottieAnimationView )findViewById(R.id.lottie_cat);
        lottie_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose cat", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
                lottie.setAnimation("cat.json");
                lottie.playAnimation();
            }
        });
        LottieAnimationView lottie_rabbit=(LottieAnimationView )findViewById(R.id.lottie_rabbit);
        lottie_rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pethouse_activity.this, "You choose rabbit", Toast.LENGTH_SHORT).show();
                LottieAnimationView lottie=(LottieAnimationView )findViewById(R.id.lottie);
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
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
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
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
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
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
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
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
//                lottie.setImageAssetsFolder("/home/wufang/androidpetime/Petime/app/src/main/res/raw");
                lottie.setAnimation("squirrel.json");
                lottie.playAnimation();
            }
        });
    }
}