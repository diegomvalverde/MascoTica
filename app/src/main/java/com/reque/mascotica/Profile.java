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

public class Profile extends AppCompatActivity {

    private TextView mTextMessage;

    private ArrayList<PropertyProfile> menuPostsProfile = new ArrayList<>();

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

        menuPostsProfile.add(new PropertyProfile("agregar","Esta es una prueba de como se veria","60556566", 1));
        menuPostsProfile.add(new PropertyProfile("camara","Esta es una prueba de como si funciona","706657890", 2));

        //create our new array adapter
        ArrayAdapter<PropertyProfile> adapter = new MenuArrayAdapterProfile(this, 0, menuPostsProfile);

        ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);
    }

    class MenuArrayAdapterProfile extends ArrayAdapter<PropertyProfile> {

        private Context context;
        private List<PropertyProfile> MenuPostsProfile;

        //constructor, call on creation
        public MenuArrayAdapterProfile(Context context, int resource, ArrayList<PropertyProfile> objects) {
            super(context, resource, objects);

            this.context = context;
            this.MenuPostsProfile = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            PropertyProfile propertyprofile1 = MenuPostsProfile.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.property_layout, null);

            TextView descripcion = (TextView) view.findViewById(R.id.description);
            TextView numTelefono = (TextView) view.findViewById(R.id.Telelfono);
            ImageView image = (ImageView) view.findViewById(R.id.image);


            //display trimmed excerpt for description
            int descriptionLength = propertyprofile1.getDescripcion().length();
            if(descriptionLength >= 100){
                String descriptionTrim = propertyprofile1.getDescripcion().substring(0, 100) + "...";
                descripcion.setText(descriptionTrim);
            }else{
                descripcion.setText(propertyprofile1.getDescripcion());
            }

            //set price and rental attributes
            numTelefono.setText("NumTelefonico" + String.valueOf(propertyprofile1.getNumTelefono()));

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(propertyprofile1.getImagenl(), "drawable", context.getPackageName());
            image.setImageResource(imageID);
            return view;
        }
    }

}
