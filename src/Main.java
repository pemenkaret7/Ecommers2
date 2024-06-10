import  Node.*;
import Model.*;
import View.*;
import Controller.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

//        Model.modelUser.createUser(new User(3, 5000, "pandu", "123"));
        ProdukView povie = new ProdukView();
        UserView viewuser = new UserView();
        Control_User cou = new Control_User();
//        Model.modelUser.createUser(new User(4, 5000, "dapin", "123"));
        PembayaranView pem = new PembayaranView();
        Keranjangview ker = new Keranjangview();
        User user = Model.modelUser.getUserId(1);
        tampilan tam = new tampilan();
//       tam.menuUpdate(user);
//        cou.viewbarangjualUSER(user);
//        cou.tambahSaldo(4000 , user);
//        Keranjang barang = new Keranjang(Model.modelProduk.getProduk(2), 4);
//        user.addKeranjang(barang);
//        ker.ADDkeranjang(user);
//        viewuser.showKeranjang(user);
//        ker.updatekurangiSTOKKeranjang(user);
//        viewuser.showKeranjang(user);
//        tam.menuKeranjang(user);
//        tam.menuLihatjualan(user);
//        tam.menubeli(user);
//        pem.showTransaksi(user);
//        tam.RiwayatTransaksi(user);
//        povie.UPDATEPRODUK(user);


        Model.modelUser.commit();

//        user.deleteKeranjang(0);
//
//        viewuser.showKeranjang(user.getKeranjang());
//
//        PembayaranView bayview = new PembayaranView();
//        bayview.insertBayar(user);
//
//                Model.modelUser.commit();
    }
}