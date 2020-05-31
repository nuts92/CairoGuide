package com.example.android.cairoguide.datamodels;

/**
 * This class is a Data Model Class that stores the List Item Data including the list item image, list item title, list item description,
 * list item location, list item business hours, list item date, and list item rating. The list item that will be displayed can be one of
 * the following four categories which are attractions, restaurants, events, and hotels.
 */
public class ListItemData {

    private int ImageResourceId;

    private String title;

    private String description;

    private String location;

    private String businessHours;

    private String date;

    private float rating;

    public ListItemData(int imageResourceId, String title, String description, String location, String businessHours, String date, float rating) {
        ImageResourceId = imageResourceId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.businessHours = businessHours;
        this.date = date;
        this.rating = rating;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public String getDate() {
        return date;
    }

    public float getRating() {
        return rating;
    }
}
