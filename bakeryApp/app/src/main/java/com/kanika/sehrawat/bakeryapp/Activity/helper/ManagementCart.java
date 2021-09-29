package com.kanika.sehrawat.bakeryapp.Activity.helper;

import android.content.Context;
import android.view.View;
import android.widget.Toast;


import com.kanika.sehrawat.bakeryapp.Activity.Interface.ChangeNumberItemsListener;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private Database database;

    public ManagementCart(Context context) {
        this.context = context;
        this.database = new Database(context);
    }


    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setQuantity(item.getQuantity());
        } else {
            listFood.add(item);
        }

        database.putListObject("CartList", listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(context, MainActivity.class);
        //startActivity(intent);
    }

    public ArrayList<FoodDomain> getListCart() {
        return database.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setQuantity(listfood.get(position).getQuantity() + 1);
        database.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public void MinusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getQuantity() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setQuantity(listfood.get(position).getQuantity() - 1);
        }
        database.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public void clearlist()
    {
        ArrayList<FoodDomain> listFood = getListCart();
        listFood.clear();
        database.putListObject("CartList", listFood);
    }


    public Double getTotalFee() {
        ArrayList<FoodDomain> listFood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood2.size(); i++) {
            fee = fee + (listFood2.get(i).getPrice() * listFood2.get(i).getQuantity());
        }
        return fee;
    }

}
