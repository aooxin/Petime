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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private Todosql todosql;
    private List<TodoList> list;
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
        todosql = new Todosql(study.this,"test_carson",null, 2);
        list=todosql.query();
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
                TodoList todo=new TodoList();
                todo.setBeginid(Integer.toString(begin_id));
                todo.setSetid(Integer.toString(time_id));
                todo.setNameid(Integer.toString(name_id));
                begin_id++;
                time_id++;
                name_id++;
                todo.setTextname("Todo1");
                todo.setTime("20");
                todosql.insertData(todo);
                add_todo(inflater,linearLayout,todo);
                ++count;
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
        for (TodoList good : list) {
            add_todo(inflater,linearLayout,good);
            ++count;
        }
        begin_id+=count;
        time_id+=count;
        name_id+=count;
    }
    private void add_todo(LayoutInflater inflater,LinearLayout linearLayout,TodoList todo1){
        LinearLayout ly=(LinearLayout)inflater.inflate(R.layout.activity_todo,linearLayout,false).findViewById(R.id.todo_layout);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(ly);
        begin=(Button)findViewById(R.id.begin);
        begin.setId(Integer.parseInt(todo1.getBeginid()));
        ListBtn_Show.add(begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(study.this,"Begin",Toast.LENGTH_SHORT).show();
                int k=view.getId();
                int i =todosql.queryfrombeginid(Integer.toString(view.getId()));
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
        textname.setId(Integer.parseInt(todo1.getNameid()));
        textname.setText(todo1.getTextname());
        textView=(TextView)findViewById(R.id.todo_time);
        textView.setId(Integer.parseInt(todo1.getSetid()));
        textView.setText(todo1.getTime()+"分钟");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view.getId(),todosql.queryfromsetid2(Integer.toString(view.getId())));
            }
        });
    }

    private void showPopupWindow(int i,int nid) {
        //设置contentView
        View contentView = LayoutInflater.from(study.this).inflate(R.layout.clockpopup, null);
        popWindow = new PopupWindow(contentView,
                650, 590, true);
        popWindow.setContentView(contentView);
        Button OK=(Button)contentView.findViewById(R.id.OK);
        EditText ed_time=(EditText)contentView.findViewById(R.id.time);
        EditText ed_title=(EditText)contentView.findViewById(R.id.title);
        textView=(TextView)findViewById(i);
        textname=findViewById(nid);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodoList todo=new TodoList();
                if(ed_time.getText().toString().equals(""))
                {textView.setText(20+"分钟");
                    todo.setTime("20");}
                else {
                    textView.setText(ed_time.getText().toString() + "分钟");
                    todo.setTime(ed_time.getText().toString());
                }
                if(ed_title.getText().toString().equals(""))
                {
                    textname.setText("Untitle");
                    todo.setTextname("Untitle");
                }
                else
                {
                    textname.setText(ed_title.getText());
                    todo.setTextname(ed_title.getText().toString());
                }
                popWindow.dismiss();
                todo.setBeginid(Integer.toString(todosql.queryfromsetid(Integer.toString(i))));
                todo.setSetid(Integer.toString(i));
                todo.setNameid(Integer.toString(nid));
                int i=todosql.updatebase(todo);
                System.out.println(i);
            }
        });
        View rootview = LayoutInflater.from(study.this).inflate(R.layout.activity_study, null);
        popWindow.showAtLocation(rootview, Gravity.CENTER, 0, 0);
    }

}
