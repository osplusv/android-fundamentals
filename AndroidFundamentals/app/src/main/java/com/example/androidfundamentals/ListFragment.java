package com.example.androidfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Osvaldo Villagrana on 2/22/16.
 */
public class ListFragment extends android.app.ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] values = new String[] { "Android", "iOS", "Windows Mobile", "Blackberry", "WebOS", "Mac OS X" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detalleFragment);

        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(item);
        } else {
            Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);
            intent.putExtra("value", item);
            startActivity(intent);
        }
    }
}
