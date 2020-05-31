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
import com.example.android.cairoguide.databinding.FragmentEventsBinding;
import com.example.android.cairoguide.datamodels.ListItemData;
import java.util.ArrayList;

/**
 * EventsFragment subclass displays a list of the Current Events in Cairo City.
 */
public class EventsFragment extends Fragment {

    //Declaring the binding and eventsList Object Variables
    private FragmentEventsBinding binding;

    private ArrayList<ListItemData> eventsList;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment using View Binding, Initializing an instance of the FragmentEventsBinding
        //class for the fragment to use
        binding = FragmentEventsBinding.inflate(inflater, container, false);

        //Get a reference to the root view by calling getRoot method on the binding Object
        View rootView = binding.getRoot();

        //Initializing the eventsList Object Variable and then adding ListItemData Objects to it
        eventsList = new ArrayList<>();

        eventsList.add(new ListItemData(R.drawable.first_event_icec, getString(R.string.first_event_title), getString(R.string.first_event_description),
                null, null, getString(R.string.first_event_date), 0));

        eventsList.add(new ListItemData(R.drawable.second_event_ctw, getString(R.string.second_event_title), getString(R.string.second_event_description),
                null, null, getString(R.string.second_event_date), 0));

        eventsList.add(new ListItemData(R.drawable.third_event_cyber_security, getString(R.string.third_event_title), getString(R.string.third_event_description),
                null, null, getString(R.string.third_event_date), 0));

        eventsList.add(new ListItemData(R.drawable.fourth_event_matt_davis, getString(R.string.fourth_event_title), getString(R.string.fourth_event_description),
                null, null, getString(R.string.fourth_event_date), 0));

        eventsList.add(new ListItemData(R.drawable.fifth_event_medicine, getString(R.string.fifth_event_title), getString(R.string.fifth_event_description),
                null, null, getString(R.string.fifth_event_date), 0));

        eventsList.add(new ListItemData(R.drawable.sixth_event_startup, getString(R.string.sixth_event_title), getString(R.string.sixth_event_description),
                null, null, getString(R.string.sixth_event_date), 0));

        //Calling setUpRecyclerView method which sets ups the recyclerView
        setUpRecyclerView();

        return rootView;
    }

    /**
     * This method sets up the recyclerView through initializing the adapter then attaching it to the recyclerView.
     */
    private void setUpRecyclerView() {

        //Initializing the adapter Object Variable
        CardAdapter adapter = new CardAdapter(eventsList);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        binding.eventsRecyclerView.setHasFixedSize(true);

        //Set the layoutManager that the recyclerView will use
        binding.eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Attaching the adapter to the recyclerView with the setAdapter() method.
        binding.eventsRecyclerView.setAdapter(adapter);
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

