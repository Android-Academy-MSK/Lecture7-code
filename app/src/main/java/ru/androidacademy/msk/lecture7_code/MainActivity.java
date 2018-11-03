package ru.androidacademy.msk.lecture7_code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageFragment messageFragment = new MessageFragment();

        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.activity_main_frame, messageFragment)
            .commit();

    }
}
