package com.example.sporthub5.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sporthub5.Update.Fragment_Update_1_Sport;
import com.example.sporthub5.Update.Fragment_Update_2_Athlete;
import com.example.sporthub5.Update.Fragment_Update_3_Team;
import com.example.sporthub5.Update.Fragment_Update_4_Race;

public class ViewPagerUpdate extends FragmentPagerAdapter {
    private int tabsNumber;

    public ViewPagerUpdate(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Fragment_Update_1_Sport();
            case 1:
                return new Fragment_Update_2_Athlete();
            case 2:
                return new Fragment_Update_3_Team();
            case 3:
                return new Fragment_Update_4_Race();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
