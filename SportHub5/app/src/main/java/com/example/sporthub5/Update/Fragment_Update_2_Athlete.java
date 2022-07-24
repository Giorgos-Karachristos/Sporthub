package com.example.sporthub5.Update;

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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Update_2_Athlete extends Fragment {
    EditText textAthleteCode;
    EditText textAthleteName;
    EditText textAthleteSurname;
    EditText textAthleteCity;
    EditText textAthleteCountry;
    EditText textAthleteYear;

    Button buttonUpdateAthlete;

    public Fragment_Update_2_Athlete() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_2_athlete, container, false);
        textAthleteCode = view.findViewById(R.id.text_update_athlete_code);
        textAthleteName = view.findViewById(R.id.text_update_athlete_name);
        textAthleteSurname = view.findViewById(R.id.text_update_athlete_surname);
        textAthleteCity = view.findViewById(R.id.text_update_athlete_city);
        textAthleteCountry = view.findViewById(R.id.text_update_athlete_country);
        textAthleteYear = view.findViewById(R.id.text_update_athlete_year);

        buttonUpdateAthlete = view.findViewById(R.id.button_update_athlete_submit);
        buttonUpdateAthlete.setOnClickListener(v -> {

            boolean flag= false;
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

            int varYear = 0;
            try {
                varYear = Integer.parseInt(textAthleteYear.getText().toString());
            } catch (NumberFormatException ex) {
                if (varYear != 0)
                    Toast.makeText(getActivity(), "Something Went Wrong With Year", Toast.LENGTH_LONG).show();
            }

            if (MainActivity.myAppDatabase.myDao().getAthleteCode(varCode)) {
                List<Athlete> athlete = MainActivity.myAppDatabase.myDao().getAthletes();
                Athlete athlete1 = new Athlete();
                for (Athlete i : athlete) {
                    if (varCode == i.getCode()) {
                        flag = true;
                        if (!varName.equals(i.getName()) && varName.length() != 0) {
                            athlete1.setCode(varCode);
                            athlete1.setSid(i.getSid());

                            athlete1.setName(varName);

                            if (!varSurname.equals(i.getSurname()) && varSurname.length() != 0)
                                athlete1.setSurname(varSurname);
                            else if (varSurname.length() == 0)
                                athlete1.setSurname(i.getSurname());

                            if (!varCity.equals(i.getCity()) && varCity.length() != 0)
                                athlete1.setCity(varCity);
                            else if (varCity.length() == 0)
                                athlete1.setCity(i.getCity());

                            if (!varCountry.equals(i.getCountry()) && varCountry.length() != 0)
                                athlete1.setCountry(varCountry);
                            else if (varCountry.length() == 0)
                                athlete1.setCountry(i.getCountry());

                            if (varYear != i.getYear() && varYear != 0)
                                athlete1.setYear(varYear);
                            else if (varYear == 0)
                                athlete1.setYear(i.getYear());

                        } else if (varName.length() == 0) {
                            flag = true;
                            athlete1.setCode(varCode);
                            athlete1.setSid(i.getSid());

                            athlete1.setName(i.getName());

                            if (!varSurname.equals(i.getSurname()) && varSurname.length() != 0)
                                athlete1.setSurname(varSurname);
                            else if (varSurname.length() == 0)
                                athlete1.setSurname(i.getSurname());

                            if (!varCity.equals(i.getCity()) && varCity.length() != 0)
                                athlete1.setCity(varCity);
                            else if (varCity.length() == 0)
                                athlete1.setCity(i.getCity());

                            if (!varCountry.equals(i.getCountry()) && varCountry.length() != 0)
                                athlete1.setCountry(varCountry);
                            else if (varCountry.length() == 0)
                                athlete1.setCountry(i.getCountry());

                            if (varYear != i.getYear() && varYear != 0)
                                athlete1.setYear(varYear);
                            else if (varYear == 0)
                                athlete1.setYear(i.getYear());

                        }
                        MainActivity.myAppDatabase.myDao().updateAthlete(athlete1);
                    }
                }
                if (flag)
                    Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textAthleteCode.setText("");
            textAthleteName.setText("");
            textAthleteSurname.setText("");
            textAthleteCity.setText("");
            textAthleteCountry.setText("");
            textAthleteYear.setText("");
        });
        return view;
    }
}