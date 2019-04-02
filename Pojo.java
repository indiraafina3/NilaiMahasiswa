package com.dicoding.picodiploma.nilaimahasiswa;

public class Pojo {

    String nim, nama, huruf, jurusan;
    double total;

    public Pojo(){}
    public Pojo(String nim, String jurusan, String nama, String huruf,double total) {
        this.nim=nim;
        this.jurusan = jurusan;
        this.nama=nama;
        this.huruf=huruf;
        this.total=total;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHuruf() {
        return huruf;
    }

    public void setHuruf(String huruf) {
        this.huruf = huruf;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String golongan) {
        this.jurusan = golongan;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
