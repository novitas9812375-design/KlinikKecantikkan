package com.mycompany.klinikkecantikan;

import java.util.Scanner;

public class KlinikKecantikan {
    public static void cariPerawatan(String kataKunci, Perawatan[] daftar, int jumlah) {
        System.out.println("Mencari perawatan dengan nama mengandung: \"" + kataKunci + "\"");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().toLowerCase().contains(kataKunci.toLowerCase())) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Perawatan tidak ditemukan.");
    }

    public static void cariPerawatan(int hargaMaksimal, Perawatan[] daftar, int jumlah) {
        System.out.println("Mencari perawatan dengan harga maksimal " + Perawatan.formatRupiah(hargaMaksimal));
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHarga() <= hargaMaksimal) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Perawatan tidak ditemukan.");
    }

    public static void cariPerawatan(int hargaMin, int hargaMaks, Perawatan[] daftar, int jumlah) {
        System.out.println("Mencari perawatan dengan harga " + Perawatan.formatRupiah(hargaMin)
                + " sampai " + Perawatan.formatRupiah(hargaMaks));
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            int harga = daftar[i].getHarga();
            if (harga >= hargaMin && harga <= hargaMaks) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Perawatan tidak ditemukan.");
    }

    public static void jalankanFiturInterface(Perawatan perawatan) {
        if (perawatan instanceof DapatDijadwalkan) {
            DapatDijadwalkan bisaJadwal = (DapatDijadwalkan) perawatan;
            bisaJadwal.jadwalkanKunjungan();
        } else {
            System.out.println("   -> [JADWAL] Perawatan ini tidak mendukung penjadwalan khusus.");
        }

        if (perawatan instanceof DapatDiberiDiskon) {
            DapatDiberiDiskon bisaDiskon = (DapatDiberiDiskon) perawatan;
            bisaDiskon.terapkanDiskon(10);
        } else {
            System.out.println("   -> [DISKON] Perawatan ini tidak termasuk program diskon.");
        }
    }

    public static void simulasiPerawatan(Perawatan perawatan) {
        System.out.println("=== SIMULASI PERAWATAN: " + perawatan.getNama() + " ===");
        perawatan.infoPersiapan();
        perawatan.prosesPerawatan();
        perawatan.hitungBiayaTambahan();
        jalankanFiturInterface(perawatan);
    }

    public static int bacaAngka(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            if (scanner.hasNextInt()) {
                int nilai = scanner.nextInt();
                scanner.nextLine();
                return nilai;
            }
            scanner.nextLine();
            System.out.println("Input harus berupa angka!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Perawatan[] daftarPerawatan = new Perawatan[10];
            int jumlahPerawatan = 0;
            boolean isRunning = true;

            daftarPerawatan[jumlahPerawatan++] = new PerawatanWajah("Facial Acne Care", 250000, 60, "Berminyak");
            daftarPerawatan[jumlahPerawatan++] = new PerawatanWajah("Facial Hydrating", 300000, 75, "Kering");
            daftarPerawatan[jumlahPerawatan++] = new PerawatanTubuh("Body Scrub", 200000, 60, "Seluruh Tubuh");
            daftarPerawatan[jumlahPerawatan++] = new PerawatanRambut("Hair Spa", 180000, 50, "Keriting");
            daftarPerawatan[jumlahPerawatan++] = new PerawatanRambut("Creambath", 120000, 45, "Rontok");

            System.out.println("==============================================");
            System.out.println("   SELAMAT DATANG DI KLINIK KECANTIKAN GLOW   ");
            System.out.println("==============================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Perawatan");
                System.out.println("2. Lihat Daftar Perawatan");
                System.out.println("3. Cari Perawatan (Fitur Overloading)");
                System.out.println("4. Simulasi Perawatan (Fitur Dynamic Binding)");
                System.out.println("5. Keluar");
                int pilihan = bacaAngka(scanner, "Pilih Menu (1-5): ");

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahPerawatan < daftarPerawatan.length) {
                            System.out.println("\n-- Pilih Jenis Perawatan --");
                            System.out.println("1. Perawatan Wajah");
                            System.out.println("2. Perawatan Tubuh");
                            System.out.println("3. Perawatan Rambut");
                            int jenis = bacaAngka(scanner, "Pilihan (1/2/3): ");

                            if (jenis >= 1 && jenis <= 3) {
                                System.out.print("Masukkan Nama Perawatan: ");
                                String nama = scanner.nextLine();
                                int harga = bacaAngka(scanner, "Masukkan Harga (Rp): ");
                                int durasi = bacaAngka(scanner, "Masukkan Durasi (menit): ");

                                if (jenis == 1) {
                                    System.out.print("Masukkan Jenis Kulit (Berminyak/Kering/Sensitif/dll): ");
                                    String jenisKulit = scanner.nextLine();
                                    daftarPerawatan[jumlahPerawatan] =
                                            new PerawatanWajah(nama, harga, durasi, jenisKulit);
                                } else if (jenis == 2) {
                                    System.out.print("Masukkan Area Tubuh: ");
                                    String area = scanner.nextLine();
                                    daftarPerawatan[jumlahPerawatan] =
                                            new PerawatanTubuh(nama, harga, durasi, area);
                                } else {
                                    System.out.print("Masukkan Jenis Rambut (Lurus/Keriting/Rontok/dll): ");
                                    String jenisRambut = scanner.nextLine();
                                    daftarPerawatan[jumlahPerawatan] =
                                            new PerawatanRambut(nama, harga, durasi, jenisRambut);
                                }
                                jumlahPerawatan++;
                                System.out.println("Sukses! Perawatan berhasil ditambahkan.");
                            } else {
                                System.out.println("Jenis perawatan tidak valid.");
                            }
                        } else {
                            System.out.println("Maaf, daftar perawatan sudah penuh!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Perawatan di Klinik Glow ---");
                        if (jumlahPerawatan == 0) {
                            System.out.println("Belum ada perawatan yang terdaftar.");
                        } else {
                            for (int i = 0; i < jumlahPerawatan; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarPerawatan[i].tampilkanInfo();
                                daftarPerawatan[i].infoPersiapan();
                                daftarPerawatan[i].hitungBiayaTambahan();
                                jalankanFiturInterface(daftarPerawatan[i]);
                            }
                            System.out.println("\n* Total Perawatan Terdaftar: " + Perawatan.getTotalPerawatan());
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Perawatan --");
                        System.out.println("1. Cari berdasarkan Nama");
                        System.out.println("2. Cari berdasarkan Harga Maksimal");
                        System.out.println("3. Cari berdasarkan Rentang Harga");
                        int mode = bacaAngka(scanner, "Pilih (1/2/3): ");

                        if (mode == 1) {
                            System.out.print("Masukkan Nama / Kata Kunci: ");
                            String kunci = scanner.nextLine();
                            cariPerawatan(kunci, daftarPerawatan, jumlahPerawatan);
                        } else if (mode == 2) {
                            int maks = bacaAngka(scanner, "Masukkan Harga Maksimal (Rp): ");
                            cariPerawatan(maks, daftarPerawatan, jumlahPerawatan);
                        } else if (mode == 3) {
                            int min = bacaAngka(scanner, "Masukkan Harga Minimal (Rp): ");
                            int maks = bacaAngka(scanner, "Masukkan Harga Maksimal (Rp): ");
                            cariPerawatan(min, maks, daftarPerawatan, jumlahPerawatan);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("\n-- Simulasi Perawatan --");
                        if (jumlahPerawatan == 0) {
                            System.out.println("Belum ada perawatan yang terdaftar.");
                        } else {
                            for (int i = 0; i < jumlahPerawatan; i++) {
                                System.out.println((i + 1) + ". " + daftarPerawatan[i].getNama());
                            }
                            int nomor = bacaAngka(scanner, "Pilih nomor perawatan: ");
                            if (nomor >= 1 && nomor <= jumlahPerawatan) {
                                simulasiPerawatan(daftarPerawatan[nomor - 1]);
                            } else {
                                System.out.println("Nomor tidak valid.");
                            }
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan Klinik Glow!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");
                }
            }
        }
    }
}
