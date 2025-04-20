package data;
import java.time.LocalDate;

// Sub Class Supplies yang mewarisi dari Stock
 public class Supplies extends stock {
    // Atribut private
    private String Nama;
    private String tipeproduk;
    private LocalDate tanggalKadaluarsa;

    // Konstruktor
    public Supplies(String Nama, String tipeproduk, int harga, String jumlah, String kategori, LocalDate tanggalKadaluarsa) {
        super(harga, jumlah, kategori); // Memanggil konstruktor kelas dasar
        setNamabrng(Nama);
        settipeproduk(tipeproduk);
        setTanggalKadaluarsa(tanggalKadaluarsa);
    }

    // Metode getter untuk studentID
    public String getNamabrng() {
        return Nama;
    }

    // Metode setter untuk studentID
    public void setNamabrng(String Nama) {
        this.Nama = Nama;
    }

    // Metode getter untuk major
    public String gettipeproduk() {
        return tipeproduk;
    }

    // Metode setter untuk major
    public void settipeproduk(String tipeproduk) {
        this.tipeproduk = tipeproduk;
    }

    // Metode getter untuk tanggalKadaluarsa
    public LocalDate getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    // Metode setter untuk tanggalKadaluarsa
    public void setTanggalKadaluarsa(LocalDate tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    // Metode untuk mengecek apakah barang sudah kadaluarsa
    public boolean isExpired() {
        return LocalDate.now().isAfter(tanggalKadaluarsa);
    }

   
    // Metode untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("Nama: " + getNamabrng());
        System.out.println("Tipe Produk: " + gettipeproduk());
        System.out.println("Harga: " + gethargastock());
        System.out.println("Jumlah Stock: " + getjumlahstock());
        System.out.println("Kategori: " + getkategoristock());
        System.out.println("Status Kadaluarsa: " + (isExpired() ? "Kadaluarsa" : "Masih Berlaku"));
        System.out.println("Tanggal Kadaluarsa: " + getTanggalKadaluarsa());
  }
}