/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.in.vitamon.javaCollectionsWizard.view;

import android.app.Activity;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.ToggleButton;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import ua.in.vitamon.javaCollectionsWizard.R;
import ua.in.vitamon.javaCollectionsWizard.model.CollectionsListDataProvider;
import ua.in.vitamon.javaCollectionsWizard.model.MySharedPrefs_;
import ua.in.vitamon.javaCollectionsWizard.model.SearchParams;

import static ua.in.vitamon.javaCollectionsWizard.model.CollType.*;

@EActivity(R.layout.main_screen)
public class JavaCollectionsWizard extends Activity implements OnCheckedChangeListener {

    @Pref
    public MySharedPrefs_ prefs;

    @Bean
    public CollectionsListDataProvider collectionsListDataProvider;

    @Bean
    public SearchParams searchParams;

    @ViewById
    public ListView lvCollections;

    @ViewById
    public ToggleButton tbIsSorted;
    @ViewById
    public ToggleButton tbAllowDuplicates;
    @ViewById
    public ToggleButton tbIsInterface;
    @ViewById
    public ToggleButton tbThreadSafe;
    @ViewById
    public ToggleButton tbAllowNull;

    @AfterViews
    public void addListeners() {
        if (prefs.firstRun().get()) {
            showGreetDialog();
        }
        searchParams.reset();
        tbIsInterface.setOnCheckedChangeListener(this);
        tbIsSorted.setOnCheckedChangeListener(this);
        tbThreadSafe.setOnCheckedChangeListener(this);
        tbAllowDuplicates.setOnCheckedChangeListener(this);
        tbAllowNull.setOnCheckedChangeListener(this);
        //
        updateCollectionsList();
    }

    private void showGreetDialog() {
        Intent intent = new Intent(this, WelcomeDialog_.class);
        startActivity(intent);
        prefs.edit().firstRun().put(false).apply();
    }

    private void updateCollectionsList() {
        lvCollections.setAdapter(new ListViewAdapter(this, collectionsListDataProvider.getCollections(searchParams)));
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == tbIsInterface) {
            searchParams.setSearchParam(INTERFACE, isChecked);
        } else if (buttonView == tbIsSorted) {
            searchParams.setSearchParam(SORTABLE, isChecked);
        } else if (buttonView == tbThreadSafe) {
            searchParams.setSearchParam(THREAD_SAFE, isChecked);
        } else if (buttonView == tbAllowDuplicates) {
            searchParams.setSearchParam(ALLOW_DUPLICATES, isChecked);
        } else if (buttonView == tbAllowNull) {
            searchParams.setSearchParam(ALLOW_NULL, isChecked);
        }
        updateCollectionsList();
    }
}
