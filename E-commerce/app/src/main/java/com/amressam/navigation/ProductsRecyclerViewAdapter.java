package com.amressam.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MoviesRecyclerViewAdapt";

    private ArrayList<Product> mProducts;

    private Context mContext;




    public ProductsRecyclerViewAdapter(ArrayList<Product> products, Context context) {
        mProducts=products;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //called by the layout manager when it needs a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ShoppingDatabase shoppingDatabase = new ShoppingDatabase(mContext);
        final Product productItem = mProducts.get(position);
        holder.product_image.setImageResource(productItem.getImage());
        holder.product_name.setText(productItem.getName());
        holder.product_price.setText(productItem.getPrice()+" EGP");
        View.OnClickListener onClickListenerPlus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.valueOf(holder.product_quantity.getText().toString());
                value++;
                holder.product_quantity.setText(String.valueOf(value));
            }
        };
        View.OnClickListener onClickListenerMinus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(holder.product_quantity.getText().toString())>0){
                    int value = Integer.valueOf(holder.product_quantity.getText().toString());
                    value--;
                    holder.product_quantity.setText(String.valueOf(value));
                }
            }
        };
        View.OnClickListener onClickListenerCart = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingDatabase.add_to_cart(productItem.getName(),productItem.getPrice(),
                        Integer.valueOf(holder.product_quantity.getText().toString()),productItem.getImage(),MainActivity.username.getText().toString());
                Toast.makeText(mContext, holder.product_quantity.getText().toString()
                        +" "+productItem.getName()+" added to your cart.", Toast.LENGTH_SHORT).show();
            }
        };
        holder.plus.setOnClickListener(onClickListenerPlus);
        holder.minus.setOnClickListener(onClickListenerMinus);
        holder.add_to_cart.setOnClickListener(onClickListenerCart);
    }

    @Override
    public int getItemCount() {
        if (null == mProducts) return 0;
        return mProducts.size();
    }

    public void loadNewData(ArrayList<Product> products) {
        this.mProducts = products;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView product_image;
        public TextView product_name;
        public TextView product_price;
        public ImageButton add_to_cart;
        public ImageView plus;
        public EditText product_quantity;
        public ImageView minus;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.product_image = (ImageView) itemView.findViewById(R.id.product_image);
            this.product_name = (TextView) itemView.findViewById(R.id.product_name);
            this.product_price = (TextView) itemView.findViewById(R.id.product_price);
            this.add_to_cart = (ImageButton) itemView.findViewById(R.id.add_to_cart);
            this.plus = (ImageView) itemView.findViewById(R.id.plus);
            this.product_quantity = (EditText) itemView.findViewById(R.id.product_quantity);
            this.minus = (ImageView) itemView.findViewById(R.id.minus);
        }

    }
}
