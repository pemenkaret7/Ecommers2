package Model;
import Node.*;
import com.google.gson.reflect.TypeToken;
import modelJSON.*;

import java.util.ArrayList;

public class modelPembayaran {
    ModelJSON<Pembayaran> modelJSonPembayaran = new ModelJSON<>("src/Database/Pembayaran.json");

    public static ArrayList<Pembayaran> listbayar;

  public modelPembayaran(){
      listbayar = new ArrayList<>();
      listbayar = modelJSonPembayaran.readFromFile(new TypeToken<ArrayList<Pembayaran>>() {}.getType());

  }

  public void addTransaksi(int id, int total, User user , Produk produk ){
     listbayar.add(new Pembayaran(id, total, user, produk));
     modelJSonPembayaran.writeToFile(listbayar);
  }

  public int getlastkode (){
      if (listbayar.size()==0){
          return 0;
      }
      int id = listbayar.size() -1;
      return listbayar.get(id).Id;
  }

  public boolean cekUang (User user,int tot){
      if (user.getSaldo() > tot){
          return true;
      }
      System.out.println("saldo anda kurang!!");
      return false;
  }


}
