package Controller;
import Model.*;
import Node.*;

import java.util.ArrayList;
import java.util.List;

public class Control_User {

    public void addUser(String namer, String pass) {
            int id = Model.modelUser.getLasIdUser();
            id++;
        if (cekUsername(namer)|| cekPass(pass)) {
            User user = new User(id, namer, pass);
            Model.modelUser.createUser(user);
            System.out.println("Username dan password ditambahkan!!");
        } else {
            System.out.println("username atau password telah digunakan");
        }

    }

    public boolean cekUsername(String username) {
        List<User> userList = Model.modelUser.listUser;
        if (userList != null) {
            for (User user : userList) {
                if (user.getNama().equals(username)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean cekPass(String pass){
    List<User> userList = Model.modelUser.listUser;
    if (userList != null){
        for (User user: userList) {
            if (user.getPass().equals(pass)){
                return false;
            }
        }
    }
    return true;
    }

    public void tambahSaldo(int tambahsaldo,User user){
        int saldo = user.getSaldo() + tambahsaldo;
        user.setSaldo(saldo);
        Model.modelUser.commit();
    }

    public void viewbarangjualUSER(User user){
        ArrayList<Produk> produks = new ArrayList<>();

        for (Produk pro : Model.modelProduk.listproduk) {
            if (pro.user.getNama().equals(user.getNama())){
                produks.add(pro);
            }
        }

        if (produks.isEmpty()) {
            System.out.println("( Belum ada barang yang dijual oleh " + user.getNama() + " ). ");
        } else {
            for (Produk prok : produks) {
                System.out.println("BARANG YANG ("+ user.getNama() +") JUAL : ");
                System.out.println(" ");
                System.out.println("~~ Barang Ke- " + (produks.indexOf(prok)+1));
                prok.viewProduk();
            }
        }
    }


    }

