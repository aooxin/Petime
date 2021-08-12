package com.example.petime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

//public class pethouse_activity extends AppCompatActivity {
//
//    LottieAnimationView lottie;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.pet_house);
//
//        lottie=findViewById(R.id.lottie);
////        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
//
//    }
//}
public class pethouse_activity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_bottom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_house);
        btn_bottom_dialog = (Button) findViewById(R.id.choose_pet);

        btn_bottom_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.choose_pet:
                setDialog();
                break;
            case R.id.lottie:
                Toast.makeText(this, "选择cat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lottie1:
                Toast.makeText(this, "选择rabbit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lottie2:
                Toast.makeText(this, "选择unicorn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lottie3:
                Toast.makeText(this, "选择dog", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lottie4:
                Toast.makeText(this, "选择fox", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void setDialog() {
        Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pet_house, null);
        //初始化视图
        root.findViewById(R.id.lottie).setOnClickListener(this);
        root.findViewById(R.id.lottie1).setOnClickListener(this);
        root.findViewById(R.id.lottie2).setOnClickListener(this);
        root.findViewById(R.id.lottie3).setOnClickListener(this);
        root.findViewById(R.id.lottie4).setOnClickListener(this);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }
}