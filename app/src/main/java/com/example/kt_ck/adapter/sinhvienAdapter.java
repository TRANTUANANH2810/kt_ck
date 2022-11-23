package com.example.kt_ck.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kt_ck.R;
import com.example.kt_ck.model.sinhvien;

import java.util.List;

public class sinhvienAdapter extends BaseAdapter {
    private Context context;
    private List<sinhvien> list;

    public sinhvienAdapter(Context context, List<sinhvien> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_sinhvien_item,null);
        }
        TextView tvname = view.findViewById(R.id.tvName);
        TextView tvd = view.findViewById(R.id.tvDiem);

        sinhvien sv = list.get(i);
        tvname.setText(sv.getName());
        tvd.setText(""+sv.getDiemso());//vì diem là kieu float nen phai chuyen doi sang chuoi thi moi có the setText

        return view;
    }
}
