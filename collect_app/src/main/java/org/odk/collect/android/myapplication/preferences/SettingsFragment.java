package org.odk.collect.android.myapplication.preferences;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import org.odk.collect.android.BuildConfig;
import org.odk.collect.android.R;
import org.odk.collect.android.activities.FormDownloadList;
import org.odk.collect.android.myapplication.common.DialogFactory;
import org.odk.collect.android.myapplication.onboarding.LoginActivity;
import org.odk.collect.android.myapplication.utils.ActivityUtil;
import org.odk.collect.android.utilities.DialogUtils;
import org.odk.collect.android.utilities.ToastUtils;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;


public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();


    }

    private void init() {
        addPreferencesFromResource(R.xml.pratical_action_preferences);
        String formattedAppName = getString(R.string.app_name) + " " + BuildConfig.VERSION_NAME;
        findPreference(SettingsKeys.KEY_APP_UPDATE).setTitle(formattedAppName);

        findPreference(SettingsKeys.KEY_APP_UPDATE).setOnPreferenceClickListener(this);
        findPreference(SettingsKeys.KEY_LOGOUT).setOnPreferenceClickListener(this);
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case SettingsKeys.KEY_APP_UPDATE:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id" + BuildConfig.APPLICATION_ID));
                startActivity(intent);
                break;
            case SettingsKeys.KEY_LOGOUT:
                logoutConfirmDialog();
                break;

        }
        return false;
    }

    private void logoutConfirmDialog() {

        String message = "All your data will be deleted including \n-forms\n-clusters\n-activities\n-beneficiaries\n";
        DialogFactory.createActionDialog(getActivity(), "Logout", message)
                .setPositiveButton(R.string.dialog_action_ok, (dialog, which) -> {
                    ToastUtils.showLongToast(getString(R.string.please_wait));
                    PraticalActionUserSession.getInstance().logout(deletedForms -> {
                        ActivityUtil.openActivity(LoginActivity.class, getActivity());
                        getActivity().finishAffinity();
                    });
                })
                .setNegativeButton(R.string.dialog_action_dismiss, null)
                .show();

    }
}