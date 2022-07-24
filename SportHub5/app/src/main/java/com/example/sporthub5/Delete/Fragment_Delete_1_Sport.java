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
import com.example.sporthub5.RoomDatabase.Sport;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Delete_1_Sport extends Fragment {
    EditText textSportId;
    Button buttonDeleteSport;

    public Fragment_Delete_1_Sport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_1_sport, container, false);
        textSportId = view.findViewById(R.id.text_delete_sport_id);
        buttonDeleteSport = view.findViewById(R.id.button_delete_sport_submit);

        buttonDeleteSport.setOnClickListener(v -> {
            int varId = 0;
            try {
                varId = Integer.parseInt(textSportId.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With ID", Toast.LENGTH_LONG).show();
            }
            if (MainActivity.myAppDatabase.myDao().getIdSport(varId)) {
                Sport sport = new Sport();
                sport.setId(varId);
                MainActivity.myAppDatabase.myDao().deleteSport(sport);
                Toast.makeText(getActivity(), "Record deleted", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            textSportId.setText("");
        });
        return view;
    }
}