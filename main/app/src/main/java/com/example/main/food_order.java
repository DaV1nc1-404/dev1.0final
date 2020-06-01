package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class food_order extends AppCompatActivity {
    TextView setprice;
    TextView initprice;
    TextView totalprice;
    TextView foodname;
    Button add;
    Button sub;
    Button pay;
    private int price;
    private int counter = 0;
    public int total;
    public String itemname;
    public int tprice;
    String uniqueid = UUID.randomUUID().toString();

    private void addc() {
        counter++;
        int tp = counter;
        setprice.setText(counter + "");
        setTotal(tp);
    }

    private void setTotal(int tp) {
        total = price * counter;
        totalprice.setText(String.valueOf(total));


    }

    private void minus() {
        counter--;
        if (counter < 0) {
            Toast.makeText(this, "Cannot add less than 0", Toast.LENGTH_SHORT).show();
            setprice.setText("0");
            counter = 0;
        } else if (counter >= 0) {
            int tp = counter;
            setprice.setText(counter + "");
            setTotal(tp);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);
        add = (Button) findViewById(R.id.addBtn);
        sub = (Button) findViewById(R.id.subBtn);
        setprice = (TextView) findViewById(R.id.setText);
        initprice = (TextView) findViewById(R.id.unitPrice);
        totalprice = (TextView) findViewById(R.id.totalPrice);
        foodname = (TextView) findViewById(R.id.foodName);
        pay = (Button) findViewById(R.id.cPay);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpPayment();
            }
        });
        itemname = getIntent().getStringExtra("name");
        foodname.setText(itemname);
        price = (getIntent().getIntExtra("price", 0));
        initprice.setText(String.valueOf(price));


        initcounter();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addc();

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus();

            }
        });


    }

    private void setUpPayment() {
        final Activity activity = this;
        tprice = total * 100;
        final Checkout checkout=new Checkout();
         JSONObject obj=new JSONObject();
        try {
            obj.put("name", "Cmr Amenity");
            obj.put("description", itemname);
            obj.put("image", "" + R.drawable.logo);
            obj.put("currency", "INR");
            obj.put("amount", tprice);
            JSONObject prefill = new JSONObject();
            prefill.put("email", "tanujraghavan@gmail.com");
            prefill.put("contact", "9866867397");
            prefill.put("prefill", prefill);
            checkout.open(activity, obj);


        } catch (JSONException e) {
            Toast.makeText(activity, "Exception :" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        JSONObject object1 = new JSONObject();
    }

    public void onPaymentSuccess(String razorPayId) {
        openactivity(itemname, total, counter);
        Toast.makeText(this, "PAYMENT SUCCESSFUL" + razorPayId, Toast.LENGTH_SHORT).show();

    }


    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "PAYMENT FAILED" + s, Toast.LENGTH_SHORT).show();

    }

    private void initcounter() {
        counter = 0;

    }

    private void openactivity(String name, int i, int j) {
        int quantity, amount;
        quantity = j;
        amount = i;


        String namef = foodname.getText().toString();
        Intent event = new Intent(food_order.this, paymentsuccess.class);
        event.putExtra("name", namef);
        event.putExtra("quantity", quantity);
        event.putExtra("baseprice", price);
        event.putExtra("total", amount);

        startActivity(event);
    }
}


