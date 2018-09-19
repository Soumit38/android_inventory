package com.soumit.inventorymanager.dump;


import android.app.Activity;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.soumit.inventorymanager.R;
import com.soumit.inventorymanager.data.StockItem;

public class StockAdapter extends BaseAdapter{

    private static final String TAG = "StockAdapter";
    private Activity activity;
    private LayoutInflater inflater;
    private List<StockItem> stockItems;
    private Cursor cursor;

    public StockAdapter() {
    }

    public StockAdapter(Activity activity, LayoutInflater inflater, List<StockItem> stockItems, Cursor c) {
        this.activity = activity;
        this.inflater = inflater;
        this.stockItems = stockItems;
        this.cursor = c;
    }

    @Override
    public int getCount() {
        return stockItems.size();
    }

    @Override
    public Object getItem(int position) {
        return stockItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder mHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            mHolder = new ViewHolder();

            mHolder.nameTextView = (TextView) convertView.findViewById(R.id.product_name);
            mHolder.quantityTextView = (TextView) convertView.findViewById(R.id.quantity);
            mHolder.priceTextView = (TextView) convertView.findViewById(R.id.price);
            mHolder.sale = (ImageView) convertView.findViewById(R.id.sale);
            mHolder.image = (ImageView) convertView.findViewById(R.id.image_view);

            StockItem item = stockItems.get(position);


            convertView.setTag(mHolder);
        }else {
            mHolder = (ViewHolder)convertView.getTag();
        }

        return convertView;
    }


  private class ViewHolder{
      TextView nameTextView ;
      TextView quantityTextView;
      TextView priceTextView;
      ImageView sale;
      ImageView image;
  }








}
