import data.Klasifikasi;
import data.Pets;
import data.Supplies;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // ArrayList untuk menyimpan daftar hewan peliharaan dan supplies
    private static ArrayList<Pets> listPets = new ArrayList<>();
    private static ArrayList<Supplies> listSupplies = new ArrayList<>();
    // Scanner untuk input dari pengguna
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Menambahkan daftar untuk data Pet dan Supplies
        daftarPets();
        daftarsupplies();
        
        System.out.println("======== SELAMAT DATANG DI PETSHOP By DESINTA ========");
        System.out.println("What are you looking for?");
        System.out.println("1. Pet Catalog \n2. Supplies Catalog \n3. Search For Specific Supplies");
        System.out.println("4. Search For Pet Based On The Price\n5. Sort And Display All Items\n6. Update Items");
        System.out.println("7. Buy New Pet / Supplies\n8. Doesn't look for anything");
        System.out.print("Masukkan pilihan Anda (1-8): ");
        
        try {
            int pilihan = input.nextInt();
            input.nextLine(); // Consume newline left-over
            
            processUserChoice(pilihan);
     
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Pastikan input yang dimasukkan valid.");
        } finally {
            input.close();
        }
    }
    
    private static void daftarPets() {
        // Create pet objects
        Pets pet1 = new Pets(
            "British Short Hair", "British Blue", "3", 
            7000000, "Kucing", "4");
        Pets pet2 = new Pets(
            "Husky", "Gray & White", "5", 
            8000000, "Anjing", "2");
        Pets pet3 = new Pets(
            "Capybara", "Brown", "5", 
            12000000, "Capybara", "3");
      
        // Create new Klasifikasi object
        Klasifikasi kla1 = new Klasifikasi(
            "Lace Monitor", "Black & Cream", "1",
            700000, "Biawak", "2", "Reptile");
        Klasifikasi kla2 = new Klasifikasi(
            "Lontra Canadesis", "Brown", "1",
            6000000, "Otter", "2", "Mamalia");
    
        // Add to list
        listPets.add(pet1);
        listPets.add(pet2);
        listPets.add(pet3);
        listPets.add(kla1);
        listPets.add(kla2);
    }
    
    private static void daftarsupplies() {
        // Create supplies objects
        Supplies supplies1 = new Supplies(
            "Bolin's Secret Recipe Fish Collagen", "Vitamin Hewan", 120000, "15", 
            "Supplies anjing", LocalDate.of(2027, 5, 25));
        
        Supplies supplies2 = new Supplies(
            "WHISKAS cat dry tuna 1kg", "Makanan Hewan", 35000, "50", 
            "Supplies kucing", LocalDate.of(2027, 12, 26));
        
        Supplies supplies3 = new Supplies(
            "Pomapoo Sampo productnation", "Shampo Hewan", 50000, "20", 
            "Supplies kucing", LocalDate.of(2029, 5, 9));
        
        // Add to list
        listSupplies.add(supplies1);
        listSupplies.add(supplies2);
        listSupplies.add(supplies3);
    }

    // Method to process user choice 
    private static void processUserChoice(int pilihan) {
        switch (pilihan) {
            case 1:
                displayPets();
                break;
            case 2:
                displaySupplies();
                break;
            case 3:
                searchForSupplies();
                break;
            case 4:
                searchForPetByPrice();
                break;
            case 5:
                // Display before sorting
                displayBeforeSorting();
                // Sort and display after sorting
                sortAndDisplayItems();
                break;
            case 6:
                // Update and display changed items
                updateAndDisplayItems();
                break;
            case 7:
                menuPembelian();
                break;
            case 8:
                System.out.println("== Have A Great Day, Come Back If You Need New Pet Or Supplies ==");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }
    
    private static void displayPets() {
        System.out.println("== Daftar Hewan ==");
        for (Pets p : listPets) {
            p.displayInfo();
            System.out.println();
        }
    }
    
    private static void displaySupplies() {
        System.out.println("== Daftar Supplies ==");
        for (Supplies s : listSupplies) {
            s.displayInfo();
            System.out.println();
        }
    }

    private static void menuPembelian() {
        System.out.println("Pilih jenis pembelian:");
        System.out.println("1. Hewan\n2. Supplies");
        int pilihan = input.nextInt();
        input.nextLine();
    
        if (pilihan == 1) {
            displayPets();
            System.out.print("Masukkan nama jenis hewan yang ingin dibeli: ");
            String nama = input.nextLine();
            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();
            input.nextLine();
    
            for (Pets p : listPets) {
                if (p.getJenishwn().equalsIgnoreCase(nama)) {
                    int stok = Integer.parseInt(p.getjumlahstock());
                    if (jumlah <= stok) {
                        int total = p.gethargastock() * jumlah;
                        System.out.println("Total harga: Rp " + total);
                        p.setjumlahstock(String.valueOf(stok - jumlah));
                        System.out.println("Pembelian berhasil!");
                        return;
                    } else {
                        System.out.println("Stok tidak cukup.");
                        return;
                    }
                }
            }
            System.out.println("Hewan tidak ditemukan.");
    
        } else if (pilihan == 2) {
            displaySupplies();
            System.out.print("Masukkan nama barang yang ingin dibeli: ");
            String nama = input.nextLine();
            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();
            input.nextLine();
    
            for (Supplies s : listSupplies) {
                if (s.getNamabrng().equalsIgnoreCase(nama)) {
                    int stok = Integer.parseInt(s.getjumlahstock());
                    if (jumlah <= stok) {
                        int total = s.gethargastock() * jumlah;
                        System.out.println("Total harga: Rp " + total);
                        s.setjumlahstock(String.valueOf(stok - jumlah));
                        System.out.println("Pembelian berhasil!");
                        return;
                    } else {
                        System.out.println("Stok tidak cukup.");
                        return;
                    }
                }
            }
            System.out.println("Barang tidak ditemukan.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
    
    
    private static void searchForSupplies() {
        System.out.print("Masukkan nama barang yang dicari: ");
        String inputNama = input.nextLine();
        boolean ditemukanBarang = false;
        
        for (Supplies s : listSupplies) {
            if (s.getNamabrng().equalsIgnoreCase(inputNama)) {
                System.out.println("Barang ditemukan:");
                s.displayInfo();
                ditemukanBarang = true;
            }
        }
        
        if (!ditemukanBarang) {
            System.out.println("Tidak ditemukan barang dengan nama tersebut.");
        }
    }
    
    private static void searchForPetByPrice() {
        System.out.print("Masukkan harga yang dicari: ");
        int inputHarga = input.nextInt();
        input.nextLine(); // Consume newline
        boolean ditemukan = false;
        
        for (Pets p : listPets) {
            if (p.gethargastock() == inputHarga) {
                System.out.println("Hewan ditemukan:");
                p.displayInfo();
                ditemukan = true;
            }
        } 
        
        if (!ditemukan) {
            System.out.println("Tidak ditemukan hewan dengan harga tersebut.");
        }
    }
    
    private static void displayBeforeSorting() {
        System.out.println("\n___Daftar Hewan Sebelum Sorting___");
        for (Pets p : listPets) {
            p.displayInfo();
            System.out.println();

        }

        System.out.println("___Daftar Supplies Sebelum Sorting___");
        for (Supplies s : listSupplies) {
            s.displayInfo();
            System.out.println();

        }
    }
    
    private static void sortAndDisplayItems() {
        // Sort by price (ascending)
        listPets.sort(Comparator.comparingDouble(Pets::gethargastock));
        listSupplies.sort(Comparator.comparingDouble(Supplies::gethargastock));

        // Display after sorting
        System.out.println("\n== Daftar Hewan Setelah Disorting Berdasarkan Harga ==");
        for (Pets p : listPets) {
            p.displayInfo();
            System.out.println();

        }

        System.out.println("== Daftar Supplies Setelah Disorting Berdasarkan Harga ==");
        for (Supplies s : listSupplies) {
            s.displayInfo();
            System.out.println();
        }
    }
    
    private static void updateAndDisplayItems() {
        // Update pet information
        Pets pet1 = listPets.get(0);
        pet1.setJenishwn("Persia");
        pet1.setWarnahwn("Putih");
        pet1.setUmurhwn("2");
        pet1.setjumlahstock("5");
        pet1.sethargastock(2000000);
        
        System.out.println("__Informasi Hewan setelah perubahan__");
        pet1.displayInfo();
        System.out.println();

        // Update supplies information
        Supplies supplies1 = listSupplies.get(0);
        supplies1.setNamabrng("WHISKAS kitten cat dry salmon 2kg");
        supplies1.sethargastock(70000);
        supplies1.setjumlahstock("30");
        supplies1.setkategoristock("Supplies Kucing");
        supplies1.setTanggalKadaluarsa(LocalDate.of(2028, 5, 26));
        
        System.out.println("Informasi Supplies setelah perubahan:");
        supplies1.displayInfo();
    }
}