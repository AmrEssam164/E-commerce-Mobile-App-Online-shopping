package com.amressam.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.amressam.navigation.Product;
import com.amressam.navigation.ProductsRecyclerViewAdapter;
import com.amressam.navigation.R;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

    public static RecyclerView mProducts_recyclerview;
    public static ProductsRecyclerViewAdapter mProductsRecyclerViewAdapter;
    ArrayList<Product> selectedGategoryProducts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.product_fragment, container, false);
        mProductsRecyclerViewAdapter = new ProductsRecyclerViewAdapter(new ArrayList<Product>(),getContext());
        mProducts_recyclerview = (RecyclerView) root.findViewById(R.id.products_recycler_view);
        mProducts_recyclerview.setAdapter(mProductsRecyclerViewAdapter);
        mProductsRecyclerViewAdapter.loadNewData(selectedGategoryProducts);
        return root;
    }

    public void setSelectedGategoryProducts(ArrayList<Product> selectedGategoryProducts) {
        this.selectedGategoryProducts = selectedGategoryProducts;
    }
}
