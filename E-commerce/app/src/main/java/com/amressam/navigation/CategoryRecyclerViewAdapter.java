package com.amressam.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CategoryImages> mCategoryImages;

    private Context mContext;

    private final CategoryRecyclerViewAdapter.AdapterOnClickHandler mClickHandler;

    public interface AdapterOnClickHandler {
        void onCategoryClicked(int position);
    }



    public CategoryRecyclerViewAdapter(ArrayList<CategoryImages> categoryImages, Context context,CategoryRecyclerViewAdapter.AdapterOnClickHandler clickHandler) {
        mCategoryImages=categoryImages;
        mContext = context;
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //called by the layout manager when it needs a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CategoryImages categoryImages = mCategoryImages.get(position);
        holder.category_image.setImageDrawable(this.mContext.getResources().getDrawable(categoryImages.getImage()));
    }

    @Override
    public int getItemCount() {
        if (null == mCategoryImages) return 0;
        return mCategoryImages.size();
    }

    void loadNewData(ArrayList<CategoryImages> categoryImages) {
        this.mCategoryImages = categoryImages;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView category_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_image = (ImageView) itemView.findViewById(R.id.category_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onCategoryClicked(adapterPosition);
        }
    }
}
