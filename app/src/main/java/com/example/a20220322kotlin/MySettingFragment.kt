package com.example.a20220322kotlin

import android.os.Bundle
import android.text.TextUtils
import androidx.preference.EditTextPreference
import androidx.preference.Preference

import androidx.preference.PreferenceFragmentCompat

class MySettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference,rootKey)

        val idPreference : EditTextPreference? = findPreference("id")
        idPreference?.summary = "code summary"
        idPreference?.title = "code title"
        idPreference?.summaryProvider =
            Preference.SummaryProvider<EditTextPreference> {
                val text = it.text
                if(TextUtils.isEmpty(text)){
                    "설정 되지 않음"
                }else{
                    "설정된 ID : $text 입니다"
                }
            }
    }


}