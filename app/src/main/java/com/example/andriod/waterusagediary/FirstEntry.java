package com.example.andriod.waterusagediary;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FirstEntry extends AppCompatActivity {

    public DatabaseHelper db;
    TextView showerTotal;
    TextView toiletTotal;
    TextView hygieneTotal;
    TextView laundryTotal;
    TextView dishTotal;
    TextView drinkTotal;
    TextView cookTotal;
    TextView cleanTotal;
    TextView otherTotal;
    TextView finalTotal;
    TextView entryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_entry);

        db = new DatabaseHelper(this);

        Cursor c = db.getData(); // creating some kind of a row pointer

        showerTotal = findViewById(R.id.t1);
        toiletTotal = findViewById(R.id.t2);
        hygieneTotal = findViewById(R.id.t3);
        laundryTotal = findViewById(R.id.t4);
        dishTotal = findViewById(R.id.t5);
        drinkTotal = findViewById(R.id.t6);
        cookTotal = findViewById(R.id.t7);
        cleanTotal = findViewById(R.id.t8);
        otherTotal = findViewById(R.id.t9);
        finalTotal = findViewById(R.id.t10);
        entryDate = findViewById(R.id.textView2);

        //if(c.isLast()) // checking if the pointer is on the last row
       // {
            c.moveToFirst(); // taking the cursor to he first row
            showerTotal.setText(c.getString(2));
            toiletTotal.setText(c.getString(4));
            hygieneTotal.setText(c.getString(6));
            laundryTotal.setText(c.getString(8));
            dishTotal.setText(c.getString(10));
            drinkTotal.setText(c.getString(12));
            cookTotal.setText(c.getString(14));
            cleanTotal.setText(c.getString(16));
            otherTotal.setText(c.getString(18));
            finalTotal.setText(c.getString(19));
            entryDate.setText(c.getString(20));


       //}

        //public void
    }
}
