package com.mycompany.klinikkecantikan;

public class PerawatanWajah extends Perawatan implements DapatDijadwalkan, DapatDiberiDiskon {
    private String jenisKulit;

    public PerawatanWajah(String nama, int harga, int durasiMenit, String jenisKulit) {
        super(nama, harga, durasiMenit);
        setJenisKulit(jenisKulit);
    }

    public String getJenisKulit() { return this.jenisKulit; }

    public void setJenisKulit(String jenisKulit) {
        if (jenisKulit != null && !jenisKulit.trim().isEmpty()) {
            this.jenisKulit = jenisKulit;
        } else {
            System.out.println("Jenis kulit kosong, diset ke 'Semua Jenis'.");
            this.jenisKulit = "Semua Jenis";
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("%-10s | %-22s | %-12s | %3d menit | Kulit: %s%n",
                "[Wajah]", getNama(), formatRupiah(getHarga()), getDurasiMenit(), this.jenisKulit);
    }

    @Override
    public void infoPersiapan() {
        System.out.println("   -> Persiapan: wajah bersih tanpa make-up, hindari skincare aktif 1 hari sebelumnya.");
    }

    @Override
    public void prosesPerawatan() {
        System.out.println("   -> [PROSES WAJAH] Terapis membersihkan wajah, ekstraksi, lalu aplikasi masker.");
    }

    @Override
    public void hitungBiayaTambahan() {
        System.out.println("   -> [BIAYA] Biaya tambahan Rp 25.000 (serum khusus kulit " + this.jenisKulit + ").");
    }

    @Override
    public void jadwalkanKunjungan() {
        System.out.println("   -> [JADWAL] Kunjungan facial dijadwalkan, datang 10 menit lebih awal.");
    }

    @Override
    public void terapkanDiskon(int persen) {
        int hargaAkhir = getHarga() - (getHarga() * persen / 100);
        System.out.println("   -> [DISKON] Diskon " + persen + "% untuk perawatan wajah, harga menjadi "
                + formatRupiah(hargaAkhir) + ".");
    }
}
