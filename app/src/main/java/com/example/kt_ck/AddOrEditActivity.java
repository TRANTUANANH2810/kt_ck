package com.example.kt_ck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kt_ck.Sqlite.sinhvienDao;
import com.example.kt_ck.model.sinhvien;
public class AddOrEditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtsvid, edtname, edtdiemso;
    private Button btnluu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit);
        edtsvid = findViewById(R.id.edtSvid);
        edtname = findViewById(R.id.edtSvName);
        edtdiemso = findViewById(R.id.edtSvDiem);

        btnluu = findViewById(R.id.btnluu);
        btnluu.setOnClickListener(this);
        findViewById(R.id.btnlistsv).setOnClickListener(this);

        ReadSinhVien();

    }

    private void ReadSinhVien() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if (bundle == null) {
            return;
        }
        String id = bundle.getString("id");

        sinhvienDao dao = new sinhvienDao(this);
        sinhvien sv = dao.getById(id);

        edtsvid.setText(sv.getId());
        edtname.setText(sv.getName());
        edtdiemso.setText("" + sv.getDiemso());

        btnluu.setText("Chỉnh sửa");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnluu:
                sinhvienDao dao = new sinhvienDao(this);
                sinhvien sv = new sinhvien();

                sv.setId(edtsvid.getText().toString());
                sv.setName(edtname.getText().toString());
                sv.setDiemso(Float.parseFloat(edtdiemso.getText().toString()));
                //su dung chung 1 nut
                if (btnluu.getText().equals("Lưu")) {//nếu nut luu hiển thị save thì thực hiện insert còn "update" thì thực hiện update
                    dao.insert(sv);
                } else {
                    dao.update(sv);
                }

                Toast.makeText(this, "Sinh vien moi da duoc luu!",
                        Toast.LENGTH_SHORT).show();
                break;

        }
    }
}