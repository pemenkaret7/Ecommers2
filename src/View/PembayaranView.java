package View;
import Controller.Control_Pembayaran;
import Node.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PembayaranView {

    Scanner scan = new Scanner(System.in);
    Control_Pembayaran controlPembayaran = new Control_Pembayaran();
    UserView userView = new UserView();
    Keranjangview keranjangview = new Keranjangview();

    public void insertlangsungBayar(User user){
        System.out.println(" ");
        System.out.println("USER PEMBELI : "+user.getNama());
        System.out.println("=== Market =====");
        Model.modelProduk.viewAllbarang();
        System.out.print ("Masukkan kode barang yang akan dibeli : ");
        int kode = scan.nextInt();
        if (Model.modelProduk.getProduk(kode) != null){
            Model.modelProduk.getProduk(kode).viewproduk();
        System.out.print ("Berapakah jumlah barang yang akan dibeli : ");
        int brp = scan.nextInt();
       controlPembayaran.tambahPembayaran(user.getNama(), kode,brp);
       Model.modelProduk.commit();
        }else {
            System.out.println("Barang gaada bang");
        }
    }

    public void insertBayarkeranjang(User user){
        System.out.println("Masukkan Kode barang yang akan di checkout : ");
        int kode = scan.nextInt();
        for (Keranjang keranjang : user.getKeranjang()) {
            if (keranjang.getBarang().getKode() == kode) {
                int jml = keranjang.getJumlah();
                System.out.println("jumlah barang yang dimasukkan dalam keranjang : " + jml);
                controlPembayaran.tambahPembayaran(user.getNama(), kode, jml);
                keranjangview.kurangiKeranjang(user, kode, jml);
                Model.modelUser.commit();
                Model.modelProduk.commit();
                return;
            }
        }
        System.out.println("Barang dengan kode " + kode + " tidak ditemukan dalam keranjang!!!");
    }

    public void showTransaksi(User user){
        System.out.println(" ==================================");
        System.out.println("( Transaksi dari "+user.getNama()+" )");
        System.out.println("===================================");
        ArrayList<Pembayaran> bay = new ArrayList<>();
        for (Pembayaran pem : Model.modelPembayaran.listbayar) {
            if (pem.user.getID() == user.getID()){
                bay.add(pem);
            }
        }
        for (Pembayaran bayar:bay) {
            System.out.println(" ");
            System.out.print("transaksi ke - " + (bay.indexOf(bayar)+1) );
            bayar.viewBayar();
        }

    }


}
