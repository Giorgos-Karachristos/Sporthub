package com.example.sporthub5.Delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Athlete;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Delete_2_Athlete extends Fragment {
    EditText textAthleteCode;
    Button buttonDeleteAthlete;

    public Fragment_Delete_2_Athlete() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_2_athlete, container, false);
        textAthleteCode = view.findViewById(R.id.text_delete_athlete_code);
        buttonDeleteAthlete = view.findViewById(R.id.button_delete_athlete_submit);
        buttonDeleteAthlete.setOnClickListener(v -> {
            int varCode = 0;
            try {
                varCode = Integer.parseInt(textAthleteCode.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Athlete Code", Toast.LENGTH_LONG).show();
            }
            if (MainActivity.myAppDatabase.myDao().getAthleteCode(varCode)) {
                Athlete athlete = new Athlete();
                athlete.setCode(varCode);
                MainActivity.myAppDatabase.myDao().deleteAthlete(athlete);
                Toast.makeText(getActivity(), "Record deleted", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            textAthleteCode.setText("");
        });
        return view;
    }
}