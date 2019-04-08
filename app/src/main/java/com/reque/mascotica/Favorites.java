package com.reque.mascotica;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {

    private TextView mTextMessage;

    private ArrayList<propertyFavorites> menuFavorites = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_Favorites:
                    mTextMessage.setText(R.string.title_Favorites);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_Donate:
                    mTextMessage.setText(R.string.title_Donate);
                    return true;
                case R.id.navigation_Profile:
                    mTextMessage.setText(R.string.title_Profile);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        menuFavorites.add(new propertyFavorites("agregar","Esta es una prueba de como se veria","60556566", 1));
        menuFavorites.add(new propertyFavorites("camara","Esta es una prueba de como si funciona","706657890", 2));

        //create our new array adapter
        ArrayAdapter<propertyFavorites> adapter = new Favorites.MenuArrayAdapterFavs(this, 0, menuFavorites);

        ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);
    }

    class MenuArrayAdapterFavs extends ArrayAdapter<propertyFavorites> {

        private Context context;
        private List<propertyFavorites> MenuPostsProfile;

        //constructor, call on creation
        public MenuArrayAdapterFavs(Context context, int resource, ArrayList<propertyFavorites> objects) {
            super(context, resource, objects);

            this.context = context;
            this.MenuPostsProfile = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            propertyFavorites propertyfavs = MenuPostsProfile.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.property_layout, null);

            TextView descripcion = (TextView) view.findViewById(R.id.description);
            TextView numTelefono = (TextView) view.findViewById(R.id.Telelfono);
            ImageView image = (ImageView) view.findViewById(R.id.image);


            //display trimmed excerpt for description
            int descriptionLength = propertyfavs.getDescripcion().length();
            if(descriptionLength >= 100){
                String descriptionTrim = propertyfavs.getDescripcion().substring(0, 100) + "...";
                descripcion.setText(descriptionTrim);
            }else{
                descripcion.setText(propertyfavs.getDescripcion());
            }

            //set price and rental attributes
            numTelefono.setText("NumTelefonico" + String.valueOf(propertyfavs.getNumTelefono()));

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(propertyfavs.getImagenl(), "drawable", context.getPackageName());
            image.setImageResource(imageID);
            return view;
        }
    }

}
