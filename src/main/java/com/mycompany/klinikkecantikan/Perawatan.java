package com.mycompany.klinikkecantikan;

import java.util.Locale;

public abstract class Perawatan {
    private String nama;
    private int harga;
    private int durasiMenit;

    private static int totalPerawatan = 0;

    public Perawatan(String nama, int harga, int durasiMenit) {
        this.nama = nama;
        setHarga(harga);
        setDurasiMenit(durasiMenit);
        totalPerawatan++;
    }

    public String getNama() { return this.nama; }
    public int getHarga() { return this.harga; }
    public int getDurasiMenit() { return this.durasiMenit; }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama perawatan tidak boleh kosong!");
        }
    }

    public void setHarga(int harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0, diset ke Rp 10.000.");
            this.harga = 10000;
        }
    }

    public void setDurasiMenit(int durasiMenit) {
        if (durasiMenit >= 5 && durasiMenit <= 240) {
            this.durasiMenit = durasiMenit;
        } else {
            System.out.println("Durasi harus 5-240 menit, diset ke 30 menit.");
            this.durasiMenit = 30;
        }
    }

    public static int getTotalPerawatan() { return totalPerawatan; }

    public static String formatRupiah(int angka) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,d", angka);
    }

    public void tampilkanInfo() {
        System.out.printf("%-10s | %-22s | %-12s | %3d menit%n",
                "[Umum]", this.nama, formatRupiah(this.harga), this.durasiMenit);
    }

    public void infoPersiapan() {
        System.out.println("   -> Persiapan: datang 10 menit sebelum jadwal.");
    }

    public void prosesPerawatan() {
        System.out.println("   -> [PROSES] Perawatan umum dimulai oleh terapis.");
    }

    public abstract void hitungBiayaTambahan();
}
