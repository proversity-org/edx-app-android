package org.edx.mobile.module.prefs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.edx.mobile.base.MainApplication;
import org.edx.mobile.http.callback.Callback;
import org.edx.mobile.user.Account;
import org.edx.mobile.user.Preferences;
import org.edx.mobile.user.UserService;
import org.edx.mobile.view.MyCoursesListActivity;
import org.edx.mobile.view.Router;
import org.edx.mobile.view.SplashActivity;
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

  @NonNull
  private final PrefManager.AppInfoPrefManager pref;

  @javax.inject.Inject
  public Language() {
    pref = new PrefManager.AppInfoPrefManager(MainApplication.instance());
  }

  public void setLanguage() {
    getAppLanguageFromLocalStorage();
    getAppLanguageByApi();
  }

  public void setLanguage(String language){
      saveLanguage(language);
      changeLanguage(language);
    }

  private void saveLanguage(String language){
    pref.setLanguage(language);
  }

  private void changeLanguage(String language){
    String phoneLanguage = Resources.getSystem().getConfiguration().locale.getLanguage();
    String displayLanguage = Locale.getDefault().getDisplayLanguage().substring(0,2).toLowerCase();
    if (!displayLanguage.toLowerCase().equals(language) && phoneLanguage.equals("en")) {
      Locale locale = new Locale(language);
      Locale.setDefault(locale);
      Configuration config = new Configuration();
      config.locale = locale;
      MainApplication.instance().getResources().updateConfiguration(config, MainApplication.instance().getResources().getDisplayMetrics());
      Intent myIntent = new Intent(MainApplication.instance(), MyCoursesListActivity.class);
      myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
        .FLAG_ACTIVITY_CLEAR_TOP);
      MainApplication.instance().startActivity(myIntent);
    }
  }

  private void getAppLanguageByApi(){
    final Injector injector = RoboGuice.getInjector(MainApplication.instance());
    UserService userService = injector.getInstance(UserService.class);
    userService.getPreferences(loginPrefs.getUsername()).enqueue(new Callback<Preferences>() {
      @Override
      protected void onResponse(@NonNull Preferences preferences) {
        String displayLanguage = Locale.getDefault().getDisplayLanguage().substring(0,2);
        if (!displayLanguage.toLowerCase().equals(preferences.getPrefLang())) {
          setLanguage(preferences.getPrefLang());
        }
      }

      @Override
      protected void onFailure(@NonNull Throwable error) {

      }
    });
  }

  private void getAppLanguageFromLocalStorage(){
    String language = pref.getUserLanguages();
    if(language!=null) {
      changeLanguage(language);
    }
  }



}
