package com.mycompany.klinikkecantikan;

// SUBCLASS 2
public class PerawatanTubuh extends Perawatan {
    private String areaTubuh; // contoh: Punggung, Kaki, Seluruh Tubuh

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
}
