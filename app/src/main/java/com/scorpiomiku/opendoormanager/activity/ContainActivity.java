package com.scorpiomiku.opendoormanager.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.scorpiomiku.opendoormanager.R;
import com.scorpiomiku.opendoormanager.fragment.DoorOpenFragment;
import com.scorpiomiku.opendoormanager.fragment.InformationCentreFragment;
import com.scorpiomiku.opendoormanager.fragment.WhereTheKeyFragment;

public class ContainActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();

    private void createFragment(Fragment fragment) {
        Fragment frag = fm.findFragmentById(R.id.fragment_container);
        if (!(fragment == frag) || frag == null) {
            frag = fragment;
            fm.beginTransaction()
                    .replace(R.id.fragment_container, frag)
                    .commit();
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_where:
                    createFragment(WhereTheKeyFragment.newInstance());
                    return true;
                case R.id.navigation_isopen_door:
                    createFragment(DoorOpenFragment.newInstance());
                    return true;
                case R.id.navigation_informantion_centre:
                    createFragment(InformationCentreFragment.newInstance());
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contain);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (fm.findFragmentById(R.id.fragment_container) == null) {
            Fragment fragment = WhereTheKeyFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}
