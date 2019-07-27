package com.marn.marn.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.marn.marn.OnItemClick;
import com.marn.marn.R;
import com.marn.marn.model.ItemsDetails;

import java.util.List;

public class AllItemsAdapter extends RecyclerView.Adapter<AllItemsAdapter.RewardsViewHolder> {

    private List<ItemsDetails> itemsList, selectedList;
    int adapterPosition;
    Context context;
    OnItemClick callback;
    Double totalPrice = 0.00;
    View view;

    public class RewardsViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price, description, rewardsType;
        public ImageView thumbnail;
        public CardView card;

        public RewardsViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.iv_item);
            title = (TextView) view.findViewById(R.id.tv_item_title);
            price = (TextView) view.findViewById(R.id.tv_item_price);
            card = (CardView) view.findViewById(R.id.cardview);
        }
    }


    public AllItemsAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        this.callback = onItemClick;
    }

    public AllItemsAdapter(Context context, List<ItemsDetails> itemsList, List<ItemsDetails> selectedList, OnItemClick onItemClick) {
        this.context = context;
        this.itemsList = itemsList;
        this.selectedList = selectedList;
        this.callback = onItemClick;
    }

    @Override
    public RewardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_all_item, parent, false);

        return new RewardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RewardsViewHolder holder, final int position) {
        final ItemsDetails item = itemsList.get(position);
        holder.thumbnail.setBackgroundResource(item.getImageSource());
        holder.title.setText(item.getTitle());
        holder.price.setText(item.getPrice() + " SAR");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedList.contains(item)) {
                    selectedList.remove(item);
                    unhighlightView(holder);
                    totalPrice = totalPrice - itemsList.get(position).getPrice();

                } else {
                    selectedList.add(item);
                    highlightView(holder);
                    totalPrice = totalPrice + itemsList.get(position).getPrice();
//                    int e[] = new int[2];
//                    holder.card.getLocationInWindow(e);
                }
                callback.onClick(selectedList.size(),totalPrice);
            }
        });
        if (selectedList.contains(item))
            highlightView(holder);
        else
            unhighlightView(holder);


    }

    private void highlightView(RewardsViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.selected));
    }

    private void unhighlightView(RewardsViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

}
