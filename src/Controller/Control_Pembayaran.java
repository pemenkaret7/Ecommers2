package Controller;
import Model.*;
import Node.Pembayaran;
import Node.User;

public class Control_Pembayaran {

    public void tambahPembayaran(String user, int kode, int jumbar) {
        int totalPembayaran = Model.modelProduk.getProduk(kode).getHarga() * jumbar;
        int idPembayaran = Model.modelPembayaran.getlastkode() + 1;

        if (Model.modelPembayaran.cekUang(Model.modelUser.getUserName(user), totalPembayaran)) {
            if (jumbar <= Model.modelProduk.getProduk(kode).getStok()) {

                Model.modelPembayaran.addTransaksi(idPembayaran, totalPembayaran, Model.modelUser.getUserName(user), Model.modelProduk.getProduk(kode));

                Model.modelProduk.kurangiProduk(kode, jumbar);

                Model.modelUser.getUserName(user).kurangiSaldo(totalPembayaran);
                Model.modelUser.updateSaldo(Model.modelUser.getUserName(user).getID(), Model.modelUser.getUserName(user).getSaldo());
                System.out.println("Selamat pembayaran berhasil !! (Total Harga beli : " + totalPembayaran + " )");
            } else {
                if (Model.modelProduk.getProduk(kode).getStok() > 0) {
                    System.out.println(" ");
                    System.out.println("(Stok yang anda masukkan melebihi batas)");
                    System.out.println("Barang tidak bisa di checkout!!");
                } else {
                    System.out.println("STOK HABIS");
                }
            }
        } else {
            System.out.println("Pembayaran gagal. Saldo user tidak mencukupi.");
        }
    }

//    public void tambahPembayaranKER(String user, int kode,int jumbar){
//        int totPembayaran = Model.modelProduk.getProduk(kode).getHarga() * jumbar;
//        int idBarang = Model.modelProduk.getLastkode();
//        int idPembayaran = Model.modelPembayaran.getlastkode() + 1;
//
//        if (Model.modelPembayaran.cekUang(Model.modelUser.getUserName(user), totPembayaran)) {
//            if (jumbar <= Model.modelProduk.getProduk(kode).getStok()) {
//                Pembayaran pembayaran = new Pembayaran(idPembayaran, totPembayaran, Model.modelUser.getUserName(user), Model.modelProduk.listproduk);
//                Model.modelPembayaran.addTransaksi(pembayaran);
//
//                Model.modelProduk.kurangiProduk(idBarang,jumbar);
//
//                Model.modelUser.getUserName(user).kurangiSaldo(totPembayaran);
//                Model.modelUser.updateSaldo(Model.modelUser.getUserName(user).ID, Model.modelUser.getUserName(user).getSaldo());
//                System.out.println("Selamat pembayaran berhasil !! (Total Harga beli : " + totPembayaran + " )");
//            }else {
//                if (Model.modelProduk.getProduk(kode).getStok() > 0 ){
//                    System.out.println(" ");
//                    System.out.println("(Stok yang anda masukkan melebihi batas)");
//                    System.out.println("Barang tidak bisa di checkout!!");
//                } else {
//                    System.out.println("STOK HABIS");
//                }
//            }
//        } else {
//            System.out.println("Pembayaran gagal. Saldo user tidak mencukupi.");
//        }
//    }

    public void viewbayar(User user, int kode, int jumbar){
        System.out.println("Nama pembeli : " +  user);
        System.out.println("Nama barang yang dibeli: " + Model.modelProduk.getProduk(kode));
        System.out.println("Jumlah barang yang dibeli : " + jumbar);
        System.out.println("harga barang yang dibeli : "+ (Model.modelProduk.getProduk(kode).getHarga() * jumbar));
    }


}

