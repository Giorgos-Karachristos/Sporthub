package com.example.sporthub5.Delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Delete_4_Race extends Fragment {
    EditText textRaceDate;
    Button buttonDeleteRace;

    public Fragment_Delete_4_Race() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_4_race, container, false);

        textRaceDate = view.findViewById(R.id.text_delete_race_code);

        buttonDeleteRace = view.findViewById(R.id.button_delete_race_submit);
        buttonDeleteRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int varDate = Integer.parseInt(textRaceDate.getText().toString());

                try {
                    MainActivity.myFirebaseFireStore.
                            collection("Race").
                            document("race" + varDate).
                            delete().
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "Record deleted", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
                }
                textRaceDate.setText("");
            }
        });

        return view;
    }
}