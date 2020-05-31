package com.example.android.cairoguide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;
import com.example.android.cairoguide.R;
import com.example.android.cairoguide.databinding.ActivityMainBinding;

/**
 * This class displays the MainActivity Screen that appears after the user has signed in successfully to the app where the user can
 * navigate between different sections including Attractions Section, Restaurants Section, Events Section, and Hotels Section.
 */
public class MainActivity extends AppCompatActivity {

    //Declaring all object variables
    private AppBarConfiguration mAppBarConfiguration;

    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Declaring and initializing an instance of the ActivityMainBinding class for the activity to use
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //Get a reference to the root view by calling getRoot method on the binding Object
        View view = binding.getRoot();

        //Pass the root view to setContentView() to make it the active view on the screen.
        setContentView(view);

        //Set the toolBar to act as the ActionBar for this Activity window.
        setSupportActionBar(binding.toolbar);

        // Initializing the mAppBarConfiguration and passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_attractions, R.id.nav_restaurants, R.id.nav_events, R.id.nav_hotels)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        //Initializing the mNavController object
        mNavController = Navigation.findNavController(this, R.id.fragment_container);

        //Set up the ActionBar returned by getSupportActionBar() for use with the mNavController.
        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);

        // Sets up the navigationView for use with the mNavController. This will call onNavDestinationSelected(MenuItem, NavController) when a menu item is selected.
        // The selected item in the navigationView will automatically be updated when the destination changes.
        NavigationUI.setupWithNavController(binding.navigationView, mNavController);
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar.
     *
     * @return boolean: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {

        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

