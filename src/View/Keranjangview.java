package View;

import Node.*;
import Model.*;
import Controller.Control_Produk;
import Controller.Control_User;
import Model.modelProduk;

import java.util.Scanner;

public class Keranjangview {
//    modelProduk modelpro = new modelProduk();
//    Scanner scan = new Scanner(System.in);
//    Control_Produk controlProduk = new Control_Produk();
//    Control_User controlUser = new Control_User();
    UserView userView = new UserView();
    Scanner scan = new Scanner(System.in);
    public void ADDkeranjang(User user){
        Model.modelProduk.viewAllbarang();
        System.out.print("Masukkan kode barang : ");
        int br = scan.nextInt();
        Produk produk = Model.modelProduk.getProduk(br);
        if (produk != null){
            System.out.print("Masukkan jumlah barang : ");
            int jm = scan.nextInt();
            for (Keranjang KER : user.getKeranjang()) {
                if (KER.getBarang().getKode() == br){
                    KER.setJumlah(KER.getJumlah() + jm);
                    Model.modelUser.commit();
                    Model.modelProduk.commit();
                    return;
                }
            }
            Keranjang keranjang = new Keranjang(produk,jm);
            user.addKeranjang(keranjang);
            Model.modelUser.commit();
            Model.modelProduk.commit();
        } else {
            System.out.println("Barang tidak ada!!!");
        }
    }

    public void deletekeranjang(User user){
        System.out.print("Masukkan kode barang : ");
        int br = scan.nextInt();
        Produk produk = Model.modelProduk.getProduk(br);
        if (produk != null){
            user.delKeranjang(br);
        }else {
            System.out.println("barang tidak ditemukan");
        }
    }

    public void updatekurangiSTOKKeranjang(User user) {
        boolean kode = false;
        System.out.println(" ==== Kurangi jumlah barang dalam keranjang ===== ");
        System.out.print("Masukkan kode barang : ");
        int br = scan.nextInt();
        for (Keranjang ker : user.getKeranjang()) {
            if (ker.getBarang().getKode() == br) {
                kode = true;
                break;
            }
        }
        if (kode == true) {
            System.out.print("Masukkan jumlah stoknya : ");
            int jml = scan.nextInt();

            for (Keranjang ker : user.getKeranjang()) {
                if (ker.getBarang().getKode() == br) {
                    ker.setJumlah(ker.getJumlah() - jml);
                    if (ker.getJumlah() <= 0) {
                        user.delKeranjang(br);
                        System.out.println("( Barang " + ker.getBarang().getNamaBarang() + " sudah dihapus karena stok yang disimpan dalam keranjang telah kosong)");
                        userView.showKeranjang(user);
                        return;
                    }
                    break;
                }
            }
        } else {
            System.out.println("Barang dengan kode " + br + " tidak ditemukan dalam keranjang.");
        }
    }





    public void kurangiKeranjang(User user,int kode,int jumlah){
        Produk produk = Model.modelProduk.getProduk(kode);
        if (produk != null) {
            user.delKeranjang(kode);
            System.out.println("Barang sudah keluar dari keranjang.");
        }
    }

}
