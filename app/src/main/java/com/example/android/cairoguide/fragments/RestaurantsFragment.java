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
import com.example.android.cairoguide.databinding.FragmentRestaurantsBinding;
import com.example.android.cairoguide.datamodels.ListItemData;
import java.util.ArrayList;

/**
 * RestaurantsFragment subclass displays a list of the Top Restaurants in Cairo City.
 */
public class RestaurantsFragment extends Fragment {

    //Declaring the binding and restaurantList Object Variables
    private FragmentRestaurantsBinding binding;

    private ArrayList<ListItemData> restaurantList;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment using View Binding, Initializing an instance of the FragmentRestaurantsBinding
        //class for the fragment to use
        binding = FragmentRestaurantsBinding.inflate(inflater, container, false);

        //Get a reference to the root view by calling getRoot method on the binding Object
        View rootView = binding.getRoot();

        //Initializing the restaurantList Object Variable and then adding ListItemData Objects to it
        restaurantList = new ArrayList<>();

        restaurantList.add(new ListItemData(R.drawable.first_restaurant_khal, getString(R.string.first_restaurant_title), getString(R.string.first_restaurant_description),
                getString(R.string.first_restaurant_location), getString(R.string.first_restaurant_hours), null, 5));

        restaurantList.add(new ListItemData(R.drawable.second_restaurant_culina, getString(R.string.second_restaurant_title), getString(R.string.second_restaurant_description),
                getString(R.string.second_restaurant_location), getString(R.string.second_restaurant_hours), null, 4));

        restaurantList.add(new ListItemData(R.drawable.third_restaurant_abu_tarek, getString(R.string.third_restaurant_title), getString(R.string.third_restaurant_description),
                getString(R.string.third_restaurant_location), getString(R.string.third_restaurant_hours), null, 4.2f));

        restaurantList.add(new ListItemData(R.drawable.fourth_restaurant_fayruz, getString(R.string.fourth_restaurant_title), getString(R.string.fourth_restaurant_description),
                getString(R.string.fourth_restaurant_location), getString(R.string.fourth_restaurant_hours), null, 4.3f));

        restaurantList.add(new ListItemData(R.drawable.fifth_restaurant_esplanade, getString(R.string.fifth_restaurant_title), getString(R.string.fifth_restaurant_description),
                getString(R.string.fifth_restaurant_location), getString(R.string.fifth_restaurant_hours), null, 4.6f));

        restaurantList.add(new ListItemData(R.drawable.sixth_restaurant_bab_qasr, getString(R.string.sixth_restaurant_title), getString(R.string.sixth_restaurant_description),
                getString(R.string.sixth_restaurant_location), getString(R.string.sixth_restaurant_hours), null, 4.3f));

        //Calling setUpRecyclerView method which sets ups the recyclerView
        setUpRecyclerView();

        return rootView;
    }

    /**
     * This method sets up the recyclerView through initializing the adapter then attaching it to the recyclerView.
     */
    private void setUpRecyclerView() {

        //Initializing the adapter Object Variable
        CardAdapter adapter = new CardAdapter(restaurantList);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        binding.restaurantsRecyclerView.setHasFixedSize(true);

        //Set the layoutManager that the recyclerView will use
        binding.restaurantsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Attaching the adapter to the recyclerView with the setAdapter() method.
        binding.restaurantsRecyclerView.setAdapter(adapter);
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


