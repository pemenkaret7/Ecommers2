package View;
import Controller.Control_User;
import Node.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class UserView {
    Scanner scan = new Scanner(System.in);
    Control_User con = new Control_User();


    public void ADDUSER(){
        System.out.println("==== Pembuatan username dan password ======");
        System.out.println("Masukkan username : ");
        String nm = scan.nextLine();
        System.out.print("Masukkan password : ");
        String pw = scan.nextLine();
        con.addUser(nm,pw);
        Model.modelUser.viewALLuser();
    }

    public void UpdateUSER(User user){
        System.out.println("PILIHAN UPDATE : ");
        System.out.println("1.Username");
        System.out.println("2.Password");
        System.out.print("PILIH : ");
        int pilih = scan.nextInt();
                scan.nextLine();
                switch (pilih){
                    case 1 :
                        System.out.print("Masukkan username baru : ");
                        String us = scan.nextLine();
                        Model.modelUser.updateNmUser(user.getID(),us);
                        System.out.println("update berhasil!!");
                        Model.modelUser.commit();
                        break;
                    case 2 :
                        System.out.print("Masukkan password baru : ");
                        String pass = scan.nextLine();
                        Model.modelUser.updatePASS(user.getID(),pass);
                        System.out.println("PASSWORD TELAH DIGANTI!!");
                        Model.modelUser.commit();
                        break;
                }
                System.out.println("===========");
                System.out.println("Setelah diupdate : ");
                Model.modelUser.listUser.get(user.getID()-1).viewUser();
                Model.modelUser.commit();

    }

    public void showKeranjang(User user) {

        int tot = 0;
        if (user.getKeranjang().isEmpty()) {
            System.out.println(" \t (-Keranjang kosong-)");
        } else {
            for (Keranjang barang : user.getKeranjang()) {
                System.out.println("Kode barang : " + barang.getBarang().getKode());
                System.out.println("Produk : " + barang.getBarang().getNamaBarang());
                System.out.println("Jumlah : " + barang.getJumlah());
                System.out.println("Harga per barang : " + barang.getBarang().getHarga());
                System.out.println("=========");
                tot += (barang.getJumlah() * barang.getBarang().getHarga());
            }
            System.out.println("(Jumlah total harga dalam keranjang : " + tot + ")");
        }
        System.out.println("-------------------------------------------");
    }


}
