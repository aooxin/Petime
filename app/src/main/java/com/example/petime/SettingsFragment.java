package com.example.petime;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        //getPreferenceManager().setSharedPreferencesName("设置");//mySetting就是修改后的配置名
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }


}