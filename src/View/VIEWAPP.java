package View;

import Node.User;
import Model.Model;
import java.util.ArrayList;
import java.util.Scanner;

public class VIEWAPP {
    public static void main(String[] args) {
        tampilan view = new tampilan();
        Scanner scan = new Scanner(System.in);
        UserView userView = new UserView();

        while (true) {
            view.menu();
            int choice = scan.nextInt(); scan.nextLine();
            switch (choice) {
                case 1:
                    userView.ADDUSER();
                    break;
                case 2:
                    System.out.print("Masukkan Username : ");
                    String us = scan.nextLine();
                    System.out.print("Masukkan Pass : ");
                    String pw = scan.nextLine();
                    for (User user1 : Model.modelUser.listUser) {
                        if (user1.getNama().equals(us)) {
                            if(user1.getPass().equals(pw)){
                                boolean login = true;
                                while (login) {
                                    view.menu1();
                                    int tampilanmenu = scan.nextInt();
                                    switch (tampilanmenu) {
                                        case 1:
                                            view.menuUpdateUser(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 2:
                                            view.menubeli(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 3:
                                            view.menuJual(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 4:
                                            view.menuUpdate(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 5:
                                            view.menuTambahSaldo(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 6:
                                            view.menuKeranjang(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 7:
                                            view.menuLihatjualan(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 8:
                                            view.RiwayatTransaksi(user1);
                                            Model.modelUser.commit();
                                            Model.modelProduk.commit();
                                            break;
                                        case 9 :
                                            System.exit(0);
                                            break;
                                        default:
                                            System.out.println("===== Pilihan tidak valid !!");
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Kata sandi atau pasword yang anda masukkan salah, Silakan masukkan dengan benar!!");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan yang anda masukkan tidak valid. Silakan pilih lagi!!");
                    break;
            }
        }
    }
}

