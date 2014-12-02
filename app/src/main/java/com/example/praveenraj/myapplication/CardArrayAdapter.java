package com.example.praveenraj.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.praveenraj.myapplication.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardArrayAdapter extends ArrayAdapter<Card> {
  private static final String TAG = "CardArrayAdapter";
  private List<Card> cardList = new ArrayList<Card>();


  public CardArrayAdapter(Context context, int simple_list_item_1, ArrayList<Card> list) {
    super(context, simple_list_item_1, list);
    for (int i = 0; i < list.size(); ++i) {
      Card card = new Card("Card " + (i + 1) + " Line 1", "Card " + (i + 1) + " Line 2");
      cardList.add(card);
    }
  }

  static class CardViewHolder {
    TextView line1;
    TextView line2;
  }

  public CardArrayAdapter(Context context, int textViewResourceId) {
    super(context, textViewResourceId);
  }

  @Override
  public void add(Card object) {
    cardList.add(object);
    super.add(object);
  }

  @Override
  public int getCount() {
    return this.cardList.size();
  }

  @Override
  public Card getItem(int index) {
    return this.cardList.get(index);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    CardViewHolder viewHolder;
    if (row == null) {
      LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      row = inflater.inflate(R.layout.list_item_card, parent, false);
      viewHolder = new CardViewHolder();
      viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
      viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
      row.setTag(viewHolder);
    } else {
      viewHolder = (CardViewHolder) row.getTag();
    }
    Card card = getItem(position);
    viewHolder.line1.setText(card.getLine1());
    viewHolder.line2.setText(card.getLine2());
    return row;
  }

}