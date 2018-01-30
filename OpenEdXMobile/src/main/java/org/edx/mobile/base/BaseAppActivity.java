package org.edx.mobile.base;

import android.content.Context;
import android.os.Bundle;

import com.google.inject.Inject;
import org.edx.mobile.event.NewRelicEvent;

import de.greenrobot.event.EventBus;
import org.edx.mobile.module.prefs.Language;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseAppActivity extends RoboAppCompatActivity {

    @Inject
    Language language;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().post(new NewRelicEvent(getClass().getSimpleName()));
    }

    @Override
    protected void onResume(){
        super.onResume();
        language.setLanguage();
    }
}
