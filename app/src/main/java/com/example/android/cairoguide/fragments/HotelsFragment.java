package com.example.android.cairoguide.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.cairoguide.R;
import com.example.android.cairoguide.adapters.CardAdapter;
import com.example.android.cairoguide.databinding.FragmentHotelsBinding;
import com.example.android.cairoguide.datamodels.ListItemData;
import java.util.ArrayList;

/**
 * HotelsFragment subclass displays a list of the Top Hotels in Cairo City.
 */
public class HotelsFragment extends Fragment {

    //Declaring the binding and hotelsList Object Variables
    private FragmentHotelsBinding binding;

    private ArrayList<ListItemData> hotelsList;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment using View Binding, Initializing an instance of the FragmentHotelsBinding
        //class for the fragment to use
        binding = FragmentHotelsBinding.inflate(inflater, container, false);

        //Get a reference to the root view by calling getRoot method on the binding Object
        View rootView = binding.getRoot();

        //Initializing the hotelsList Object Variable and then adding ListItemData Objects to it
        hotelsList = new ArrayList<>();

        hotelsList.add(new ListItemData(R.drawable.first_hotel_fairmont, getString(R.string.first_hotel_title), getString(R.string.first_hotel_description),
                getString(R.string.first_hotel_location), null, null, 4.8f));

        hotelsList.add(new ListItemData(R.drawable.second_hotel_four_seasons, getString(R.string.second_hotel_title), getString(R.string.second_hotel_description),
                getString(R.string.second_hotel_location), null, null, 4.7f));

        hotelsList.add(new ListItemData(R.drawable.third_hotel_ritz_carlton, getString(R.string.third_hotel_title), getString(R.string.third_hotel_description),
                getString(R.string.third_hotel_location), null, null, 4.6f));

        hotelsList.add(new ListItemData(R.drawable.fourth_hotel_kempinski, getString(R.string.fourth_hotel_title), getString(R.string.fourth_hotel_description),
                getString(R.string.fourth_hotel_location), null, null, 4.5f));

        hotelsList.add(new ListItemData(R.drawable.fifth_hotel_royal_maxim, getString(R.string.fifth_hotel_title), getString(R.string.fifth_hotel_description),
                getString(R.string.fifth_hotel_location), null, null, 4.4f));

        hotelsList.add(new ListItemData(R.drawable.sixth_hotel_heliopolis_towers, getString(R.string.sixth_hotel_title), getString(R.string.sixth_hotel_description),
                getString(R.string.sixth_hotel_location), null, null, 4.3f));

        //Calling setUpRecyclerView method which sets ups the recyclerView
        setUpRecyclerView();

        return rootView;
    }

    /**
     * This method sets up the recyclerView through initializing the adapter then attaching it to the recyclerView.
     */
    private void setUpRecyclerView() {

        //Initializing the adapter Object Variable
        CardAdapter adapter = new CardAdapter(hotelsList);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        binding.hotelsRecyclerView.setHasFixedSize(true);

        //Set the layoutManager that the recyclerView will use
        binding.hotelsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Attaching the adapter to the recyclerView with the setAdapter() method.
        binding.hotelsRecyclerView.setAdapter(adapter);
    }

    /**
     * This method allows the fragment to clean up resources associated with its View.
     */
    @Override
    public void onDestroyView() {

        super.onDestroyView();

        binding = null;
    }
}
