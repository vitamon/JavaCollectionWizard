package ua.in.vitamon.javaCollectionsWizard.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ua.in.vitamon.javaCollectionsWizard.R;

import java.util.Arrays;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;

    private List<String> items;

    public ListViewAdapter(Context context, String[] items) {
        this.context = context;
        this.items = Arrays.asList(items);
    }

    public int getCount() {
        return items.size();
    }

    public String getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        String entry = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);
        }
        TextView tvContact = (TextView) convertView.findViewById(R.id.class_name);
        tvContact.setText(entry);

        return convertView;
    }

}
