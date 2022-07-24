package com.example.sporthub5.Update;

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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Update_1_Sport extends Fragment {
    EditText textSportId, textSportName;

    Spinner spinnerSportType, spinnerSportGender;

    Button buttonUpdateSport;

    public Fragment_Update_1_Sport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_1_sport, container, false);

        textSportId = view.findViewById(R.id.text_update_sport_id);
        textSportName = view.findViewById(R.id.text_update_sport_name);

        spinnerSportType = (Spinner) view.findViewById(R.id.spinner_update_sport_type);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.SportType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSportType.setAdapter(adapter);

        spinnerSportGender = (Spinner) view.findViewById(R.id.spinner_update_sport_gender);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.SportGender, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSportGender.setAdapter(adapter1);

        buttonUpdateSport = view.findViewById(R.id.button_update_sport_submit);
        buttonUpdateSport.setOnClickListener(v -> {

            boolean flag= false;
            int varId = 0;
            try {
                varId = Integer.parseInt(textSportId.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(getActivity(), "Something Went Wrong With ID", Toast.LENGTH_LONG).show();
            }

            String varName = textSportName.getText().toString();
            String varType = spinnerSportType.getSelectedItem().toString();
            String varGender = spinnerSportGender.getSelectedItem().toString();

            if (MainActivity.myAppDatabase.myDao().getIdSport(varId)) {
                List<Sport> sport = MainActivity.myAppDatabase.myDao().getSports();
                Sport sport1 = new Sport();
                for (Sport i : sport) {
                    if (varId == i.getId()) {
                        flag = true;
                        if (!varName.equals(i.getName()) && varName.length() != 0) {
                            sport1.setId(varId);

                            sport1.setName(varName);

                            if (!varType.equals(i.getType()))
                                sport1.setType(varType);
                            else if (varType.equals(i.getType()))
                                sport1.setType(i.getType());


                            if (!varGender.equals(i.getGender()))
                                sport1.setGender(varGender);
                            else if (varGender.equals(i.getGender()))
                                sport1.setGender(i.getGender());

                        } else if (varName.length() == 0) {
                            flag = true;
                            sport1.setId(varId);

                            sport1.setName(i.getName());

                            if (!varType.equals(i.getType()))
                                sport1.setType(varType);
                            else if (varType.equals(i.getType()))
                                sport1.setType(i.getType());

                            if (!varGender.equals(i.getGender()))
                                sport1.setGender(varGender);
                            else if (varGender.equals(i.getGender()))
                                sport1.setGender(i.getGender());

                        }
                        MainActivity.myAppDatabase.myDao().updateSport(sport1);
                    }
                }
                if (flag)
                    Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Record doesn't exist ", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
            textSportId.setText("");
            textSportName.setText("");
        });
        return view;
    }
}