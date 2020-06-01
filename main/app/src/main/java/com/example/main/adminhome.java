package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class adminhome extends AppCompatActivity {
    GridLayout mainGrid;
    TextView evetext;
    TextView comtext;
    TextView lftext;
    ImageView eventimg;
    ImageView compimg;
    ImageView lfimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        eventimg =(ImageView)findViewById(R.id.eveImg);
        evetext=(TextView) findViewById(R.id.eventHome);
        comtext=(TextView) findViewById(R.id.comtext);
        lftext=(TextView) findViewById(R.id.lftext);
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
                        Intent prof = new Intent(adminhome.this, admin_event.class);
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(eventimg, "evepic");
                        pairs[1] = new Pair<View, String>(evetext,"evetext");
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(adminhome.this, pairs);
                            startActivity(prof, options.toBundle());
                        }
                    } else if (fin == 1) {
                        Intent comp = new Intent(adminhome.this, admin_complaints.class);
                         startActivity(comp);
                    } else if (fin == 2) {
                        Intent lf = new Intent(adminhome.this, food.class);
                        startActivity(lf);
                        }
                    }

            });
    }

    }
}
