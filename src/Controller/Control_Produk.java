
package Controller;
import Model.*;
import Node.*;

public class Control_Produk {
    
    public void addProduk(String nama, String tgl, String brand, int stok,int harga, int idUser){
        int kode = Model.modelProduk.getLastkode();
        kode++;
        User foundUser = Model.modelUser.getUserId(idUser);
        if (foundUser != null) {
            Produk newProduk = new Produk(kode, nama, tgl, brand, stok, harga, foundUser);
            Model.modelProduk.tambahBarang(newProduk);
            System.out.println("berhasil ditambahkan");
        }
    }

    public Boolean deleteProduk(int kode) {
        Boolean del = Model.modelProduk.delete(kode);
        if (del){
            Model.modelProduk.commit();
            System.out.println("Delete berhasil !!!");
            Model.modelProduk.viewAllbarang();
        }else {
            System.out.println("barang tidak ketemu");
        }
        return del;
    }
}
