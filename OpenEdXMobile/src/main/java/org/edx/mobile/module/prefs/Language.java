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
  private final PrefManager pref;

  @javax.inject.Inject
  public Language(@NonNull Context context) {
    pref = new PrefManager(context, PrefManager.Pref.USER_PREF);
  }


  private String language;

  public void setLanguage() {
    String phoneLanguage = Locale.getDefault().getDisplayLanguage();
    if (phoneLanguage.equals("English")) {
      getAppLanguageFromLocalStorage();
      getAppLanguageByApi();
    }
  }

  public void setLanguage(String language){
    String phoneLanguage =  Locale.getDefault().getDisplayLanguage();
    if(phoneLanguage.equals("English")) {
      pref.put(PrefManager.Key.USER_LANGUAGE, language);
      Locale locale = new Locale(language);
      Locale.setDefault(locale);
      Configuration config = new Configuration();
      config.locale = locale;
      MainApplication.instance().getResources().updateConfiguration(config, MainApplication.instance().getResources().getDisplayMetrics());
    }
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
    PrefManager.AppInfoPrefManager pmanager = new PrefManager.AppInfoPrefManager(MainApplication.instance());
    language = pmanager.getUserLanguages();
    if(language!=null) {
      setLanguage(language);
    }
  }



}
