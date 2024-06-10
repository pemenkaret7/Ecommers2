package Model;
import Node.*;
import modelJSON.*;

import java.util.ArrayList;
import com.google.gson.reflect.*;

public class ModelUser {
    public ArrayList<User> listUser;

    ModelJSON<User> modelJSonUser ;

    public ModelUser(){
        modelJSonUser = new ModelJSON<>("src/Database/User.json");
        listUser = new ArrayList<>();
        loadUser();
    }

    public void loadUser(){
        listUser = modelJSonUser.readFromFile(new TypeToken<ArrayList<User>>() {}.getType());
    }

    public int getLasIdUser(){
        int id = 0;
        if (listUser != null) {
            for (User user : listUser) {
                id = user.getID();
            }
        }
        return id;
    }

    public User getUserId(int id){
        User user = null;
        for (User use : listUser){
            if (use.getID() == id){
                return use;
            }
        }
        return user;
    }

    public User getUserName(String username){
        User user = null;
        for (User use : listUser){
            if (use.getNama().equals(username)){
                return use;
            }
        }
        return user;
    }


    public boolean updateNmUser(int id,String name){
        User user = getUserId(id);
        if (user != null){
            user.setNama(name);
            return true;
        }
        return false;
    }

    public boolean updatePASS(int id,String pw){
        User user = getUserId(id);
        if (user.getID() == id){
            user.setPass(pw);
            return true;
        }
        return false;
    }

    public void createUser(User user){
        listUser.add(user);
        modelJSonUser.writeToFile(listUser);
    }

    public void viewALLuser() {
        if (listUser != null){
            for (int i = 0; i < listUser.size(); i++) {
                loadUser();
                listUser.get(i).viewUser();
                System.out.println("-----------------");
            }
        }
    }

    public void  updateSaldo(int id,int Saldo){
        User user = getUserId(id);
        if (user != null) {
            user.setSaldo(Saldo);
            modelJSonUser.writeToFile(listUser);
        }
    }

    public void kurangiKeranjang(User user,int kode,int jumlah){
        Produk produk = Model.modelProduk.getProduk(kode);
        if (produk != null) {
            user.delKeranjang(kode);
            System.out.println("Barang sudah keluar dari keranjang.");
        }
    }

    public void commit(){
        modelJSonUser.writeToFile(listUser);
    }
}
