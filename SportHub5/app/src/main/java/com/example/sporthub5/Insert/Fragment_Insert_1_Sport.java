package com.example.sporthub5.Insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Sport;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Insert_1_Sport extends Fragment {
    EditText textSportId;
    EditText textSportName;

    Spinner spinnerSportType;
    Spinner spinnerSportGender;

    Button buttonInsertSport;

    public Fragment_Insert_1_Sport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_1_sport, container, false);

        textSportId = view.findViewById(R.id.text_insert_sport_id);
        textSportName = view.findViewById(R.id.text_insert_sport_name);

        spinnerSportType = (Spinner) view.findViewById(R.id.spinner_insert_sport_type);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.SportType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSportType.setAdapter(adapter);

        spinnerSportGender = (Spinner) view.findViewById(R.id.spinner_insert_sport_gender);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.SportGender, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSportGender.setAdapter(adapter1);


        buttonInsertSport = view.findViewById(R.id.button_insert_sport_submit);
        buttonInsertSport.setOnClickListener(v -> {

            int varId = 0;
            try {
                varId = Integer.parseInt(textSportId.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With ID", Toast.LENGTH_LONG).show();
            }

            String varName = textSportName.getText().toString();
            String varType = spinnerSportType.getSelectedItem().toString();
            String varGender = spinnerSportGender.getSelectedItem().toString();

            if (varId != 0 && varName.length() != 0) {
                Sport sport = new Sport();
                sport.setId(varId);
                sport.setName(varName);
                sport.setType(varType);
                sport.setGender(varGender);
                MainActivity.myAppDatabase.myDao().insertSport(sport);
                Toast.makeText(getActivity(), "Record added", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textSportId.setText("");
            textSportName.setText("");
        });
        return view;
    }
}