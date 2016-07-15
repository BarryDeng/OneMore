package com.example.yanghuan.onemorecharge.SideSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.example.yanghuan.onemorecharge.R;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class SettingActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener{
    /*    private SwitchPreference InformChange;
    private ListPreference LanguageChange;
    private Preference UserReturn;
    private Preference Update;
    private Preference AboutUs;
    private Preference Logout;
    private AlertDialog.Builder builder;*/

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.set_layout);
 /*     InformChange = (SwitchPreference) findPreference("remainder");
        LanguageChange = (ListPreference) findPreference("change_language");
        UserReturn = (Preference)findPreference("users_return");
        Update = (Preference)findPreference("update_version");*/
        Preference AboutUs = (Preference)findPreference("codex");
        // Logout = (Preference)findPreference("logout");

        /*
        InformChange.setOnPreferenceChangeListener(this);
        LanguageChange.setOnPreferenceClickListener(this);
        UserReturn.setOnPreferenceClickListener(this);
        Update.setOnPreferenceClickListener(this);
        */
        AboutUs.setOnPreferenceClickListener(this);
        // Logout.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()){
            case "codex":
                startActivity(new Intent(SettingActivity.this, AboutusActivity.class));
                break;
            case "change_language":
                showLanguageChangeDialog(preference);
                break;
            case "users_return":

            case "update_version":

            case "logout":

            default:
        }

        return true;
    }


    /*
    点击提醒， 设置开关，若是开启。则调用通知栏通知方法
     */
     /*
    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }*/

    //显示语言切换的对话列表框

    public  void showLanguageChangeDialog(Preference view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.language_menu);
        final String []Items ={"中文", "英文"};
        builder.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "您选择了" + Items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
