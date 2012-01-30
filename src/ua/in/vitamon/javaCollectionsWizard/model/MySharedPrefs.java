package ua.in.vitamon.javaCollectionsWizard.model;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by IntelliJ IDEA.
 * User: Vit
 * Date: 31.01.12
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
@SharedPref
public interface MySharedPrefs {

    @DefaultBoolean(true)
    boolean firstRun();
}