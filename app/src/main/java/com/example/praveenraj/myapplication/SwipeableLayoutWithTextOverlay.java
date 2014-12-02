package com.example.praveenraj.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SwipeableLayoutWithTextOverlay extends RelativeLayout {
  private final ViewPager mPager;
  private final ChickletSlidePagerAdapter mPagerAdapter;

  private final TabPageIndicator indicator;
  private final View layout;


  public SwipeableLayoutWithTextOverlay(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    layout = inflater.inflate(R.layout.swipeable_layout, this, true);
    mPager = (ViewPager) findViewById(R.id.pager);
    mPagerAdapter = new ChickletSlidePagerAdapter(((MyActivity) context).getSupportFragmentManager());
    mPager.setAdapter(mPagerAdapter);

    indicator = (TabPageIndicator)findViewById(R.id.indicator);
    indicator.setViewPager(mPager);

    final ListLayout listview = (ListLayout) findViewById(R.id.overlay_list_view);
    String[] values = new String[]{"ATL to MSP", "BOM to ORD", "JFK to MSO","ATL to MSP", "BOM to ORD", "JFK to MSO","ATL to MSP", "BOM to ORD", "JFK to MSO","ATL to MSP", "BOM to ORD", "JFK to MSO"};
    final ArrayList<Card> list = new ArrayList<Card>();
    for (int i = 0; i < values.length; ++i) {
      Card card = new Card("Card " + (i + 1) + " Line 1", "Card " + (i + 1) + " Line 2");
      list.add(card);

    }

    final CardArrayAdapter cardAdapter = new CardArrayAdapter(context,
      android.R.layout.simple_list_item_1, list);
    listview.setAdapter(cardAdapter);
    listview.setExpanded(true);

  }
}
