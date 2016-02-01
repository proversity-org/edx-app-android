package org.proversity.edx.mobile.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.proversity.edx.mobile.R;
import org.proversity.edx.mobile.base.BaseSingleFragmentActivity;

public class SettingsActivity extends BaseSingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.settings_txt));
        configureDrawer();
    }

    @Override
    public Fragment getFirstFragment() {
        return new SettingsFragment();
    }

}
