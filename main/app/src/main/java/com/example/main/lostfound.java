package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.GridLayout;

public class lostfound extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostfound);
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
                        Intent intent=new Intent(lostfound.this, lostregister.class);
                        startActivity(intent);


                    } else if (fin == 1) {
                        Intent intent=new Intent(lostfound.this, foundReg.class);
                        startActivity(intent);

                    } else if (fin == 2) {

                    }
                }
            });
        }
    }
}
