package com.mikazz.makeupperandori.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikazz.makeupperandori.R;
import com.mikazz.makeupperandori.models.Makeup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeupDisplayListAdapter extends RecyclerView.Adapter<MakeupDisplayListAdapter.MakeupViewHolder> {
    private List<Makeup> makeups = new ArrayList<>();
    private Context mContext;

    public MakeupDisplayListAdapter(Context context, List<Makeup> makeups) {
        mContext = context;
        this.makeups = makeups;
    }

    @Override
    public MakeupDisplayListAdapter.MakeupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_display_item, parent, false);
        MakeupViewHolder viewHolder = new MakeupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MakeupDisplayListAdapter.MakeupViewHolder holder, int position) {
        holder.bindMakeup(makeups.get(position));
    }

    @Override
    public int getItemCount() {
        return makeups.size();
    }

    public class MakeupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.makeupImageView) ImageView mMakeupImageView;
        @BindView(R.id.makeupNameTextView) TextView mMakeupNameTextView;
        @BindView(R.id.makeupPrice) TextView mMakeupPrice;
        private Context mContext;

        public MakeupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMakeup(Makeup makeup) {
            mMakeupNameTextView.setText(makeup.getName());
            mMakeupPrice.setText(makeup.getPrice());
            Picasso.with(mContext).load(makeup.getImageLink())
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.makeup)
                    .into(mMakeupImageView);





        }
    }
}
