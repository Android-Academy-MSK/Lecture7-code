package ru.androidacademy.msk.lecture7_code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragmentListener {

    private static final String SOME_TAG = "some_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SomeFragment someFragment = new SomeFragment();

            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_frame, someFragment, SOME_TAG)
                .commit();
        }

    }

    @Override
    public void onNextMessageClicked() {
        MessageFragment messageFragment =
            MessageFragment.newInstance("WORLD !!!");

        getSupportFragmentManager()
            .findFragmentByTag(SOME_TAG)
            .getChildFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_some_frame, messageFragment)
                .commit();
    }

}
