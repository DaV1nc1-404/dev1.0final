package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    Toolbar toolbar;
    GridLayout mainGrid;
    TextView events;
    TextView lostfound;
    TextView complaints;
    TextView  foodt;
    ImageView eventimage;
    ImageView foodimage;
    ImageView compimg;
    ImageView lfimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        events=(TextView) findViewById(R.id.eventHome);
        lostfound=(TextView) findViewById(R.id.lfHome);
        complaints=(TextView) findViewById(R.id.compHome);
        foodt=(TextView) findViewById(R.id.foodHome);
        eventimage=(ImageView)findViewById(R.id.eveImg);
        lfimg=(ImageView)findViewById(R.id.lfImg);
        compimg=(ImageView)findViewById(R.id.compImg);
        foodimage=(ImageView)findViewById(R.id.foodImage);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationview=(NavigationView) findViewById(R.id.nav_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar=(Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Cmr Amenity");
        }

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationview.bringToFront();
        navigationview.setNavigationItemSelectedListener(this);
        mainGrid= (GridLayout)findViewById(R.id.mainGrid);
        setEvent(mainGrid);
    }

    private void setEvent(GridLayout mainGrid) {
        for (int i =0; i< mainGrid.getChildCount(); i++){
            CardView cardview=(CardView)mainGrid.getChildAt(i);
            final int fin =i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fin == 0) {
                        Intent prof = new Intent(home.this, Events.class);
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(eventimage, "pic");
                        pairs[1] = new Pair<View, String>(events, "text");
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this, pairs);
                            startActivity(prof, options.toBundle());
                        }
                    } else if (fin == 1) {
                        Intent lf = new Intent(home.this,lostfound.class);
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(lfimg, "lfimg");
                        pairs[1] = new Pair<View, String>(lostfound, "lftext");
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this, pairs);
                            startActivity(lf, options.toBundle());
                        }
                    }

                     else if (fin == 2) {
                        Intent food = new Intent(home.this, food.class);
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(foodimage, "food");
                        pairs[1] = new Pair<View, String>(foodt, "textfood");
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this, pairs);
                            startActivity(food, options.toBundle());
                        }
                    } else if (fin == 3) {
                        Intent comp = new Intent(home.this, complains.class);
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(compimg, "compimg");
                        pairs[1] = new Pair<View, String>(complaints, "comptext");
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this, pairs);
                            startActivity(comp, options.toBundle());
                        }

                    }
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_profile:
                Intent intent =new Intent(home.this, profile_dashboard.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                Intent intent1 =new Intent(home.this, settings.class);
                startActivity(intent1);
                break;
        }
        return true;
    }
}
