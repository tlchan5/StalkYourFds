package com.example.csci3310gp28.stalkyourfds;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class FdListAdapter extends ArrayAdapter<Friend> {

    private static final String TAG = FdListAdapter.class.getSimpleName();

    /**
     * Constructs a new {@link FdListAdapter}
     * @param context of the app
     * @param fds list of friends in the adapter
     */
    public FdListAdapter(Context context, List<Friend> fds) {
        super(context, 0, fds);
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
        String name = getItem(position).getName();
        String location = getItem(position).getLocation();
        String icon = getItem(position).getIconURL();

        // Bind the contents into the Views
        TextView friendNameView = (TextView) listItemView.findViewById(R.id.friend_name_tv);
        TextView friendLocationView = (TextView) listItemView.findViewById(R.id.friend_location_tv);
        ImageView friendIconView = (ImageView) listItemView.findViewById(R.id.friend_icon_iv);

        friendNameView.setText(name);
        friendLocationView.setText(location);
        if(icon != null) {
            drawIcon(friendIconView, icon);
        } else {
            friendIconView.setImageResource(R.drawable.ic_face_black_24dp);
            friendIconView.setColorFilter(R.color.primary);
        }

        return listItemView;
    }

    /**
     * Puts icon for the specific friend in the friend list, given the icon URL.
     * If the URL is not null but invalid, it will put an error icon to the ImageView.
     * @param iv the target ImageView the icon is located at
     * @param url of the icon
     */
    private void drawIcon(final ImageView iv, String url) {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        Log.v(TAG, "URL: " + url);
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                iv.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iv.setImageResource(R.drawable.ic_error_black_24dp);
                iv.setColorFilter(Color.RED);
            }
        });
        queue.add(request);
    }
}
