package com.example.csci3310gp28.stalkyourfds;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class StalkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalk);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stalk, menu);
        // Set menu item to have white color
        setMenuItemColor(menu, R.id.menu_add, Color.WHITE);
        setMenuItemColor(menu, R.id.menu_logout, Color.WHITE);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_add:
                return true;
            case R.id.menu_update:
                return true;
            case R.id.menu_logout:
                // TODO implement logout function
                // Below are just temporary codes
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Set color for the specified menu item.
     * @param menu is the menu the item is located at
     * @param res is the resource ID of the menu item
     * @param color is the color of the item
     */
    private void setMenuItemColor(Menu menu, int res, int color) {
        Drawable icon = menu.findItem(res).getIcon();
        if(icon != null) {
            icon.mutate();
            icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
