import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Karyawan implements Serializable {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;

    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        setGaji(gaji); // Validasi gaji melalui setter
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setGaji(double gaji) {
        if (gaji >= 0) {
            this.gaji = gaji;
        } else {
            throw new IllegalArgumentException("Gaji tidak boleh negatif.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: " + gaji;
    }
}

class Perusahaan {
    private List<Karyawan> daftarKaryawan;
    private final String filePath = "karyawan.txt";

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
        loadData();
    }

    public boolean tambahKaryawan(Karyawan karyawan) {
        if (cariKaryawanById(karyawan.getId()) == null) {
            daftarKaryawan.add(karyawan);
            simpanData();
            return true;
        }
        return false;
    }

    public boolean hapusKaryawan(String id) {
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            daftarKaryawan.remove(k);
            simpanData();
            return true;
        }
        return false;
    }

    public boolean ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawanById(id);
        if (k != null) {
            k.setPosisi(posisiBaru);
            simpanData();
            return true;
        }
        return false;
    }

    public boolean ubahGaji(String id, double gajiBaru) {
        Karyawan k = cariKaryawanById(id);
        if (k != null && gajiBaru >= 0) {
            k.setGaji(gajiBaru);
            simpanData();
            return true;
        }
        return false;
    }

    public Karyawan cariKaryawanById(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k;
            }
        }
        return null;
    }

    public List<Karyawan> getDaftarKaryawan() {
        return daftarKaryawan;
    }

    private void simpanData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Karyawan k : daftarKaryawan) {
                bw.write(k.getId() + "," + k.getNama() + "," + k.getPosisi() + "," + k.getGaji());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    daftarKaryawan.add(new Karyawan(data[0], data[1], data[2], Double.parseDouble(data[3])));
                }
            }
        } catch (IOException e) {
        }
    }
}
