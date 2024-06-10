package View;
import Controller.Control_User;
import Node.*;
import Controller.Control_Produk;
import Model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class tampilan {
    Scanner scan = new Scanner(System.in);
    Control_Produk copro = new Control_Produk();
    Control_User couse = new Control_User();
    ProdukView pv = new ProdukView();
    PembayaranView pembayaranView = new PembayaranView();
    Keranjangview keranjangview = new Keranjangview();
    UserView userView = new UserView();

    public void menu(){
        System.out.println(" ");
        System.out.println("======== AIR SHOP ==============");
        System.out.println("1. Daftar akun ");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print ("pilih : ");
    }



    public void menu1(){
        System.out.println(" ");
        System.out.println(" ============ WELCOME TO MENU ==============");
        System.out.println("1. Update user");
        System.out.println("2. Pembelian ");
        System.out.println("3. Penjualan ");
        System.out.println("4. Update penjualan ");
        System.out.println("5. Tambah saldo ");
        System.out.println("6. Keranjang");
        System.out.println("7. Lihat barang penjualan");
        System.out.println("8. Riwayat transaksi ");
        System.out.println("9. EXIT");
        System.out.print ("Pilih : ");
    }

    public void menuUpdateUser(User user){
      userView.UpdateUSER(user);
    }

    public void menubeli(User user){
        System.out.println(" ");
        System.out.println("=== MENU PEMBELIAN ===");
        System.out.println("1 beli langsung ");
        System.out.println("2. Masukkan dalam keranjang ");
        System.out.print ("pilih : ");
        int pilih = scan.nextInt();
        switch (pilih){
            case 1 :
                pembayaranView.insertlangsungBayar(user);
                System.out.println("barang berhasil dibeli!!");
                    break;
            case 2 : keranjangview.ADDkeranjang(user);
                System.out.println("barang sudah dimasukkan dalam keranjang!!");
                    break;
        }
    }

    public void menuJual(User user){
        System.out.println(" ");
        System.out.println("\t == MENU PENJUALAN ==");
        System.out.println("1. MASUKKAN BARANG. ");
        System.out.println("2. HAPUS BARANG JUALAN. ");
        System.out.println("pilih : ");
        int pilih = scan.nextInt();
        switch (pilih){
            case 1: pv.insertProduk(user);
                System.out.println("Barang berhasil dijual!!");
                couse.viewbarangjualUSER(user);
            case 2:
                System.out.println("====== BARANG JUALAN ======");
                couse.viewbarangjualUSER(user);
                System.out.print("Masukkan kode barang yang akan dihapus : ");
                int kode = scan.nextInt();
                copro.deleteProduk(kode);
        }
    }

    public void menuUpdate(User user){
        System.out.println(" ");
        System.out.println("==== UPDATE ATRIBUTE BARANG ====");
        pv.UPDATEPRODUK(user);
    }

    public void menuTambahSaldo(User user){
        System.out.println(" ");
        System.out.println("======== PENAMBAHAN SALDO =========");
        System.out.println("(jumlah saldo yang dimasukkan minimal 5000).");
        System.out.print("MASUKKAN BERAPA JUMLAH SALDO : ");
        int sal = scan.nextInt();
        if (sal >= 5000) {
            couse.tambahSaldo(sal, user);
            System.out.println("Saldo berhasil ditambahkan!!");
        } else {
            System.out.println("Maaf, saldo harus ditambahkan minimal sejumlah 5000 dan harus bilangan bulat.");
        }
    }


    public void menuKeranjang(User user){
       UserView userView = new UserView();
        System.out.println(" ");
        System.out.println("======== LIST KERANJANG ===============");
           userView.showKeranjang(user);
           System.out.println("1. checkout barang");
           System.out.println("2. kurangi jumlah stoknya");
           System.out.println("3. kembali");
           System.out.print("pilih : ");
           int pilih = scan.nextInt();
           switch (pilih) {
               case 1:
                   System.out.println("_____________");
                   userView.showKeranjang(user);
                   pembayaranView.insertBayarkeranjang(user);
                   break;
               case 2:
                   System.out.println("____________");
                   userView.showKeranjang(user);
                   keranjangview.updatekurangiSTOKKeranjang(user);
                   break;
               default:
           }
       }

    public void menuLihatjualan (User user){
        System.out.println(" ");
        System.out.println(" ||==== List barang jualan =======|| ");
        couse.viewbarangjualUSER(user);
    }

    public void RiwayatTransaksi (User user){
        System.out.println(" ");
        System.out.println("||===== LIST RIWAYAT PEMBAYARAN ====||");
        pembayaranView.showTransaksi(user);
    }

}
