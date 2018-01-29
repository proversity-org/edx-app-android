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

  @NonNull
  private final PrefManager.AppInfoPrefManager pref;

  @javax.inject.Inject
  public Language() {
    pref = new PrefManager.AppInfoPrefManager(MainApplication.instance());
  }
  //must put fixes in if app is english and phone is not

  private String language;

  public void setLanguage() {
    getAppLanguageFromLocalStorage();
    getAppLanguageByApi();
  }

  public void setLanguage(String language){
    pref.setLanguage(language);
    Locale locale = new Locale(language);
    Locale.setDefault(locale);
    Configuration config = new Configuration();
    config.locale = locale;
    MainApplication.instance().getResources().updateConfiguration(config, MainApplication.instance().getResources().getDisplayMetrics());
  }

  private void getAppLanguageByApi(){
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

  private void getAppLanguageFromLocalStorage(){
    language = pref.getUserLanguages();
    if(language!=null) {
      setLanguage(language);
    }
  }



}
