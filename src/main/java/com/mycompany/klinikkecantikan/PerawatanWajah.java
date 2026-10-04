package com.mycompany.klinikkecantikan;

// SUBCLASS 1
public class PerawatanWajah extends Perawatan {
    private String jenisKulit; // contoh: Berminyak, Kering, Sensitif

    public PerawatanWajah(String nama, int harga, int durasiMenit, String jenisKulit) {
        super(nama, harga, durasiMenit); // panggil constructor induk
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
}
