package com.example.sporthub5.Update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Race;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Update_4_Race extends Fragment {
    EditText textRaceDate;
    EditText textRaceCity;
    EditText textRaceCountry;
    EditText textRaceSport;
    EditText textRacePlayer1;
    EditText textRacePlayer2;
    EditText textRaceScore1;
    EditText textRaceScore2;

    Button buttonInsertRace;

    public Fragment_Update_4_Race() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_4_race, container, false);

        textRaceDate = view.findViewById(R.id.text_update_race_date);
        textRaceCity = view.findViewById(R.id.text_update_race_city);
        textRaceCountry = view.findViewById(R.id.text_update_race_country);
        textRaceSport = view.findViewById(R.id.text_update_race_sport);
        textRacePlayer1 = view.findViewById(R.id.text_update_player1_sport);
        textRacePlayer2 = view.findViewById(R.id.text_update_player2_sport);
        textRaceScore1 = view.findViewById(R.id.text_update_score1_sport);
        textRaceScore2 = view.findViewById(R.id.text_update_score2_sport);

        buttonInsertRace = view.findViewById(R.id.button_update_race_submit);
        buttonInsertRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String varDate = textRaceDate.getText().toString();
                String varCity = textRaceCity.getText().toString();
                String varCountry = textRaceCountry.getText().toString();
                String varSport = textRaceSport.getText().toString();
                String varPlayer1 = textRacePlayer1.getText().toString();
                String varPlayer2 = textRacePlayer2.getText().toString();

                int varScore1 = 0;
                try {
                    varScore1 = Integer.parseInt(textRaceScore1.getText().toString());
                } catch (NumberFormatException ex) {
                    Toast.makeText(getActivity(), "Something Went Wrong With Score 1", Toast.LENGTH_LONG).show();
                }

                int varScore2 = 0;
                try {
                    varScore2 = Integer.parseInt(textRaceScore2.getText().toString());
                } catch (NumberFormatException ex) {
                    Toast.makeText(getActivity(), "Something Went Wrong With Score 2", Toast.LENGTH_LONG).show();
                }

                

                try {
                    DocumentReference contact= MainActivity.myFirebaseFireStore.
                            collection("Race").document("race"+varDate);
                    contact.update("city",varCity,
                            "country",varCountry,
                            "date",varDate,
                            "sport",varSport,
                            "player1",varPlayer1,
                            "player2",varPlayer2,
                            "score1",varScore1,
                            "score2",varScore2).
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "Record Updated", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
                                }
                    });
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Something Went Wrong With Request", Toast.LENGTH_LONG).show();
                }
            }
        });
        textRaceDate.setText("");
        textRaceCity.setText("");
        textRaceCountry.setText("");
        textRaceSport.setText("");
        textRacePlayer1.setText("");
        textRacePlayer2.setText("");
        textRaceScore1.setText("");
        textRaceScore2.setText("");
        return view;
    }
}