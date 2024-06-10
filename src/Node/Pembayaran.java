package Node;

public class Pembayaran {
    public int Id;
    private int Harga;

    public User user;

    private Produk produk;
    public int jumlahbar;

    public Pembayaran(int id, int harga, User user, Produk produk) {
        this.Harga = harga;
        this.Id = id;
        this.user = user;
        this.produk = produk;
    }

    public void viewBayar(){
        System.out.println(" ");
        System.out.println("Nama pembeli : " + user.getNama());
        System.out.println("Nama Barang yang dibeli : " + produk.getNamaBarang());
//        System.out.println("Jumlah barang yang dibeli : "+ jumlahbar );
        System.out.println("Harga barang : " + Harga);
        }


    public Produk getProduk() {
        return produk;
    }
}
