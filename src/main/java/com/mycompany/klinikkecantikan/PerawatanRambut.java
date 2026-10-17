package com.mycompany.klinikkecantikan;

public class PerawatanRambut extends Perawatan implements DapatDiberiDiskon {
    private String jenisRambut;

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

    @Override
    public void hitungBiayaTambahan() {
        System.out.println("   -> [BIAYA] Biaya tambahan Rp 20.000 (vitamin rambut " + this.jenisRambut + ").");
    }

    @Override
    public void terapkanDiskon(int persen) {
        int hargaAkhir = getHarga() - (getHarga() * persen / 100);
        System.out.println("   -> [DISKON] Diskon " + persen + "% untuk perawatan rambut, harga menjadi "
                + formatRupiah(hargaAkhir) + ".");
    }
}
