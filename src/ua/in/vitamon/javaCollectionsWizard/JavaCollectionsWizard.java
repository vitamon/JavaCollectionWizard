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

package ua.in.vitamon.javaCollectionsWizard;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Inject;
import com.googlecode.androidannotations.annotations.ViewById;
import ua.in.vitamon.javaCollectionsWizard.model.CollectionsListDataProvider;
import ua.in.vitamon.javaCollectionsWizard.model.SearchParams;

@EActivity(R.layout.main_screen)
public class JavaCollectionsWizard extends Activity {

    @Inject
    public CollectionsListDataProvider collectionsListDataProvider;

    @Inject
    public SearchParams searchParams;

    @ViewById
    public ListView lvCollections;

    @ViewById
    public CheckBox cbIsSorted;
    @ViewById
    public CheckBox cbAllowDuplicates;
    @ViewById
    public CheckBox cbIsInterface;
    @ViewById
    public CheckBox cbThreadSafe;
    @ViewById
    public CheckBox cbAllowNull;

    @AfterViews
    public void addListeners() {
        cbIsInterface.setOnCheckedChangeListener(comboChangedListener);
        cbIsSorted.setOnCheckedChangeListener(comboChangedListener);
        cbThreadSafe.setOnCheckedChangeListener(comboChangedListener);
        cbAllowDuplicates.setOnCheckedChangeListener(comboChangedListener);
        cbAllowNull.setOnCheckedChangeListener(comboChangedListener);
        //
        updateCollectionsList();
    }

    private CompoundButton.OnCheckedChangeListener comboChangedListener = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView == cbIsInterface) {
                searchParams.setInterface(isChecked);
            } else if (buttonView == cbIsSorted) {
                searchParams.setSorted(isChecked);
            } else if (buttonView == cbThreadSafe) {
                searchParams.setThreadSafe(isChecked);
            } else if (buttonView == cbAllowDuplicates) {
                searchParams.setAllowDuplicates(isChecked);
            } else if (buttonView == cbAllowNull) {
                searchParams.setNullAllowed(isChecked);
            }
            updateCollectionsList();
        }
    };

    private void updateCollectionsList() {
        lvCollections.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, collectionsListDataProvider.getCollections(searchParams)));
    }

}
