package com.example.petime;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class FeedbackActivity2 extends AppCompatActivity {
    private TextInputLayout mySuggestionSubmitLayout;
    private TextInputEditText mySuggestionSubmit;
    private Button btnSuggestionSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);
        initView();
    }

    private void initView() {
        mySuggestionSubmitLayout = (TextInputLayout) findViewById(R.id.feedback_sumit_layout);
        mySuggestionSubmit = (TextInputEditText) findViewById(R.id.feedback_sumit);
        btnSuggestionSubmit = (Button) findViewById(R.id.btn_feedback_sumit);
        // 在我们的这个位置的话就是设置我们的相关的意见反馈的界面
        mySuggestionSubmit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 在我们的这个位置的话就是判断我们输入的字体的输入的数量
                if(editable.length() > 150){
                    editable.delete(149,editable.length()-1);
                    // 在我们的这个位置的话就是弹出一个我们的toast的弹窗然后的自动的将我们的超出的部分进行删除

                }
            }
        });
        btnSuggestionSubmit.setOnClickListener(view -> {
            // 在我们的这个位置的话就是设置我们的相关的方法然后的话将我们的东西提交到我们的服务器
            HashMap<String,Object> map = new HashMap<>(); // 这个的话就是我们的hashmap的列表
            String s = mySuggestionSubmit.getText().toString();
            if(TextUtils.isEmpty(s)){
//                map.put("userId", CenterPeopleFragment.user.getUserId());
//                map.put("content" , s);
//
//                HttpUtil.getInstance().doPost("/userinfo/feedback", map, new OkhttpCallBack() {
//                    @Override
//                    public void successful(String successString) throws IOException {
//                        // 然后的话找我们的这个位置的话显示我们的就是toast
//                        MyApplication.showToast("意见提交成功");
//                    }
//
//                    @Override
//                    public void failuer(String errorString) {
//                        MyApplication.showToast("意见提交成功");
//                    }
//                });
                // todo 意见反馈为空请输入我们的内容
                Toast.makeText(FeedbackActivity2.this,"意见不能为空请重新输入",Toast.LENGTH_LONG).show();
            }else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //要连接的数据库url,注意：此处连接的应该是服务器上的MySQl的地址
                        String url = "jdbc:mysql://sh-cynosdbmysql-grp-7whhqd4o.sql.tencentcdb.com:23716/personal_info";
                        //连接数据库使用的用户名
                        String userName = "root";
                        //连接的数据库时使用的密码
                        String password = "Mmsqwcm.?";
                        Connection connection=null;
                        try {
                            //1、加载驱动
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            System.out.println("驱动加载成功！！！");
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        try {
                            //2、获取与数据库的连接
                            connection = DriverManager.getConnection(url, userName, password);
                            System.out.println("连接数据库成功！！！");

                            String sql = "insert into feedback "+ " values(" + "'" + s+ "'" + ")";
                            PreparedStatement ps = connection.prepareStatement(sql);
                            ps.execute(sql);


                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        finally {
                            if(connection!=null){
                                try {
                                    connection.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();

                Toast.makeText(FeedbackActivity2.this,"意见提交成功",Toast.LENGTH_LONG).show();
                mySuggestionSubmit.setText("");
                // 然后的话在我们的这个位置的话就是清空我们的输入框中的内容
                finish();
            }
        });

    }
}
