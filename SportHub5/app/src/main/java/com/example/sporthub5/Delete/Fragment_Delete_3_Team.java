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
import com.example.sporthub5.RoomDatabase.Team;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Delete_3_Team extends Fragment {
    EditText textTeamCode;
    Button buttonDeleteTeam;

    public Fragment_Delete_3_Team() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_3_team, container, false);
        textTeamCode = view.findViewById(R.id.text_delete_team_code);
        buttonDeleteTeam = view.findViewById(R.id.button_delete_team_submit);
        buttonDeleteTeam.setOnClickListener(v -> {
            int varCode = 0;
            try {
                varCode = Integer.parseInt(textTeamCode.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With Team Code", Toast.LENGTH_LONG).show();
            }
            if (MainActivity.myAppDatabase.myDao().getTeamCode(varCode)) {
                Team team = new Team();
                team.setCode(varCode);
                MainActivity.myAppDatabase.myDao().deleteTeam(team);
                Toast.makeText(getActivity(), "Record deleted", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            textTeamCode.setText("");
        });
        return view;
    }
}