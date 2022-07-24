package com.example.sporthub5.Query;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Sport;
import com.example.sporthub5.RoomDatabase.Team;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Query_3_Team extends Fragment {

    ScrollView scrollView;
    TextView textTeamQuery;

    public Fragment_Query_3_Team() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_3_team, container, false);

        textTeamQuery = view.findViewById(R.id.text_query_team);
        scrollView = view.findViewById(R.id.scroll_query_team);

        String result = "";
        if (MainActivity.myAppDatabase.myDao().getTeams().isEmpty())
            scrollView.setBackgroundDrawable(getResources().getDrawable(R.drawable.no_data_found));
        else {
            scrollView.setBackgroundResource(0);
            List<Team> team = MainActivity.myAppDatabase.myDao().getTeams();
            for (Team i : team) {
                int code = i.getCode();
                String name = i.getName();
                String stadium = i.getStadium();
                String city = i.getCity();
                String country = i.getCountry();
                int sid = i.getSid();
                int year = i.getYear();
                result = result + "\n Id: " + code +
                        "\n Name: " + name +
                        "\n Stadium: " + stadium +
                        "\n City: " + city +
                        "\n Country: " + country +
                        "\n Sport ID: " + sid +
                        "\n Year: " + year + "\n";
            }
            textTeamQuery.setText(result);
        }


        return view;
    }
}