package com.example.w5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.w5.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {
    private Context context;

    private final ArrayList<InfoModel> localDataSet;
    private final ArrayList<ConstraintLayout> containers = new ArrayList<>();
    private  final TextView selector;

    public static class InfoModel {
        private final String avatarUrl;
        private final String name;
        private final String phone;

        public InfoModel(String avatarUrl, String name, String phone) {
            this.avatarUrl = avatarUrl;
            this.name = name;
            this.phone = phone;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout container;
        private final ImageView avatar;
        private final TextView name;
        private final TextView phone;

        public ViewHolder(View view) {
            super(view);

            container = view.findViewById(R.id.info_container);
            avatar = view.findViewById(R.id.info_avatar);
            name = view.findViewById(R.id.info_name);
            phone = view.findViewById(R.id.info_phone);
        }
    }

    public InfoAdapter(ArrayList<InfoModel> dataSet, TextView selector) {
        localDataSet = dataSet;
        this.selector = selector;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        this.context = viewGroup.getContext();

        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.component_info, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        InfoModel data = localDataSet.get(position);

        viewHolder.name.setText(data.name);
        viewHolder.phone.setText(data.phone);

        this.containers.add(viewHolder.container);


        viewHolder.container.setOnClickListener(v -> {
            String selectorText = "You choose: " + data.name;
            this.selector.setText(selectorText);

            for (int i = 0; i < localDataSet.size(); i++) {
                this.containers.get(i).setBackgroundResource(R.color.white);
            }

            this.containers.get(position).setBackgroundResource(R.color.selected);
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
