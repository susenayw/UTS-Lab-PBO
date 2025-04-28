import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\n=== Menu Manajemen Karyawan ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Gaji: ");
                    double gaji = scanner.nextDouble();
                    scanner.nextLine();

                    Karyawan karyawan = new Karyawan(id, nama, posisi, gaji);
                    if (perusahaan.tambahKaryawan(karyawan)) {
                        System.out.println("Karyawan berhasil ditambahkan.");
                    } else {
                        System.out.println("Gagal: ID sudah digunakan.");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan ID yang ingin dihapus: ");
                    id = scanner.nextLine();
                    if (perusahaan.hapusKaryawan(id)) {
                        System.out.println("Karyawan berhasil dihapus.");
                    } else {
                        System.out.println("Karyawan tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    posisi = scanner.nextLine();
                    if (perusahaan.ubahPosisi(id, posisi)) {
                        System.out.println("Posisi berhasil diubah.");
                    } else {
                        System.out.println("Karyawan tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    gaji = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (perusahaan.ubahGaji(id, gaji)) {
                        System.out.println("Gaji berhasil diubah.");
                    } else {
                        System.out.println("Karyawan tidak ditemukan atau gaji tidak valid.");
                    }
                    break;
                case 5:
                    System.out.println("\n=== Daftar Karyawan ===");
                    for (Karyawan k : perusahaan.getDaftarKaryawan()) {
                        System.out.println(k);
                    }
                    break;
                case 6:
                    System.out.println("Keluar program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
