package com.example.sporthub5.Query;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sporthub5.MainActivity;
import com.example.sporthub5.R;
import com.example.sporthub5.RoomDatabase.Race;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Query_4_Race extends Fragment {

    TextView textRaceQuery;

    public Fragment_Query_4_Race() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_4_race, container, false);

        textRaceQuery = view.findViewById(R.id.text_query_race);

        CollectionReference collectionReference = MainActivity.myFirebaseFireStore.collection("Race");

        collectionReference.
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Race race = documentSnapshot.toObject(Race.class);
                    String sport = race.getSport();
                    String date = race.getDate1();
                    String city = race.getCity();
                    String country = race.getCountry();
                    String Player1 = race.getPlayer1();
                    String Player2 = race.getPlayer2();
                    int Score1 = race.getScore1();
                    int Score2 = race.getScore2();
                    result += "\n Sport: " + sport +
                            "\n Date: " + date +
                            "\n City: " + city +
                            "\n Country: " + country +
                            "\n Player1: " + Player1 +
                            "\n Player2: " + Player2 +
                            "\n Score1: " + Score1 +
                            "\n Score2: " + Score2 + "\n";
                }
                textRaceQuery.setText(result);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "query operation failed.", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}