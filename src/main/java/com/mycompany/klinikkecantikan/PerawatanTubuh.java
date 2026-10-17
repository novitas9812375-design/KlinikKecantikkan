package com.mycompany.klinikkecantikan;

public class PerawatanTubuh extends Perawatan implements DapatDijadwalkan {
    private String areaTubuh;

    public PerawatanTubuh(String nama, int harga, int durasiMenit, String areaTubuh) {
        super(nama, harga, durasiMenit);
        setAreaTubuh(areaTubuh);
    }

    public String getAreaTubuh() { return this.areaTubuh; }

    public void setAreaTubuh(String areaTubuh) {
        if (areaTubuh != null && !areaTubuh.trim().isEmpty()) {
            this.areaTubuh = areaTubuh;
        } else {
            System.out.println("Area tubuh kosong, diset ke 'Seluruh Tubuh'.");
            this.areaTubuh = "Seluruh Tubuh";
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("%-10s | %-22s | %-12s | %3d menit | Area: %s%n",
                "[Tubuh]", getNama(), formatRupiah(getHarga()), getDurasiMenit(), this.areaTubuh);
    }

    @Override
    public void infoPersiapan() {
        System.out.println("   -> Persiapan: gunakan pakaian longgar, disarankan mandi sebelum perawatan.");
    }

    @Override
    public void prosesPerawatan() {
        System.out.println("   -> [PROSES TUBUH] Terapis memijat dan melulur area " + this.areaTubuh + ".");
    }

    @Override
    public void hitungBiayaTambahan() {
        System.out.println("   -> [BIAYA] Biaya tambahan Rp 15.000 (minyak aromaterapi area " + this.areaTubuh + ").");
    }

    @Override
    public void jadwalkanKunjungan() {
        System.out.println("   -> [JADWAL] Sesi perawatan tubuh dijadwalkan, mohon datang dalam kondisi segar.");
    }
}
