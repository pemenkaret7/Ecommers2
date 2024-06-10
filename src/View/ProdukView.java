package View;
import Controller.Control_Produk;
import Controller.Control_User;
import Node.*;
import Model.*;
import modelJSON.*;
import java.util.Scanner;

public class ProdukView {
   
    Scanner scan = new Scanner(System.in);
    Control_Produk controlProduk = new Control_Produk();
    Control_User controlUser = new Control_User();


    public void insertProduk(User user){
        System.out.println("============ Tambah produk ===========");
        System.out.print("Masukkan nama Barang : ");
        String nb = scan.nextLine();
        System.out.print("Masukkan tanggal : ");
        String tg = scan.nextLine();
        System.out.print("Masukkan nama Brand : ");
        String br = scan.nextLine();
        System.out.print("Masukkan jumlah stok barang : ");
        int sk = scan.nextInt();
        System.out.print("Berapa harga barang : ");
        int hg = scan.nextInt();
        scan.nextLine();
        controlProduk.addProduk(nb,tg,br,sk,hg, user.getID());
    }

    public void UPDATEPRODUK(User user) {
        System.out.println(" ");
        controlUser.viewbarangjualUSER(user);
        System.out.println("Masukkan kode barangnya : ");
        int kd = scan.nextInt();
        Produk produk = Model.modelProduk.getProduk(kd);
        if (produk != null){
            System.out.println("Barang ketemu !!!");
            if (user.getNama().equals(produk.user.getNama())){
                if (kd != -1){
                    System.out.println("--SILAHKAN PILIH UPDATE --");
                    System.out.println("1.nama barang");
                    System.out.println("2.Harga");
                    System.out.println("3.nama brand");
                    System.out.println("4.Stok");
                    System.out.println("Pilih : ");
                    int pilih = scan.nextInt();
                    scan.nextLine();
                    switch (pilih){
                        case 1:
                            System.out.print("Masukan nama barang : ");
                            String nm = scan.nextLine();
                            Model.modelProduk.updateNamaBarang(kd,nm);
                            System.out.println("Update Berhasil!!");
                            Model.modelProduk.commit();
                            break;
                        case 2:
                            System.out.print("Masukkan Harga barang : ");
                            int hg = scan.nextInt();
                            Model.modelProduk.updateHargabarang(kd,hg);
                            System.out.println("Update Berhasil!!");
                            Model.modelProduk.commit();
                            break;
                        case 3:
                            System.out.print("Masukkan nama Brand : ");
                            String br = scan.nextLine();
                            Model.modelProduk.updateNamaBrand(kd,br);
                            System.out.println("Update Berhasil!!");
                            Model.modelProduk.commit();
                            break;
                        case 4:
                            System.out.print("Masukkan nama stok barang : ");
                            int sk = scan.nextInt();
                            Model.modelProduk.updateStok(kd,sk);
                            System.out.println("Update Berhasil!!");
                            Model.modelProduk.commit();
                            break;
                    }
                    System.out.println("Setelah update : ");
                    Model.modelProduk.listproduk.get(kd).viewProduk();
                    Model.modelProduk.commit();
                }
            } else {
                System.out.println("Bukan barang anda");
            }
        }else {
            System.out.println("Barang tidak ketemu");
        }
    }
}
