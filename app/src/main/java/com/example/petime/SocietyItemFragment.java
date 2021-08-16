package com.example.petime;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class SocietyItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private List<SocietyData> societyDataList = new ArrayList<SocietyData>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SocietyItemFragment() {
    }

    // TODO: Customize parameter initialization

    public static SocietyItemFragment newInstance(int columnCount) {
        SocietyItemFragment fragment = new SocietyItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            SocietyData zhangsan = new SocietyData("zhangsan", 10086);
            societyDataList.add(zhangsan);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
//initData();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
            recyclerView.setLayoutManager(new GridLayoutManager(context, societyDataList.size()));
            //recyclerView.setLayoutManager(new LinearLayoutManager(context));
            MySocietyItemRecyclerViewAdapter adapter = new MySocietyItemRecyclerViewAdapter(societyDataList);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
}