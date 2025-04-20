package data;

// Sub Class Pets yang mewarisi dari Stock
public class Pets extends stock{
    // Atribut private
    private String Jenis;
    private String Warna;
    private String Umur;


    // Konstruktor
    public Pets(String Jenis, String Warna, String Umur, int harga, String kategori, String jumlah) {
        super(harga, kategori, jumlah); // Memanggil konstruktor super kelas
        setJenishwn(Jenis);
        setWarnahwn(Warna);
        setUmurhwn(Umur);

    }

    // Metode getter untuk Jenis Hewan
    public String getJenishwn() {
        return Jenis;
    }

    // Metode setter untuk Jenis Hewan
    public void setJenishwn(String Jenis) {
        this.Jenis = Jenis;
    }

    // Metode getter untuk warna hewan
    public String getWarnahwn() {
        return Warna;
    }

    // Metode setter untuk warna hewan
    public void setWarnahwn(String Warna) {
        this.Warna = Warna;
    }

    // Metode getter untuk Umur Hewan
    public String getUmurhwn() {
        return Umur;
    }

    // Metode setter untuk Umur Hewan
    public void setUmurhwn(String Umur) {
        this.Umur = Umur;
    }

    // Metode untuk menampilkan informasi Hewan

    public void displayInfo() {
        System.out.println("Jenis Hewan: " + getJenishwn());
        System.out.println("Warna: " + getWarnahwn());
        System.out.println("Umur: " + getUmurhwn() + " Bulan");
        System.out.println("Harga: " + gethargastock());
        System.out.println("Jumlah Stock: " + getjumlahstock());
        System.out.println("Kategori: " + getkategoristock());
    }
}  