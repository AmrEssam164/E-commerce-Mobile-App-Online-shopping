package com.amressam.navigation;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CartProducts> mProducts;

    private Context mContext;




    public CartRecyclerViewAdapter(ArrayList<CartProducts> products, Context context) {
        mProducts=products;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //called by the layout manager when it needs a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ShoppingDatabase shoppingDatabase = new ShoppingDatabase(mContext);
        final CartProducts cartProductItem = mProducts.get(position);
        holder.cart_product_image.setImageResource(cartProductItem.getImage());
        holder.cart_product_name.setText(cartProductItem.getName());
        holder.cart_product_price.setText(cartProductItem.getPrice()+" EGP");
        holder.cart_product_quantity.setText(String.valueOf(cartProductItem.getQuantity()));
        View.OnClickListener onClickListenerPlus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.valueOf(holder.cart_product_quantity.getText().toString());
                value++;
                holder.cart_product_quantity.setText(String.valueOf(value));
                shoppingDatabase.update_cart(cartProductItem.getName(),Integer.valueOf(holder.cart_product_quantity.getText().toString()));
            }
        };
        View.OnClickListener onClickListenerMinus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(holder.cart_product_quantity.getText().toString())>0){
                    int value = Integer.valueOf(holder.cart_product_quantity.getText().toString());
                    value--;
                    holder.cart_product_quantity.setText(String.valueOf(value));
                    shoppingDatabase.update_cart(cartProductItem.getName(),Integer.valueOf(holder.cart_product_quantity.getText().toString()));
                }
            }
        };
        View.OnClickListener onClickListenerCart = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Are you sure you want to delete this item from your cart?.").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mProducts.remove(position);
                        notifyDataSetChanged();
                        shoppingDatabase.delete_from_cart(cartProductItem.getName());
                        Toast.makeText(mContext,"Item deleted successfully.",Toast.LENGTH_LONG).show();

                    }
                }).setNegativeButton("No", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        };
        holder.cart_plus.setOnClickListener(onClickListenerPlus);
        holder.cart_minus.setOnClickListener(onClickListenerMinus);
        holder.edit_cart.setOnClickListener(onClickListenerCart);
    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.size();
    }

    void loadNewData(ArrayList<CartProducts> products) {
        this.mProducts = products;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cart_product_image;
        public TextView cart_product_name;
        public TextView cart_product_price;
        public ImageButton edit_cart;
        public ImageView cart_plus;
        public EditText cart_product_quantity;
        public ImageView cart_minus;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cart_product_image = (ImageView) itemView.findViewById(R.id.cart_product_image);
            this.cart_product_name = (TextView) itemView.findViewById(R.id.cart_product_name);
            this.cart_product_price = (TextView) itemView.findViewById(R.id.cart_product_price);
            this.edit_cart = (ImageButton) itemView.findViewById(R.id.edit_cart);
            this.cart_plus = (ImageView) itemView.findViewById(R.id.cart_plus);
            this.cart_product_quantity = (EditText) itemView.findViewById(R.id.cart_product_quantity);
            this.cart_minus = (ImageView) itemView.findViewById(R.id.cart_minus);
        }

    }
}
