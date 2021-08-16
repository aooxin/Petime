package com.example.petime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class study extends AppCompatActivity {
    //Button索引
    private LinkedList<Button> ListBtn_Show;
    //TextView索引
    private LinkedList<TextView> ListText_time;
    private Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    private Button btn_add, btn_edit,begin;
    //判断btn_edit的状态
    private TextView textView,textname;
    private int EDITSTATE = 0;
    private int begin_id=1000;
    private int time_id=2000;
    private int name_id=3000;
    static int time=0;
    static int count=1;
    private PopupWindow popWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.activity_study);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        inited();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void inited() {
        final LinearLayout linearLayout;
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        ListBtn_Show = new LinkedList<Button>();
        ListText_time=new LinkedList<TextView>();
        final LayoutInflater inflater=LayoutInflater.from(this);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout ly=(LinearLayout)inflater.inflate(R.layout.activity_todo,linearLayout,false).findViewById(R.id.todo_layout);
                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.addView(ly);
                begin=(Button)findViewById(R.id.begin);
                begin.setId(begin_id);
                ListBtn_Show.add(begin);
                begin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(study.this,"Begin",Toast.LENGTH_SHORT).show();
                        int i = 0;
                        for (; i <ListBtn_Show.size(); i++) {
                            if (ListBtn_Show.get(i) == view) {
                                i=map.get(ListBtn_Show.get(i).getId());
                                break;
                            }
                        }
                        TextView te=findViewById(i);
                        String h=te.getText().toString();
                        h=h.substring(0,h.length()-2);
                        time=Integer.parseInt(h);
                        Intent intent=new Intent(study.this,clock.class);
                        intent.putExtra("data",time);
                        startActivity(intent);
                    }
                });
                textname=(TextView)findViewById(R.id.todo_name);
                textname.setId(name_id);
                textView=(TextView)findViewById(R.id.todo_time);
                textView.setId(time_id);
                map.put(begin_id,time_id);
                name_id++;
                time_id++;
                begin_id ++;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showPopupWindow();
                    }
                });
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断编辑按钮的状态
                if (EDITSTATE == 0) {
                    btn_edit.setText("确定");
                    EDITSTATE = 1;
                } else if (EDITSTATE == 1) {
                    btn_edit.setText("编辑");
                    EDITSTATE = 0;
                }
            }
        });

    }
    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(study.this).inflate(R.layout.clockpopup, null);
        popWindow = new PopupWindow(contentView,
                650, 590, true);
        popWindow.setContentView(contentView);
        Button OK=(Button)contentView.findViewById(R.id.OK);
        EditText ed_time=(EditText)contentView.findViewById(R.id.time);
        EditText ed_title=(EditText)contentView.findViewById(R.id.title);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_time.getText().toString().equals(""))
                {textView.setText(20+"分钟");}
                else
                    textView.setText(ed_time.getText().toString()+"分钟");
                if(ed_title.getText().toString().equals("")){textname.setText("Untitle");}
                else
                    textname.setText(ed_title.getText());
                popWindow.dismiss();
            }
        });
        View rootview = LayoutInflater.from(study.this).inflate(R.layout.activity_study, null);
        popWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
    }

}
