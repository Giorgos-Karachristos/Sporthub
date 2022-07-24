package com.example.sporthub5.Insert;

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
public class Fragment_Insert_2_Athlete extends Fragment {
    EditText textAthleteCode;
    EditText textAthleteName;
    EditText textAthleteSurname;
    EditText textAthleteCity;
    EditText textAthleteCountry;
    EditText textAthleteSportId;
    EditText textAthleteYear;

    Button buttonInsertAthlete;

    public Fragment_Insert_2_Athlete() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_2_athlete, container, false);
        textAthleteCode = view.findViewById(R.id.text_insert_athlete_code);
        textAthleteName = view.findViewById(R.id.text_insert_athlete_name);
        textAthleteSurname = view.findViewById(R.id.text_insert_athlete_surname);
        textAthleteCity = view.findViewById(R.id.text_insert_athlete_city);
        textAthleteCountry = view.findViewById(R.id.text_insert_athlete_country);
        textAthleteSportId = view.findViewById(R.id.text_insert_athlete_sportid);
        textAthleteYear = view.findViewById(R.id.text_insert_athlete_year);

        buttonInsertAthlete = view.findViewById(R.id.button_insert_athlete_submit);
        buttonInsertAthlete.setOnClickListener(v -> {

            int varCode = 0;
            try {
                varCode = Integer.parseInt(textAthleteCode.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Athlete Code", Toast.LENGTH_LONG).show();
            }

            String varName = textAthleteName.getText().toString();
            String varSurname = textAthleteSurname.getText().toString();
            String varCity = textAthleteCity.getText().toString();
            String varCountry = textAthleteCountry.getText().toString();

            int varSportId = 0;
            try {
                varSportId = Integer.parseInt(textAthleteSportId.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Sport ID", Toast.LENGTH_LONG).show();
            }

            int varYear = 0;
            try {
                varYear = Integer.parseInt(textAthleteYear.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Year", Toast.LENGTH_LONG).show();
            }

            if (varCode != 0 && varSportId != 0 && varYear != 0) {
                Athlete athlete = new Athlete();
                athlete.setCode(varCode);
                athlete.setName(varName);
                athlete.setSurname(varSurname);
                athlete.setCity(varCity);
                athlete.setCountry(varCountry);
                athlete.setSid(varSportId);
                athlete.setYear(varYear);

                MainActivity.myAppDatabase.myDao().insertAthlete(athlete);
                Toast.makeText(getActivity(), "Record added", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textAthleteCode.setText("");
            textAthleteName.setText("");
            textAthleteSurname.setText("");
            textAthleteCity.setText("");
            textAthleteCountry.setText("");
            textAthleteSportId.setText("");
            textAthleteYear.setText("");
        });
        return view;
    }
}