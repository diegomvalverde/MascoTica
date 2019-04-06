package com.example.mascotica;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.reque.mascotica.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class notifications extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Home:
                    mTextMessage.setText(R.string.title_home);
                    return true;

                case R.id.navigation_Notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_Profile:
                    mTextMessage.setText(R.string.title_Profile);
                    return true;
                case R.id.navigation_Favorites:
                    mTextMessage.setText(R.string.title_Favorites);
                    return true;
                case R.id.navigation_Donate:
                    mTextMessage.setText(R.string.title_Donate);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
