package com.example.petime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Todosql extends SQLiteOpenHelper {
    public Todosql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            //sql语句(可以参考上一篇博客),注意id需要加上_,这是要使用SimpleCursorAdapter的规定
            String sql = "create table Goods(_id integer PRIMARY KEY,textname text,setid integer,time integer,beginid integer,nameid integer)";
            sqLiteDatabase.execSQL(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //更新版本
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("oldVersion:"+i+" newVersion"+i1);
    }
    public void insertData(TodoList todo){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("_id",todo.getLayoutid());
        value.put("textname",todo.getTextname());
        value.put("setid",todo.getSetid());
        value.put("time",todo.getTime());
        value.put("beginid",todo.getBeginid());
        value.put("nameid",todo.getNameid());
        db.insert("Goods",null,value);
    }
    public void deletelist(String beginid){
        SQLiteDatabase db=getWritableDatabase();
        int i=db.delete("Goods","beginid like ?",new String[]{beginid});
    }
    public List<TodoList> query(){
        SQLiteDatabase db=getWritableDatabase();
        List<TodoList> list=new ArrayList<>();
        Cursor cursor = db.query("Goods",null,null,null,null,null,null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                String id=cursor.getString(cursor.getColumnIndex("_id"));
                String textname=cursor.getString(cursor.getColumnIndex("textname"));
                String setid= cursor.getString(cursor.getColumnIndex("setid"));
                String time= cursor.getString(cursor.getColumnIndex("time"));
                String beginid= cursor.getString(cursor.getColumnIndex("beginid"));
                String nameid= cursor.getString(cursor.getColumnIndex("nameid"));
                TodoList todoList=new TodoList();
                todoList.setLayoutid(id);
                todoList.setTextname(textname);
                todoList.setSetid(setid);
                todoList.setTime(time);
                todoList.setBeginid(beginid);
                todoList.setNameid(nameid);
                list.add(todoList);
            }
            cursor.close();
        }
        return list;
    }
    public int updatebase(TodoList todo){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("_id",todo.getLayoutid());
        value.put("textname",todo.getTextname());
        value.put("setid",todo.getSetid());
        value.put("time",todo.getTime());
        value.put("beginid",todo.getBeginid());
        value.put("nameid",todo.getNameid());
        return db.update("Goods",value,"beginid like ?",new String[]{todo.getBeginid()});
    }
    public int queryfromsetid(String setid){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.query("Goods",null,"setid like ?",new String[]{setid},null,null,null);
        if(cursor!=null){
            cursor.moveToNext();
            String beginid= cursor.getString(cursor.getColumnIndex("beginid"));
            cursor.close();
            return Integer.parseInt(beginid);
        }
        else{
            cursor.close();
            return -1;
        }
    }
    public int queryfromsetid2(String setid){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.query("Goods",null,"setid like ?",new String[]{setid},null,null,null);
        if(cursor!=null){
            cursor.moveToNext();
            String nameid= cursor.getString(cursor.getColumnIndex("nameid"));
            cursor.close();
            return Integer.parseInt(nameid);
        }
        else{
            cursor.close();
            return -1;
        }
    }
    public int queryfrombeginid(String beginid){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.query("Goods",null,"beginid like ?",new String[]{beginid},null,null,null);
        if(cursor!=null){
            cursor.moveToNext();
            String layoutid= cursor.getString(cursor.getColumnIndex("_id"));
            cursor.close();
            return Integer.parseInt(layoutid);
        }
        else{
            cursor.close();
            return -1;
        }
    }
    public int queryfrombeginid2(String beginid){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.query("Goods",null,"beginid like ?",new String[]{beginid},null,null,null);
        if(cursor!=null){
            cursor.moveToNext();
            String time= cursor.getString(cursor.getColumnIndex("time"));
            cursor.close();
            return Integer.parseInt(time);
        }
        else{
            cursor.close();
            return -1;
        }
    }
}


