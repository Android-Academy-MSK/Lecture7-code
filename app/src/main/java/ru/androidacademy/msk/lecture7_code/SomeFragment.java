package ru.androidacademy.msk.lecture7_code;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_some,
            container, false);

        if (savedInstanceState == null) {

            MessageFragment messageFragment =
                MessageFragment.newInstance("Hello :D");

            getChildFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_some_frame, messageFragment)
                .commit();
        }

        return view;
    }

}
