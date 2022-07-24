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
import com.example.sporthub5.RoomDatabase.Team;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Insert_3_Team extends Fragment {
    EditText textTeamCode;
    EditText textTeamName;
    EditText textTeamStadium;
    EditText textTeamCity;
    EditText textTeamCountry;
    EditText textTeamSportId;
    EditText textTeamYear;

    Button buttonInsertTeam;

    public Fragment_Insert_3_Team() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_3_team, container, false);
        textTeamCode = view.findViewById(R.id.text_insert_team_code);
        textTeamName = view.findViewById(R.id.text_insert_team_name);
        textTeamStadium = view.findViewById(R.id.text_insert_team_stadium);
        textTeamCity = view.findViewById(R.id.text_insert_team_city);
        textTeamCountry = view.findViewById(R.id.text_insert_team_country);
        textTeamSportId = view.findViewById(R.id.text_insert_team_sportid);
        textTeamYear = view.findViewById(R.id.text_insert_team_year);

        buttonInsertTeam = view.findViewById(R.id.button_insert_team_submit);
        buttonInsertTeam.setOnClickListener(v -> {

            int varCode = 0;
            try {
                varCode = Integer.parseInt(textTeamCode.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Team Code", Toast.LENGTH_LONG).show();
            }

            String varName = textTeamName.getText().toString();
            String varStadium = textTeamStadium.getText().toString();
            String varCity = textTeamCity.getText().toString();
            String varCountry = textTeamCountry.getText().toString();

            int varSportId = 0;
            try {
                varSportId = Integer.parseInt(textTeamSportId.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Sport ID", Toast.LENGTH_LONG).show();
            }

            int varYear = 0;
            try {
                varYear = Integer.parseInt(textTeamYear.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Team Year", Toast.LENGTH_LONG).show();
            }

            if (varCode != 0 && varSportId != 0 && varYear != 0) {
                Team team = new Team();
                team.setCode(varCode);
                team.setName(varName);
                team.setStadium(varStadium);
                team.setCity(varCity);
                team.setCountry(varCountry);
                team.setSid(varSportId);
                team.setYear(varYear);

                MainActivity.myAppDatabase.myDao().insertTeam(team);
                Toast.makeText(getActivity(), "Record added", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textTeamCode.setText("");
            textTeamName.setText("");
            textTeamStadium.setText("");
            textTeamCity.setText("");
            textTeamCountry.setText("");
            textTeamSportId.setText("");
            textTeamYear.setText("");
        });
        return view;
    }
}