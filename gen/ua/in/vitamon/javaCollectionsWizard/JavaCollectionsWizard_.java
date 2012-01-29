//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package ua.in.vitamon.javaCollectionsWizard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ListView;
import com.googlecode.androidannotations.api.SdkVersionHelper;
import ua.in.vitamon.javaCollectionsWizard.R.id;
import ua.in.vitamon.javaCollectionsWizard.R.layout;
import ua.in.vitamon.javaCollectionsWizard.model.CollectionsListDataProvider_;
import ua.in.vitamon.javaCollectionsWizard.model.SearchParams_;

public final class JavaCollectionsWizard_
    extends JavaCollectionsWizard
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.main_screen);
    }

    private void init_(Bundle savedInstanceState) {
        collectionsListDataProvider = CollectionsListDataProvider_.getInstance_(this);
        searchParams = SearchParams_.getInstance_(this);
    }

    private void afterSetContentView_() {
        cbThreadSafe = ((CheckBox) findViewById(id.cbThreadSafe));
        cbIsInterface = ((CheckBox) findViewById(id.cbIsInterface));
        cbAllowNull = ((CheckBox) findViewById(id.cbAllowNull));
        lvCollections = ((ListView) findViewById(id.lvCollections));
        cbIsSorted = ((CheckBox) findViewById(id.cbIsSorted));
        cbAllowDuplicates = ((CheckBox) findViewById(id.cbAllowDuplicates));
        addListeners();
        ((CollectionsListDataProvider_) collectionsListDataProvider).afterSetContentView_();
        ((SearchParams_) searchParams).afterSetContentView_();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((SdkVersionHelper.getSdkInt()< 5)&&(keyCode == KeyEvent.KEYCODE_BACK))&&(event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public static JavaCollectionsWizard_.IntentBuilder_ intent(Context context) {
        return new JavaCollectionsWizard_.IntentBuilder_(context);
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, JavaCollectionsWizard_.class);
        }

        public Intent get() {
            return intent_;
        }

        public JavaCollectionsWizard_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

    }

}
