package com.example.kt_ck.model;

public class sinhvien {
    private String id,name;
    private float diemso;

    public sinhvien() {
    }

    public sinhvien(String id, String name, float diemso) {
        this.id = id;
        this.name = name;
        this.diemso = diemso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiemso() {
        return diemso;
    }

    public void setDiemso(float diemso) {
        this.diemso = diemso;
    }
}
