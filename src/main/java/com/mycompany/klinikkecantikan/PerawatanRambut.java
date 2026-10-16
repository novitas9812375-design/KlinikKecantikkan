package com.mycompany.klinikkecantikan;

// SUBCLASS 3 (BARU di Modul 6)
public class PerawatanRambut extends Perawatan {
    private String jenisRambut; // contoh: Lurus, Keriting, Berminyak, Rontok

    public PerawatanRambut(String nama, int harga, int durasiMenit, String jenisRambut) {
        super(nama, harga, durasiMenit);
        setJenisRambut(jenisRambut);
    }

    public String getJenisRambut() { return this.jenisRambut; }

    public void setJenisRambut(String jenisRambut) {
        if (jenisRambut != null && !jenisRambut.trim().isEmpty()) {
            this.jenisRambut = jenisRambut;
        } else {
            System.out.println("Jenis rambut kosong, diset ke 'Semua Jenis'.");
            this.jenisRambut = "Semua Jenis";
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("%-10s | %-22s | %-12s | %3d menit | Rambut: %s%n",
                "[Rambut]", getNama(), formatRupiah(getHarga()), getDurasiMenit(), this.jenisRambut);
    }

    @Override
    public void infoPersiapan() {
        System.out.println("   -> Persiapan: keramas ringan sebelum datang, jangan memakai cat rambut 3 hari sebelumnya.");
    }

    @Override
    public void prosesPerawatan() {
        System.out.println("   -> [PROSES RAMBUT] Terapis melakukan scalp massage lalu hair mask untuk rambut " + this.jenisRambut + ".");
    }
}
