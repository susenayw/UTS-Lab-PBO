package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalKendaraan = 0;
        double totalBiaya = 0;

        while (true) {
            System.out.println("\n=== ParkirChan ===");
            System.out.println("Pilih jenis kendaraan (motor/mobil/truk): ");
            String jenisKendaraan = scanner.nextLine().toLowerCase();

            Kendaraan kendaraan = new Kendaraan(jenisKendaraan);

            System.out.println("Pilih cara input durasi parkir:");
            System.out.println("1. Input jumlah jam parkir secara manual");
            System.out.println("2. Input jam masuk dan jam keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan lama parkir dalam jam: ");
                int lamaParkir = scanner.nextInt();
                scanner.nextLine();
                kendaraan.hitungBiayaParkir(lamaParkir);
            } else if (pilihan == 2) {
                System.out.print("Masukkan jam masuk: ");
                int jamMasuk = scanner.nextInt();
                System.out.print("Masukkan jam keluar: ");
                int jamKeluar = scanner.nextInt();
                scanner.nextLine();
                kendaraan.hitungBiayaParkir(jamMasuk, jamKeluar);
            } else {
                System.out.println("Pilihan tidak valid. Ulangi lagi.");
                continue;
            }

            kendaraan.tampilkanRingkasan();

            totalKendaraan++;
            totalBiaya += kendaraan.getBiayaParkir();

            System.out.print("\nApakah ada kendaraan lain yang parkir? (ya/tidak): ");
            String lanjut = scanner.nextLine().toLowerCase();

            if (lanjut.equals("tidak")) {
                break;
            }
        }

        System.out.println("\n=== Ringkasan Akhir ===");
        System.out.println("Total Kendaraan: " + totalKendaraan);
        System.out.println("Total Biaya Parkir: Rp " + totalBiaya);
    }
}
