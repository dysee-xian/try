package data;

// Sub Class Mamals yang mewarisi dari Pets
public class Klasifikasi extends Pets {
    private String klasifikasi; // Atribut private untuk klasifikasi hewan

    // Konstruktor
    public Klasifikasi(String Jenis, String Warna, String Umur, int harga, String kategori,
     String jumlah, String klasifikasi) {
        super(Jenis, Warna, Umur, harga, kategori, jumlah); // Memanggil konstruktor super kelas
        this.klasifikasi = klasifikasi;
    }

    // Metode getter untuk spesies
    public String getklasifikasi() {
        return klasifikasi;
    }

    // Metode setter untuk spesies
    public void setklasifikasi(String klasifikasi) {
        this.klasifikasi = klasifikasi;
    }

    // Override metode displayInfo untuk menampilkan informasi spesifik tentang burung
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil metode displayInfo dari kelas induk
        System.out.println("Klasifikasi Hewan: " + getklasifikasi());
    }
}