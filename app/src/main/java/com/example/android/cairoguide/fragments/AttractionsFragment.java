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
import com.example.android.cairoguide.databinding.FragmentAttractionsBinding;
import com.example.android.cairoguide.datamodels.ListItemData;
import java.util.ArrayList;

/**
 * AttractionsFragment subclass displays a list of the Top Attractions in Cairo City.
 */
public class AttractionsFragment extends Fragment {

    //Declaring the binding and attractionsList Object Variables
    private FragmentAttractionsBinding binding;

    private ArrayList<ListItemData> attractionsList;

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment using View Binding, Initializing an instance of the FragmentAttractionsBinding
        //class for the fragment to use
        binding = FragmentAttractionsBinding.inflate(inflater, container, false);

        //Get a reference to the root view by calling getRoot method on the binding Object
        View rootView = binding.getRoot();

        //Initializing the attractionsList Object Variable and then adding ListItemData Objects to it
        attractionsList = new ArrayList<>();

        attractionsList.add(new ListItemData(R.drawable.first_attraction_pyramids, getString(R.string.first_attraction_title), getString(R.string.first_attraction_description),
                getString(R.string.first_attraction_location), null, null, 0));

        attractionsList.add(new ListItemData(R.drawable.second_attraction_egyptian_museum, getString(R.string.second_attraction_title), getString(R.string.second_attraction_description),
                getString(R.string.second_attraction_location), null, null, 0));

        attractionsList.add(new ListItemData(R.drawable.third_attraction_azhar, getString(R.string.third_attraction_title), getString(R.string.third_attraction_description),
                getString(R.string.third_attraction_location), null, null, 0));

        attractionsList.add(new ListItemData(R.drawable.fourth_attraction_sultan_hassan_mosque, getString(R.string.fourth_attraction_title), getString(R.string.fourth_attraction_description),
                getString(R.string.fourth_attraction_location), null, null, 0));

        attractionsList.add(new ListItemData(R.drawable.fifth_attraction_khan_khalili, getString(R.string.fifth_attraction_title), getString(R.string.fifth_attraction_description),
                getString(R.string.fifth_attraction_location), null, null, 0));

        attractionsList.add(new ListItemData(R.drawable.sixth_attraction_citadel, getString(R.string.sixth_attraction_title), getString(R.string.sixth_attraction_description),
                getString(R.string.sixth_attraction_location), null, null, 0));

        //Calling setUpRecyclerView method which sets ups the recyclerView
        setUpRecyclerView();

        return rootView;
    }

    /**
     * This method sets up the recyclerView through initializing the adapter then attaching it to the recyclerView.
     */
    private void setUpRecyclerView() {

        //Initializing the adapter Object Variable
        CardAdapter adapter = new CardAdapter(attractionsList);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        binding.attractionsRecyclerView.setHasFixedSize(true);

        //Set the layoutManager that the recyclerView will use
        binding.attractionsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Attaching the adapter to the recyclerView with the setAdapter() method.
        binding.attractionsRecyclerView.setAdapter(adapter);
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



