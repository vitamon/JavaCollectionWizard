package ua.in.vitamon.javaCollectionsWizard.view;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import ua.in.vitamon.javaCollectionsWizard.R;

@EActivity(R.layout.welcome_dialog)
public class WelcomeDialog extends Activity implements LinearLayout.OnClickListener {

    @ViewById
    TextView textViewWelcome;

    @AfterViews
    public void init() {
        textViewWelcome.setOnClickListener(this);
    }

    public void onClick(View v) {
        finish();
    }
}
