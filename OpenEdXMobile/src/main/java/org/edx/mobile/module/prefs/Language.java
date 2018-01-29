package org.edx.mobile.module.prefs;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.edx.mobile.base.MainApplication;
import org.edx.mobile.http.callback.Callback;
import org.edx.mobile.user.Account;
import org.edx.mobile.user.Preferences;
import org.edx.mobile.user.UserService;
import roboguice.RoboGuice;

import javax.inject.Singleton;
import java.util.Locale;

/**
 * Created by adamkatz on 2018/01/29.
 */

//This class is custom to CIT and is here to change language locale if the user selects a language change in app
@Singleton
public class Language {

  @Inject
  LoginPrefs loginPrefs;

  private boolean isLanguageSet = false;



  public void setLanguage() {
    if (!isLanguageSet) {
      String phoneLanguage = Locale.getDefault().getDisplayLanguage();
      if (phoneLanguage.equals("English")) {
        getAppLanguage();
      }
      isLanguageSet = true;
    }
  }

  public void setLanguage(String language){
    String phoneLanguage =  Locale.getDefault().getDisplayLanguage();
    if(phoneLanguage.equals("English")) {
      Locale locale = new Locale(language);
      Locale.setDefault(locale);
      Configuration config = new Configuration();
      config.locale = locale;
      MainApplication.instance().getResources().updateConfiguration(config, MainApplication.instance().getResources().getDisplayMetrics());
    }
    isLanguageSet = true;
  }

  private void getAppLanguage(){
    final Injector injector = RoboGuice.getInjector(MainApplication.instance());
    UserService userService = injector.getInstance(UserService.class);
    userService.getPreferences(loginPrefs.getUsername()).enqueue(new Callback<Preferences>() {
      @Override
      protected void onResponse(@NonNull Preferences preferences) {
        setLanguage(preferences.getPrefLang());
      }

      @Override
      protected void onFailure(@NonNull Throwable error) {

      }
    });
  }



}
