package com.example.praveenraj.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ChickletSlidePagerAdapter extends FragmentStatePagerAdapter {
  private static final int NUM_PAGES = 7;

  public ChickletSlidePagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {
    return new PriceListFragment();
  }

  @Override
  public int getCount() {
    return NUM_PAGES;
  }

  private static final String[] titles = { "one", "two", "three", "four", "five","six","seven" };

//...

  @Override
  public CharSequence getPageTitle(int position) {
    return titles[position];
  }
}
