package com.example.android.cairoguide.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.cairoguide.R;
import com.example.android.cairoguide.datamodels.ListItemData;
import java.util.ArrayList;

/**
 * This Class provides the Adapter to populate items/cards inside of the RecyclerView.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    //Declaring the itemsList Object Instance
    private ArrayList<ListItemData> itemsList;

    /**
     * This constructor is used to create an instance of the CardAdapter using the itemsList as an input
     *
     * @param itemsList ArrayList<ListItemData>: the ArrayList of List Items' objects which will be passed to the adapter
     */
    public CardAdapter(ArrayList<ListItemData> itemsList) {

        this.itemsList = itemsList;
    }

    /**
     * This method is called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     *
     * @param parent   ViewGroup: The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType int: The view type of the new View.
     * @return CardHolder: A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new CardHolder(itemView);
    }

    /**
     * This method is called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the itemView to reflect the item at the given position.
     *
     * @param holder   CardHolder: The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position int: The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {

        ListItemData listItem = itemsList.get(position);

        holder.listItemImage.setImageResource(listItem.getImageResourceId());

        holder.title.setText(listItem.getTitle());

        holder.description.setText(listItem.getDescription());

        if (listItem.getLocation() != null) {

            holder.timeAndLocationInfo.setText(listItem.getLocation());
        }

        if (listItem.getBusinessHours() != null && listItem.getLocation() != null) {

            holder.timeAndLocationInfo.setText(listItem.getLocation());

            holder.openingHours.setVisibility(View.VISIBLE);

            holder.openingHours.setText(listItem.getBusinessHours());
        }

        if (listItem.getDate() != null) {

            holder.timeAndLocationInfo.setText(listItem.getDate());
        }

        if (listItem.getRating() != 0) {

            holder.ratingBar.setVisibility(View.VISIBLE);

            holder.ratingBar.setRating(listItem.getRating());
        }
    }

    /**
     * This method returns the size of the ArrayList that contains the items we want to display.
     *
     * @return int: the number of items in the itemsList
     */
    @Override
    public int getItemCount() {

        return itemsList.size();
    }

    /**
     * This class represents a ViewHolder called CardHolder that describes an item view and metadata about its place within the RecyclerView.
     */
    class CardHolder extends RecyclerView.ViewHolder {

        //Declaring all Object Variables
        ImageView listItemImage;

        TextView title;

        TextView description;

        TextView timeAndLocationInfo;

        TextView openingHours;

        AppCompatRatingBar ratingBar;

        public CardHolder(@NonNull View itemView) {
            super(itemView);

            //Initializing all object variables
            listItemImage = itemView.findViewById(R.id.list_item_image);

            title = itemView.findViewById(R.id.list_item_title);

            description = itemView.findViewById(R.id.list_item_description);

            timeAndLocationInfo = itemView.findViewById(R.id.location_and_time_description);

            openingHours = itemView.findViewById(R.id.opening_hours);

            ratingBar = itemView.findViewById(R.id.rating_bar);
        }
    }
}
