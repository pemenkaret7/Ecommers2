package Node;


public class Keranjang {

    private Produk barang;

    private int jumlah;

    public Keranjang(Produk barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }


    public void setBarang(Produk barang) {
        this.barang = barang;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Produk getBarang() {

        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }
}
