package com.google.managerapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    TimeFragment timeFragment;
    AlarmFragment alarmFragment;
    TimerFragment timerFragment;
    StopwatchFragment stopwatchFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeFragment = new TimeFragment();
        alarmFragment = new AlarmFragment();
        timerFragment = new TimerFragment();
        stopwatchFragment = new StopwatchFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, alarmFragment).commit();
        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        // 첫 번째 프래그먼트 호출
                        getSupportFragmentManager().beginTransaction().replace(R.id.timeFragment).commit();
                        return true;
                    case R.id.tab2:
                        // 두 번째 프래그먼트 호출
                        getSupportFragmentManager().beginTransaction().replace(R.id.alarmFragment).commit();
                        return true;
                    case R.id.tab3:
                        // 세 번째 프래그먼트 호출
                        getSupportFragmentManager().beginTransaction().replace(R.id.stopwatchFragment).commit();
                        return true;
                    case R.id.tab4:
                        // 네 번째 프래그먼트 호출
                        getSupportFragmentManager().beginTransaction().replace(R.id.timerFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}