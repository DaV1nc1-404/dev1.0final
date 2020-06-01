package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class food extends AppCompatActivity {
    public static String namef;
    public static int price;
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

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
                        TextView event= (TextView)findViewById(R.id.itN1);
                        String name= event.getText().toString();
                        openactivity(name, 20);



                    }
                    else if(finv==1){
                        TextView event= (TextView)findViewById(R.id.itN2);
                        String name= event.getText().toString();
                        openactivity(name, 25);

                    } else if(finv==2){
                        TextView event= (TextView)findViewById(R.id.itN3);
                        String name= event.getText().toString();
                        openactivity(name, 40);

                    } else if(finv==3){
                        TextView event= (TextView)findViewById(R.id.itN4);
                        String name= event.getText().toString();
                        openactivity(name, 25);


                    }
                    else if(finv==4){
                        TextView event= (TextView)findViewById(R.id.itN5);
                        String name= event.getText().toString();
                        openactivity(name, 45);


                    }else if(finv==5){
                        TextView event= (TextView)findViewById(R.id.itN6);
                        String name= event.getText().toString();
                        openactivity(name, 50);


                    }
                    else if(finv==6){
                        TextView event= (TextView)findViewById(R.id.itN7);
                        String name= event.getText().toString();
                        openactivity(name, 10);


                    }
                    else if(finv==7){
                        TextView event= (TextView)findViewById(R.id.itN8);
                        String name= event.getText().toString();
                        openactivity(name, 20);


                    }else if(finv==8){
                        TextView event= (TextView)findViewById(R.id.itN9);
                        String name= event.getText().toString();
                        openactivity(name, 50);


                    }
                    else if(finv==9){
                        TextView event= (TextView)findViewById(R.id.itN10);
                        String name= event.getText().toString();
                        openactivity(name, 25);


                    }




                }
            });
        }
    }
    private void openactivity(String name, int i) {
        price=i;

        namef= name.toString();
        Intent event= new Intent(food.this, food_order.class);
        event.putExtra("name",namef);
        event.putExtra("price", food.price);
        startActivity(event);

    }
}
