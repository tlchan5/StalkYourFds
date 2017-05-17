package com.example.csci3310gp28.stalkyourfds;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.InputStream;
import java.net.URL;

public class Friend {

    private String mName;
    private String mIcon;
    private String mLocation;

    /**
     * Construct a friend information for the friend list
     * @param name of the friend
     * @param icon URL of the friend
     * @param location of the friend (e.g. SHB 123, SHB 924)
     */
    public Friend(@NonNull String name, @Nullable String icon, @NonNull String location) {
        this.mName = name;
        this.mIcon = icon;
        this.mLocation = location;
    }

    /**
     * Retrieve the friend's name.
     * @return name of the friend
     */
    public String getName() {
        return mName;
    }

    /**
     * Retrieve the icon URL of the friend.
     */
    public String getIconURL() {
        return mIcon;
    }

    /**
     * Retrieve the location of the friend.
     */
    public String getLocation() {
        return mLocation;
    }
}
