package com.example.petime;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.petime.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

/**
 * 这个Activity要实现一个接口，用于响应菜单的单击事件，做出处理
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;//qaq why?qaq

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //获取抽屉布局并设置监听
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_setting)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Image的点击事件🤪
        //先定位到侧边
        LinearLayout linearLayout = (LinearLayout) navigationView.inflateHeaderView(R.layout.nav_header_main);
        //从侧边再定位到imageer_main);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You click Image", Toast.LENGTH_SHORT).show();
//              这个有一些奇怪的问题，应该是activity的生命的问题🤕
//                TODO：修改这个生命bug
                Intent intent2 = new Intent(MainActivity.this, changeimage.class);
                //Intent intent2=new Intent("com.example.activitytest.ACTIONSTART");
                startActivity(intent2);
            }
        });
        //增加数据库
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                DBConnection.link();
//            }
//        }).start();


        //    添加悬浮按钮的响应(m)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fab clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    //当菜单被选择的时候,在OnOptionsItemSelected()方法中实现.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {//获取菜单id
            case R.id.study:
                Intent intent = new Intent(MainActivity.this, study.class);
                item.setIntent(intent);
                break;
            case R.id.right_setting:
                Intent intent2 = new Intent(MainActivity.this, SettingsActivity.class);
                item.setIntent(intent2);
                break;
            case R.id.r_suggestion:
                Intent intent3 = new Intent(MainActivity.this, FeedbackActivity2.class);
                item.setIntent(intent3);
                break;
            default:
                Toast.makeText(MainActivity.this, "You click Button 1", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}