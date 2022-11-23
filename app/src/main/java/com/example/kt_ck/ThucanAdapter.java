package com.example.kt_ck;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThucanAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThucAn> thucAnList;

    public ThucanAdapter(Context context, int layout, List<ThucAn> thucAnList) {
        this.context = context;
        this.layout = layout;
        this.thucAnList = thucAnList;
    }

    @Override
    public int getCount() {
        return thucAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //tra ve dong tren item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //anh xa
        TextView txtten = (TextView) view.findViewById(R.id.nameText);
        TextView txtmota = (TextView) view.findViewById(R.id.motaText);
        ImageView imghinh =(ImageView) view.findViewById(R.id.imageview);
        // gan gia tri
        ThucAn thucAn = thucAnList.get(i);

        txtten.setText(thucAn.getTen());
        txtmota.setText(thucAn.getMota());
        imghinh.setImageResource(thucAn.getHinh());

        return view;
    }
}

