package com.amressam.navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.amressam.navigation.R;

import java.util.ArrayList;

import static com.amressam.navigation.MainActivity.my_menu;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";
    RecyclerView mCartRecyclerView;
    ArrayList<CartProducts> cartProducts;
    CartRecyclerViewAdapter mCartRecyclerViewAdapter;
    public static String reciver;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cart_fragment, container, false);
        mCartRecyclerView = (RecyclerView) root.findViewById(R.id.cart_recycler_view);
        mCartRecyclerViewAdapter = new CartRecyclerViewAdapter(new ArrayList<CartProducts>(),getContext());
        mCartRecyclerView.setAdapter(mCartRecyclerViewAdapter);
        mCartRecyclerViewAdapter.loadNewData(cartProducts);
        reciver = MapsActivity.addressLine;
        return root;
    }

    public void setCartProducts(ArrayList<CartProducts> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public void onResume() {
        reciver = MapsActivity.addressLine;
        super.onResume();
    }
}
