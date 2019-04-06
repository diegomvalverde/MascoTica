package com.example.mascotica;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.reque.mascotica.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class homePage extends AppCompatActivity {

    private ArrayList<Property> menuPosts = new ArrayList<>();

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_Donate:
                    mTextMessage.setText(R.string.title_Donate);
                    return true;
                case R.id.navigation_Notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        menuPosts.add(new Property("agregar","Esta es una prueba de como se veria","60556566"));
        menuPosts.add(new Property("camara","Esta es una prueba de como si funciona","706657890"));
        //create our new array adapter
        ArrayAdapter<Property> adapter = new MenuArrayAdapter(this, 0, menuPosts);

        //Find list view and bind it with the custom adapter

        ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);


    }



    class MenuArrayAdapter extends ArrayAdapter<Property> {

        private Context context;
        private List<Property> MenuPosts;

        //constructor, call on creation
        public MenuArrayAdapter(Context context, int resource, ArrayList<Property> objects) {
            super(context, resource, objects);

            this.context = context;
            this.MenuPosts = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Property property = MenuPosts.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.property_layout, null);

            TextView descripcion = (TextView) view.findViewById(R.id.description);
            TextView numTelefono = (TextView) view.findViewById(R.id.Telelfono);
            ImageView image = (ImageView) view.findViewById(R.id.image);


            //display trimmed excerpt for description
            int descriptionLength = property.getDescripcion().length();
            if(descriptionLength >= 100){
                String descriptionTrim = property.getDescripcion().substring(0, 100) + "...";
                descripcion.setText(descriptionTrim);
            }else{
                descripcion.setText(property.getDescripcion());
            }

            //set price and rental attributes
            numTelefono.setText("NumTelefonico" + String.valueOf(property.getNumTelefono()));

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(property.getImagenl(), "drawable", context.getPackageName());
            image.setImageResource(imageID);

            return view;
        }
    }

}
