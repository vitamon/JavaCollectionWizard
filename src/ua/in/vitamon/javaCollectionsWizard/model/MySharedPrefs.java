package ua.in.vitamon.javaCollectionsWizard.model;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface MySharedPrefs {

    @DefaultBoolean(true)
    boolean firstRun();
}