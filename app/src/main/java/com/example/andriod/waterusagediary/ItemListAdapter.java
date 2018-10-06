package com.example.andriod.waterusagediary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private int resource;

    public ItemListAdapter(Context context, int resource, ArrayList<Item> object)
    {
        super(context,resource,object);
        mContext = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String date = getItem(position).getDate();
        String amount = getItem(position).getAmount();

        //Item item = new Item(name,date,amount);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(this.resource,parent,false);

        TextView tvDate = convertView.findViewById(R.id.textView62);
        TextView tvAmount = convertView.findViewById(R.id.textView58);

        tvDate.setText(date);
        tvAmount.setText(amount);

        return convertView;
    }
}


