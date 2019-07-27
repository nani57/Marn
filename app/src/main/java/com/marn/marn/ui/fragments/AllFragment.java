package com.marn.marn.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.marn.marn.OnItemClick;
import com.marn.marn.R;
import com.marn.marn.adapters.AllItemsAdapter;
import com.marn.marn.model.ItemsDetails;
import com.marn.marn.ui.activities.CheckoutActivity;
import com.marn.marn.utils.Constants;

import java.util.ArrayList;


public class AllFragment extends Fragment implements OnItemClick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ItemsDetails> itemsArrayList = new ArrayList<>();
    private ArrayList<ItemsDetails> selectedItemsList = new ArrayList<>();

    private AllItemsAdapter allItemsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView allRecyclerView;
    private OnItemClick onItemClick;
    private View view;

    public AllFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllFragment newInstance(String param1, String param2) {
        AllFragment fragment = new AllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all, container, false);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        allRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        allItemsAdapter = new AllItemsAdapter(getContext(), itemsArrayList, selectedItemsList, this);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        allRecyclerView.setLayoutManager(mGridLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        allRecyclerView.setAdapter(allItemsAdapter);
        rewardsData();
        Log.v("Selected", "List" + selectedItemsList.size());


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void rewardsData() {
        ItemsDetails rewards = new ItemsDetails(Constants.itemImages[0], Constants.itemName[0], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[1], Constants.itemName[1], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[2], Constants.itemName[2], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[3], Constants.itemName[3], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[4], Constants.itemName[4], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[5], Constants.itemName[5], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[6], Constants.itemName[6], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[7], Constants.itemName[7], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[8], Constants.itemName[8], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[9], Constants.itemName[9], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[10], Constants.itemName[10], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);

        rewards = new ItemsDetails(Constants.itemImages[11], Constants.itemName[11], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);
        rewards = new ItemsDetails(Constants.itemImages[12], Constants.itemName[12], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);
        rewards = new ItemsDetails(Constants.itemImages[13], Constants.itemName[13], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);
        rewards = new ItemsDetails(Constants.itemImages[14], Constants.itemName[14], Constants.itemAmount[0]);
        itemsArrayList.add(rewards);


        allItemsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(int value, Double totalPrice) {
        Log.v("ALL", "" + value);
        CheckoutActivity checkoutActivity = (CheckoutActivity) getActivity();
        checkoutActivity.onClick(value, totalPrice);
    }

}
