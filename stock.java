package data;

// Super Class Person
class stock {
    // Atribut private
    private Integer harga;
    private String kategori;
    protected String jumlah;

    // Konstruktor
    public stock(int harga, String kategori, String jumlah) {
        sethargastock(harga);
        setkategoristock(kategori);
        setjumlahstock(jumlah);
    }

    // Metode getter untuk harga
    public Integer gethargastock() {
        return harga;
    }

    // Metode setter untuk harga
    public void sethargastock(Integer harga) {
        this.harga = harga;
    }

    // Metode getter untuk kategori
    public String getkategoristock() {
        return kategori;
    }

    // Metode setter untuk kategori
    public void setkategoristock(String kategori) {
        this.kategori = kategori;
    }

    // Metode getter untuk jumlah stock
    public String getjumlahstock() {
        return jumlah;
    }

    // Metode setter untuk jumlah stock
    public void setjumlahstock(String jumlah) {
        this.jumlah = jumlah;
    }

}
