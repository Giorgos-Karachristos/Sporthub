package com.example.sporthub5.Query;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Athlete;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Query_2_Athlete extends Fragment {

    ScrollView scrollView;
    TextView textAthleteQuery;

    public Fragment_Query_2_Athlete() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_2_athete, container, false);

        textAthleteQuery = view.findViewById(R.id.text_query_athlete);
        scrollView = view.findViewById(R.id.scroll_query_athlete);


        String result = "";
        if (MainActivity.myAppDatabase.myDao().getAthletes().isEmpty()) {
            scrollView.setBackgroundDrawable(getResources().getDrawable(R.drawable.no_data_found));
        } else {
            scrollView.setBackgroundResource(0);
            List<Athlete> athlete = MainActivity.myAppDatabase.myDao().getAthletes();
            for (Athlete i : athlete) {
                int code = i.getCode();
                String name = i.getName();
                String surname = i.getSurname();
                String city = i.getCity();
                String country = i.getCountry();
                int sid = i.getSid();
                int year = i.getYear();

                result = result + "\n Code: " + code +
                        "\n Name: " + name +
                        "\n Surname: " + surname +
                        "\n City: " + city +
                        "\n Country: " + country +
                        "\n Sport id: " + sid +
                        "\n Year: " + year + "\n";
            }
            textAthleteQuery.setText(result);
        }
        return view;
    }
}