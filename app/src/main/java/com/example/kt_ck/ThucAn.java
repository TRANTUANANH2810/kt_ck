package com.example.kt_ck;

public class ThucAn {
    private String ten;
    private String mota;
    private int hinh;


    public ThucAn(String ten, String mota, int hinh) {
        this.ten = ten;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}

