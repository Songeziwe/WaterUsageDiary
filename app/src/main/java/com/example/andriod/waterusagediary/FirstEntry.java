package com.example.andriod.waterusagediary;

/* This class models a diary entries page
 *
 * Author: Songeziwe S. Soboois
 * Date: 12/09/2018
 */

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstEntry extends AppCompatActivity {

    DatabaseHelper db;
    Cursor c;
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

    Button next, previous;

    // This method is invoked when the activity is launched
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_entry);

        db = new DatabaseHelper(this);

        c = db.getData(); // creating some kind of a row pointer

        // accessing the buttons
        next = findViewById(R.id.next); // NEXT button
        previous = findViewById(R.id.previous); // PREVIOUS button

        // accessing the views by their id's
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

        c.moveToFirst(); // taking the cursor to the first row
        writeOnActivity(c); // passing in the cursor object as an argument to the method
        previous.setEnabled(false); // disable the PREVIOUS button
    }
    // writing on activity
    public void writeOnActivity(Cursor c){
       // c.moveToFirst(); // taking the cursor to he first row
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
    }
    // this method is invoked when the NEXT or PREVIOUS buttons are clicked
    public void buttonClicked(View view){

        // checking if the view variable is pointing to an object in memory
        if(view != null){

            // checking if the next button is clicked
            if(view.getId() == R.id.next){
                c.moveToNext(); // moving the cursor to the next row
                writeOnActivity(c); // writing to the activity

                // By clicking the NEXT button we enable the PREVIOUS button if not enabled
                if(!previous.isEnabled())
                        previous.setEnabled(true);
            }

            // the else block is for the previous button given that variable view is pointing to an object in memory
            else{

                c.moveToPrevious(); // take the cursor to the previous row
                writeOnActivity(c); // writing to the activity

                // By clicking the PREVIOUS button we enable the NEXT button if not enabled
                if(!next.isEnabled())
                    next.setEnabled(true);
            }

            // Disable the NEXT button if the user is viewing the last diary entry
            if(c.isLast()){
                next.setEnabled(false);  // making the NEXT button disabled
                previous.setEnabled(true); // enabling the PREVIOUS button
            }

            // Disable the PREVIOUS button if the user is viewing the first diary ent
            else if(c.isFirst()){
                next.setEnabled(true);  // enable the NEXT button
                previous.setEnabled(false); // disable the PREVIOUS button
            }
        }
    }
}
