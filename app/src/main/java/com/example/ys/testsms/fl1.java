package com.example.ys.testsms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class fl1 extends Fragment {
    EditText et1;

    public fl1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fl1, container, false);
        et1 = (EditText) view.findViewById(R.id.editText);
        Button bt1 = (Button) view.findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), et1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
