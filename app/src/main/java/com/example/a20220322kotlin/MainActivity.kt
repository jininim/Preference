package com.example.a20220322kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val id = sharedPreferences.getString("id" , " ")
        if (id != null) {
            Log.d("jinnnnnnnnnnnnnnn : " , id)
        }


    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat,
        pref: Preference
    ): Boolean {
        val args = pref.extras
        val fragment = pref.fragment?.let {
            supportFragmentManager.fragmentFactory.instantiate(
                classLoader ,
                it
            )

        }
        if (fragment != null) {
            fragment.arguments = args
        }
        fragment?.setTargetFragment(caller , 0)
        //기존프래그먼트 새 프래그먼트로 바꾸기
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment , fragment)
                .addToBackStack(null)
                .commit()

        }
        return true
    }
}