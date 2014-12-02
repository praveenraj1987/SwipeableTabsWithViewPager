package com.example.praveenraj.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PriceArrayAdapter extends ArrayAdapter<Price> {
  private static final String TAG = "CardArrayAdapter";
  private List<Price> priceList = new ArrayList<Price>();


  public PriceArrayAdapter(Context context, int simple_list_item_1, ArrayList<Price> list) {
    super(context, simple_list_item_1, list);
      priceList = list;
  }


  static class PriceViewHolder {
    TextView line1;
    TextView line2;
  }

  @Override
  public void add(Price object) {
    priceList.add(object);
    super.add(object);
  }

  @Override
  public int getCount() {
    return this.priceList.size();
  }

  @Override
  public Price getItem(int index) {
    return this.priceList.get(index);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    PriceViewHolder viewHolder;
    if (row == null) {
      LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      row = inflater.inflate(R.layout.list_item_price, parent, false);
      viewHolder = new PriceViewHolder();
      viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
      viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
      row.setTag(viewHolder);
    } else {
      viewHolder = (PriceViewHolder) row.getTag();
    }
    Price price = getItem(position);
    viewHolder.line1.setText(price.getLine1());
    viewHolder.line2.setText(price.getLine2());
    return row;
  }
}