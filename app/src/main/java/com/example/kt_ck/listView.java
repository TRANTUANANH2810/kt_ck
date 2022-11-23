package com.example.kt_ck;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class listView extends AppCompatActivity {
    ListView lvta;
    ArrayList<ThucAn> arrayThucan;
    ThucanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        AnhXa();
        adapter = new ThucanAdapter(this, R.layout.layout_listview, arrayThucan);
        lvta.setAdapter(adapter);
        lvta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThucAn ta = arrayThucan.get(i);
                doOpenMainActivity2(ta.getTen(), ta.getMota(), ta.getHinh());
            }
        });
        lvta.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

    }

    private void AnhXa() {
        lvta = (android.widget.ListView) findViewById(R.id.lvThucan);
        arrayThucan = new ArrayList<>();
        arrayThucan.add(new ThucAn("Táo ", "Táo Phú Sĩ hay Táo Fuji\nlà tên gọi của một giống táo\n đường (táo đỏ) lai được phát \nhiện và nhân rộng bởi những \nchuyên gia cây trồng tại Trạm nghiên\n cứu Tohoku (農林省園芸試験場東北支場: \nNông lâm tỉnh, viên nghiệp thí nghiệm\n trường, Đông Bắc chi trường) \nthuộc thị trấn Fujisaki, Aomori,\n Nhật Bản vào những năm \n1930[1] và được đưa ra thị trường \ntrong năm 1962.", R.drawable.tao));
        arrayThucan.add(new ThucAn("Dứa", "Dứa có các tên gọi khác\n như là: khóm, thơm, khớm, gai\n hoặc huyền nương, tên khoa học \nAnanas comosus, là một loại quả \nnhiệt đới.", R.drawable.quadua));
        arrayThucan.add(new ThucAn("Đào", "Đào (danh pháp khoa học: \nPrunus persica) là một loài cây\n được trồng để lấy quả hay hoa. \nNó là một loài cây sớm rụng lá,\n thân gỗ nhỏ, có thể cao tới 5–10 m.\n Lá của nó có hình mũi mác,\n dài 7–15 cm và rộng 2–3 cm...", R.drawable.quadao));
        arrayThucan.add(new ThucAn("Thanh long", "Thanh long một loài cây được \ntrồng chủ yếu để lấy quả \nvà cũng là tên của một vài chi \ncủa họ xương rồng. Thanh long là \nloài thực vật bản địa tại México\n, các nước Trung Mỹ và Nam Mỹ...", R.drawable.quathanhlong));

    }

    private void XacNhanXoa(final int position) {

        AlertDialog.Builder alerDiaLog = new AlertDialog.Builder(this);
        alerDiaLog.setTitle("Thong bao !");
        alerDiaLog.setIcon(R.mipmap.ic_launcher);
        alerDiaLog.setMessage("Bạn có muốn xóa hay không?");

        alerDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                arrayThucan.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alerDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alerDiaLog.show();
    }

    public void doOpenMainActivity2(String title, String des, int image) {
        Intent myIntent;
        myIntent = new Intent(this, Chuyentrang.class);
        myIntent.putExtra("title", title);
        myIntent.putExtra("image", image);
        myIntent.putExtra("des", des);
        startActivity(myIntent);
    }
}