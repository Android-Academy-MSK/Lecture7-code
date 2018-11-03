package ru.androidacademy.msk.lecture7_code;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MessageFragment extends Fragment {

    private static final String ARGS_MESSAGE = "args:message";

    private MessageFragmentListener listener;

    public static MessageFragment newInstance(String message) {
        MessageFragment messageFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, message);
        messageFragment.setArguments(bundle);

        return messageFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message,
            container, false);

        TextView textView = view.findViewById(R.id.fragment_message_text);
        if  (getArguments() != null) {
            String message = getArguments().getString(ARGS_MESSAGE);
            textView.setText(message);
        }

        Button button =
            view.findViewById(R.id.fragment_message_next_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onNextMessageClicked();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof MessageFragmentListener) {
            listener = (MessageFragmentListener) getActivity();
        }
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }



}
