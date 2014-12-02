package com.example.praveenraj.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PriceListFragment extends Fragment {
static int i=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      ViewGroup rootView = (ViewGroup) inflater.inflate(
        R.layout.swipeable_list, container, false);

      final ListLayout listview = (ListLayout) rootView.findViewById(R.id.swipeable_listview);
      String[] values = new String[] { "$50.00", "$60.00", "$70.00","$50.00", "$60.00", "$70.00","$50.00", "$60.00", "$70.00","$50.00", "$60.00", "$70.00" };
      final ArrayList<Price> list = new ArrayList<Price>();
      this.i++;
      for (int i = 0; i < values.length; ++i) {
        Price p = new Price(values[i], "some text" + this.i);
        list.add(p);
      }

      final PriceArrayAdapter adapter = new PriceArrayAdapter(getActivity().getApplicationContext(),
        android.R.layout.simple_list_item_1, list);

      listview.setAdapter(adapter);
      listview.setExpanded(true);
      adapter.notifyDataSetChanged();

      return rootView;

    }

}
