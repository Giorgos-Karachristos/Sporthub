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
import com.example.sporthub5.RoomDatabase.Sport;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Query_1_Sport extends Fragment {

    ScrollView scrollViewSport;
    TextView textSportQuery;

    public Fragment_Query_1_Sport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_1_sport, container, false);

        textSportQuery = view.findViewById(R.id.text_query_sport);
        scrollViewSport = view.findViewById(R.id.scroll_query_sport);

        String result = "";
        if (MainActivity.myAppDatabase.myDao().getSports().isEmpty())
            scrollViewSport.setBackgroundDrawable(getResources().getDrawable(R.drawable.no_data_found));
        else {
            scrollViewSport.setBackgroundResource(0);
            List<Sport> sport = MainActivity.myAppDatabase.myDao().getSports();
            for (Sport i : sport) {
                int code = i.getId();
                String name = i.getName();
                String type = i.getType();
                String gender = i.getGender();
                result = result + "\n Id: " + code + "\n Name: " + name + "\n Type: " + type + "\n Gender:" + gender + "\n";
            }
            textSportQuery.setText(result);
        }
        return view;
    }
}