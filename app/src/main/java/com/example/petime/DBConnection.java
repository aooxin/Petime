package com.example.petime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public static int link (int detect,String name,String password2){
        final int[] qq = {0};
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
                    switch (detect){
                        //判断用户名是否存在
                        case 0:{
                            Statement st= connection.createStatement();
                            ResultSet rs = st.executeQuery("select * from Try where name="+name);
                            if (rs.next()) {
                                qq[0] =-1;
                            }
                            else
                                qq[0]=1;
                        }
                        case 1:{
                            String sql = "insert into Try "+ " values(" + "'" + name + "'" + "," + "'" + password2+ "'" + ")";
                            PreparedStatement ps = connection.prepareStatement(sql);
                            ps.execute(sql);
                        }
                        case 2:{
                            Statement st= connection.createStatement();
                            ResultSet rs = st.executeQuery("select * from Try where name="+name);
                            if(rs.next()){
                                if(!rs.getString("password").equals(password2))
                                    qq[0]= -1;
                                else
                                    qq[0]=1;
                            }
                        }
                    }

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
        return qq[0];
    }
}
