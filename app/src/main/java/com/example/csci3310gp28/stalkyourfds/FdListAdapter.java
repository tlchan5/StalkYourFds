package com.example.csci3310gp28.stalkyourfds;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FdListAdapter extends ArrayAdapter<String> {

    /**
     * Constructs a new {@link FdListAdapter}
     * @param context of the app
     * @param friends list of friends in the adapter
     */
    public FdListAdapter(Context context, List<String> friends) {
        super(context, 0, friends);
    }

    /**
     * Returns a list view which displays the list of friends detected by iBeacons.
     * @param position
     * @param convertView
     * @param parent
     * @return list of friends
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate a new list item layout there is no list item view we can reuse
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fd_list_item, parent, false);
        }

        // get the current object according to the position
        String friend = getItem(position);

        // Bind the contents into the Views
        TextView friendNameView = (TextView) listItemView.findViewById(R.id.friend_name_tv);
        friendNameView.setText(friend);

        return listItemView;
    }
}
