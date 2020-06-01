package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Events extends AppCompatActivity {
     public static String namef;
    GridLayout mainGrid;
    String event;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        mainGrid= (GridLayout)findViewById(R.id.mainGrid);
        setEvent(mainGrid);


    }

    private void setEvent(GridLayout mainGrid) {
        for (int i =0; i< mainGrid.getChildCount(); i++){
            CardView cardview=(CardView)mainGrid.getChildAt(i);
            final int finv =i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finv == 0) {
                        TextView event= (TextView)findViewById(R.id.evCl1);
                        String name= event.getText().toString();
                        openactivity(name);



                    }
                    else if(finv==1){
                        TextView event= (TextView)findViewById(R.id.evCl2);
                        String name= event.getText().toString();
                        openactivity(name);

                    } else if(finv==2){
                        TextView event= (TextView)findViewById(R.id.evCl3);
                        String name= event.getText().toString();
                        openactivity(name);

                    } else if(finv==3){
                        TextView event= (TextView)findViewById(R.id.evCl4);
                        String name= event.getText().toString();
                        openactivity(name);


                    }
                    else if(finv==4){
                        TextView event= (TextView)findViewById(R.id.evCl5);
                        String name= event.getText().toString();
                        openactivity(name);


                    }else if(finv==5){
                        TextView event= (TextView)findViewById(R.id.evCl6);
                        String name= event.getText().toString();
                        openactivity(name);


                    }
                    else if(finv==6){
                        TextView event= (TextView)findViewById(R.id.evCl7);
                        String name= event.getText().toString();
                        openactivity(name);


                    }
                    else if(finv==7){
                        TextView event= (TextView)findViewById(R.id.evCl8);
                        String name= event.getText().toString();
                        openactivity(name);


                    }else if(finv==8){
                        TextView event= (TextView)findViewById(R.id.evCl9);
                        String name= event.getText().toString();
                        openactivity(name);


                    }
                    else if(finv==9){
                        TextView event= (TextView)findViewById(R.id.evCl10);
                        String name= event.getText().toString();
                        openactivity(name);
                    }
                    else if(finv==10){
                        TextView event= (TextView)findViewById(R.id.evCl11);
                        String name= event.getText().toString();
                        openactivity(name);
                    }
                    else if(finv==11){
                        TextView event= (TextView)findViewById(R.id.evCl12);
                        String name= event.getText().toString();
                        openactivity(name);
                    }
                    else if(finv==12){
                        TextView event= (TextView)findViewById(R.id.evCl13);
                        String name= event.getText().toString();
                        openactivity(name);
                    }
                    else if(finv==13){
                        TextView event= (TextView)findViewById(R.id.evCl14);
                        String name= event.getText().toString();
                        openactivity(name);
                    }  else if(finv==14){
                        TextView event= (TextView)findViewById(R.id.evCl15);
                        String name= event.getText().toString();
                        openactivity(name);
                    }
                    else if(finv==15){
                        TextView event= (TextView)findViewById(R.id.evCl16);
                        String name= event.getText().toString();
                        openactivity(name);
                    }


                }
            });
        }

    }

    private void openactivity(String name) {

        namef= name.toString();
        Intent event= new Intent(Events.this, eventshow.class);
        event.putExtra("name",namef);



        startActivity(event);

    }


}

