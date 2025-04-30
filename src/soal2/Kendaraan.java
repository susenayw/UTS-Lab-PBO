package soal2;

public class Kendaraan {
    private String jenisKendaraan;
    private int lamaParkir;
    private double biayaParkir;

    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void hitungBiayaParkir(int lamaParkir) {
        this.lamaParkir = lamaParkir;
        switch (jenisKendaraan.toLowerCase()) {
            case "motor":
                biayaParkir = lamaParkir * 2000;
                break;
            case "mobil":
                biayaParkir = lamaParkir * 5000;
                break;
            case "truk":
                biayaParkir = lamaParkir * 8000;
                break;
            default:
                System.out.println("Jenis kendaraan tidak valid.");
        }
        if (lamaParkir > 5) {
            biayaParkir -= biayaParkir * 0.1;
        }
    }

    public void hitungBiayaParkir(int jamMasuk, int jamKeluar) {
        this.lamaParkir = jamKeluar - jamMasuk;
        hitungBiayaParkir(this.lamaParkir);
    }

    public void tampilkanRingkasan() {
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Lama Parkir: " + lamaParkir + " jam");
        System.out.println("Total Biaya Parkir: Rp " + biayaParkir);
    }

    public int getLamaParkir() {
        return lamaParkir;
    }

    public double getBiayaParkir() {
        return biayaParkir;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
}
