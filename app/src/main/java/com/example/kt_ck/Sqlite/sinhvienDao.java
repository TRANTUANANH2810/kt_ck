package com.example.kt_ck.Sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kt_ck.model.sinhvien;

import java.util.ArrayList;
import java.util.List;

public class sinhvienDao {
    private SQLiteDatabase db;
    //cótrustor cho phep khoi tao csdl
    public sinhvienDao(Context context){
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<sinhvien> get(String sql, String ...selectArgs){
        List<sinhvien> list = new ArrayList<>();
        Cursor cursor =db.rawQuery(sql,selectArgs);
        while (cursor.moveToNext()){
            sinhvien sv = new sinhvien();
            sv.setId(cursor.getString(cursor.getColumnIndex("id")));
            sv.setName(cursor.getString(cursor.getColumnIndex("name")));
            sv.setDiemso(cursor.getFloat(cursor.getColumnIndex("diemso")));
            //tra ve ds
            list.add(sv);
        }
        return list;
    }
    public  List<sinhvien> getAll(){
        String sql = "SELECT * FROM sinhvien";
        return get(sql);
    }
    //truyen vao id cua sinh vien
    public sinhvien getById(String id){
        String sql = "SELECT * FROM sinhvien WHERE id =?";
        List<sinhvien> list = get(sql,id);//gọi danh sach
        return list.get(0);
    }
    //them sinh vien đc truyen vao
    public long insert(sinhvien sv){
        ContentValues values = new ContentValues();
        values.put("id",sv.getId());
        values.put("name",sv.getName());
        values.put("diemso",sv.getDiemso());

        return db.insert("sinhvien",null,values);
    }
    public long update(sinhvien sv){
        ContentValues values = new ContentValues();
        values.put("name",sv.getName());
        values.put("diemso",sv.getDiemso());

        return db.update("sinhvien",values,"id=?",new String[]{sv.getId()});
    }
    public int delete(String id){

        return  db.delete("sinhvien","id=?",new String[]{id});
    }
}