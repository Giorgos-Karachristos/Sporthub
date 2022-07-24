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
import com.example.sporthub5.RoomDatabase.Team;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Update_3_Team extends Fragment {
    EditText textTeamCode;
    EditText textTeamName;
    EditText textTeamStadium;
    EditText textTeamCity;
    EditText textTeamCountry;
    EditText textTeamYear;

    Button buttonUpdateTeam;

    public Fragment_Update_3_Team() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_3_team, container, false);
        textTeamCode = view.findViewById(R.id.text_update_team_code);
        textTeamName = view.findViewById(R.id.text_update_team_name);
        textTeamStadium = view.findViewById(R.id.text_update_team_stadium);
        textTeamCity = view.findViewById(R.id.text_update_team_city);
        textTeamCountry = view.findViewById(R.id.text_update_team_country);
        textTeamYear = view.findViewById(R.id.text_update_team_year);

        buttonUpdateTeam = view.findViewById(R.id.button_update_team_submit);
        buttonUpdateTeam.setOnClickListener(v -> {

            boolean flag= false;
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

            int varYear = 0;
            try {
                varYear = Integer.parseInt(textTeamYear.getText().toString());
            } catch (NumberFormatException ex) {
                if (varYear != 0)
                    Toast.makeText(getActivity(), "Something Went Wrong With Team Year", Toast.LENGTH_LONG).show();
            }

            if (MainActivity.myAppDatabase.myDao().getTeamCode(varCode)) {
                List<Team> team = MainActivity.myAppDatabase.myDao().getTeams();
                Team team1 = new Team();
                for (Team i : team) {
                    if (varCode == i.getCode()) {
                        if (!varName.equals(i.getName()) && varName.length() != 0) {
                            flag = true;
                            team1.setCode(varCode);
                            team1.setSid(i.getSid());

                            team1.setName(varName);

                            if (!varStadium.equals(i.getStadium()) && varStadium.length() != 0)
                                team1.setStadium(varStadium);
                            else if (varStadium.length() == 0)
                                team1.setStadium(i.getStadium());

                            if (!varCity.equals(i.getCity()) && varCity.length() != 0)
                                team1.setCity(varCity);
                            else if (varCity.length() == 0)
                                team1.setCity(i.getCity());

                            if (!varCountry.equals(i.getCountry()) && varCountry.length() != 0)
                                team1.setCountry(varCountry);
                            else if (varCountry.length() == 0)
                                team1.setCountry(i.getCountry());

                            if (varYear != i.getYear() && varYear != 0)
                                team1.setYear(varYear);
                            else if (varYear == 0)
                                team1.setYear(i.getYear());


                        } else if (varName.length() == 0) {
                            flag = true;
                            team1.setCode(varCode);
                            team1.setSid(i.getSid());

                            team1.setName(i.getName());

                            if (!varStadium.equals(i.getStadium()) && varStadium.length() != 0)
                                team1.setStadium(varStadium);
                            else if (varStadium.length() == 0)
                                team1.setStadium(i.getStadium());

                            if (!varCity.equals(i.getCity()) && varCity.length() != 0)
                                team1.setCity(varCity);
                            else if (varCity.length() == 0)
                                team1.setCity(i.getCity());

                            if (!varCountry.equals(i.getCountry()) && varCountry.length() != 0)
                                team1.setCountry(varCountry);
                            else if (varCountry.length() == 0)
                                team1.setCountry(i.getCountry());

                            if (varYear != i.getYear() && varYear != 0)
                                team1.setYear(varYear);
                            else if (varYear == 0)
                                team1.setYear(i.getYear());
                        }
                        MainActivity.myAppDatabase.myDao().updateTeam(team1);
                    }
                }
                if (flag)
                    Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textTeamCode.setText("");
            textTeamName.setText("");
            textTeamStadium.setText("");
            textTeamCity.setText("");
            textTeamCountry.setText("");
            textTeamYear.setText("");
        });
        return view;
    }
}