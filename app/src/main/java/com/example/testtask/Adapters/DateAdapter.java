package com.example.testtask.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.R;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateHolder> {
    int[] dates = {3, 4, 5, 6, 7, 8,9,10,11};

    @NonNull
    @Override
    public DateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dateitem, parent, false);
        return new DateHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DateHolder holder, int position) {
        holder.date.setText("December " + String.valueOf(dates[position]));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.card.setCardBackgroundColor(Color.parseColor("#FF039BE5"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dates.length;
    }

    public class DateHolder extends RecyclerView.ViewHolder {
        TextView date;
        CardView card;

        public DateHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textView11);
            card=itemView.findViewById(R.id.card);
        }
    }
}
