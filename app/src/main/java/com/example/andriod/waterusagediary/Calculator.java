package com.example.andriod.waterusagediary;

/* After clicking on the calculator launcher of the overview activity this activity is invoked
 *
 * Author: Songeziwe S. Soboois
 * Date: 12/09/2018
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator extends AppCompatActivity {

    private int numForShower, numForToilet, numForHygiene, numForLaundry, numForDish, numForDrink;
    private int numForCook, numForClean, numForOther;
    private int runTotalShower, runTotalLaundry, runTotalDrink, runTotalCook, runTotalClean;
    private double runTotalToilet, runTotalHygiene, runTotalDish, runTotalOther;
    private double Total;
    public TextView runningTotal;
    public EditText finalEdit;

    public DatabaseHelper db;

    private DecimalFormat object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        numForShower = 0;
        numForToilet = 0;
        numForHygiene = 0;
        numForDish = 0;
        numForDrink = 0;
        numForCook = 0;
        numForCook = 0;
        numForOther = 0;
        Total = 0;
        db = new DatabaseHelper(this);
        finalEdit= findViewById(R.id.t10);
        finalEdit.setEnabled(false);
        object = new DecimalFormat("##0.0");

        // make EditTex to be not editable
        EditText Edit1 = findViewById(R.id.t1);
        Edit1.setEnabled(false);
        EditText Edit2 = findViewById(R.id.t2);
        Edit2.setEnabled(false);
        EditText Edit3 = findViewById(R.id.t3);
        Edit3.setEnabled(false);
        EditText Edit4 = findViewById(R.id.t4);
        Edit4.setEnabled(false);
        EditText Edit5 = findViewById(R.id.t5);
        Edit5.setEnabled(false);
        EditText Edit6 = findViewById(R.id.t6);
        Edit6.setEnabled(false);
        EditText Edit7 = findViewById(R.id.t7);
        Edit7.setEnabled(false);
        EditText Edit8 = findViewById(R.id.t8);
        Edit8.setEnabled(false);
        EditText Edit9 = findViewById(R.id.t9);
        Edit9.setEnabled(false);

    }

    public void saveEntry(View view){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date_obj = new Date();

        TextView tvShower = findViewById(R.id.shower);
        String s1 = tvShower.getText().toString();
        EditText t1 = findViewById(R.id.t1);
        String s11 = t1.getText().toString();
        //tvShower.setText(s11.substring(0,1));

        TextView tvToilet = findViewById(R.id.toilet);
        String s2 = tvToilet.getText().toString();
        EditText t2 = findViewById(R.id.t2);
        String s22 = t2.getText().toString();

        TextView tvHygiene = findViewById(R.id.hygiene);
        String s3 = tvHygiene.getText().toString();
        EditText t3 = findViewById(R.id.t3);
        String s33 = t3.getText().toString();

        TextView tvLaundry = findViewById(R.id.laundry);
        String s4 = tvLaundry.getText().toString();
        EditText t4 = findViewById(R.id.t4);
        String s44 = t4.getText().toString();

        TextView tvDish = findViewById(R.id.dish);
        String s5 = tvDish.getText().toString();
        EditText t5 = findViewById(R.id.t5);
        String s55 = t5.getText().toString();

        TextView tvDrink = findViewById(R.id.drink);
        String s6 = tvDrink.getText().toString();
        EditText t6 = findViewById(R.id.t6);
        String s66 = t6.getText().toString();

        TextView tvCook = findViewById(R.id.cook);
        String s7 = tvCook.getText().toString();
        EditText t7 = findViewById(R.id.t7);
        String s77 = t7.getText().toString();

        TextView tvClean = findViewById(R.id.clean);
        String s8 = tvClean.getText().toString();
        EditText t8 = findViewById(R.id.t8);
        String s88 = t8.getText().toString();

        TextView tvOther = findViewById(R.id.other);
        String s9 = tvOther.getText().toString();
        EditText t9 = findViewById(R.id.t9);
        String s99 = t9.getText().toString();

        EditText t10 = findViewById(R.id.t10);
        String s10 = t10.getText().toString();

        boolean inserted = db.insert_Entery(s1, s11, s2, s22,s3,s33,s4,s44,s5,s55,s6,s66,s7,s77,s8,s88,s9,s99, s10,df.format(date_obj));

        if (inserted) {
            Toast.makeText(this, "Entry inserted", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,FirstEntry.class));
        }
        else
            Toast.makeText(this,"Entry not inserted",Toast.LENGTH_LONG).show();
    }
    public void addButton(View view)
    {

        if(view.getId() == R.id.bAddShower)
        {
            numForShower++;
            TextView showerNumber = findViewById(R.id.showNum);
            TextView runningTotal = findViewById(R.id.t1);
            runTotalShower = 3 + runTotalShower;

            showerNumber.setText(Integer.toString(numForShower)); // updating the incremental TextView between the Shower Buttons
            runningTotal.setText(Integer.toString(runTotalShower) + " l"); // updating the running total for shower
            Total = Math.round((Total + 3) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddToilet)
        {
            numForToilet++;
            TextView toiletNumber = findViewById(R.id.showNum2);
            TextView runningTotal = findViewById(R.id.t2);
            runTotalToilet = runTotalToilet + 4.5;

            toiletNumber.setText(Integer.toString(numForToilet));
            runningTotal.setText(Double.toString(runTotalToilet) + " l");
            Total = Math.round((Total + 4.5) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddHygiene)
        {
            numForHygiene++;
            TextView hygieneNumber = findViewById(R.id.showNum3);
            TextView runningTotal = findViewById(R.id.t3);
            runTotalHygiene = Math.round((0.3 + runTotalHygiene) * 10) / 10.0;

            hygieneNumber.setText(Integer.toString(numForHygiene));
            runningTotal.setText(Double.toString(runTotalHygiene) + " l");
            Total = Math.round((Total + 0.3) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddLaundry)
        {
            numForLaundry++;
            TextView laundryNumber = findViewById(R.id.showNum4);
            TextView runningTotal = findViewById(R.id.t4);
            runTotalLaundry = 9 + runTotalLaundry;

            laundryNumber.setText(Integer.toString(numForLaundry));
            runningTotal.setText(Integer.toString(runTotalLaundry) + " l");
            Total = Math.round((Total + 9) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddDish)
        {
            numForDish++;
            TextView dishNumber = findViewById(R.id.showNum5);
            TextView runningTotal = findViewById(R.id.t5);
            runTotalDish = 3.5 + runTotalDish;

            dishNumber.setText(Integer.toString(numForDish));
            runningTotal.setText(Double.toString(runTotalDish) + " l");
            Total = Math.round((Total + 3.5) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddDrink)
        {
            numForDrink++;
            TextView drinkNumber = findViewById(R.id.showNum6);
            TextView runningTotal = findViewById(R.id.t6);
            runTotalDrink = 3 + runTotalDrink;

            drinkNumber.setText(Integer.toString(numForDrink));
            runningTotal.setText(Integer.toString(runTotalDrink) + " l");
            Total = Math.round((Total + 3) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddCook)
        {
            numForCook++;
            TextView cookNumber = findViewById(R.id.showNum7);
            TextView runningTotal = findViewById(R.id.t7);
            runTotalCook = 2 + runTotalCook;

            cookNumber.setText(Integer.toString(numForCook));
            runningTotal.setText(Integer.toString(runTotalCook) + " l");
            Total = Math.round((Total + 2) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddClean)
        {
            numForClean++;
            TextView cleanNumber = findViewById(R.id.showNum8);
            TextView runningTotal = findViewById(R.id.t8);
            runTotalClean = 8 + runTotalClean;

            cleanNumber.setText(Integer.toString(numForClean));
            runningTotal.setText(Integer.toString(runTotalClean) + " l");
            Total = Math.round((Total + 8) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
        else if(view.getId() == R.id.bAddOther)
        {
            numForOther++;
            TextView otherNumber = findViewById(R.id.showNum9);
            TextView runningTotal = findViewById(R.id.t9);
            runTotalOther = 0.5 + runTotalOther;

            otherNumber.setText(Integer.toString(numForOther));
            runningTotal.setText(Double.toString(runTotalOther) + " l");
            Total = Math.round((Total + 0.5) * 10.0) / 10.0;
            finalEdit.setText(String.valueOf(Total) + " l");
        }
    }
    public void minusButton(View view) {
        if (numForShower != 0) {
            if (view.getId() == R.id.bMinusShower) {
                numForShower--;
                runTotalShower = runTotalShower - 3;
                TextView showerNumber = findViewById(R.id.showNum);
                showerNumber.setText(Integer.toString(numForShower));

                runningTotal = findViewById(R.id.t1);
                runningTotal.setText(Integer.toString(runTotalShower) + " l");
                Total = Math.round((Total - 3) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");

            }
        }
        if (numForToilet != 0) {
            if (view.getId() == R.id.bMinusTiolet) {
                numForToilet--;
                runTotalToilet = runTotalToilet - 4.5;
                TextView toiletNumber = findViewById(R.id.showNum2);
                TextView runningTotal = findViewById(R.id.t2);

                toiletNumber.setText(Integer.toString(numForToilet));
                runningTotal.setText(Double.toString(runTotalToilet) + " l");
                Total = Math.round((Total - 4.5) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForHygiene != 0)
        {
            if (view.getId() == R.id.bMinusHygiene)
            {
                numForHygiene--;
                runTotalHygiene = Double.parseDouble(object.format(runTotalHygiene - 0.3));
                TextView hygieneNumber = findViewById(R.id.showNum3);
                TextView runningTotal = findViewById(R.id.t3);

                hygieneNumber.setText(Integer.toString(numForHygiene));
                runningTotal.setText(Double.toString(runTotalHygiene) + " l");
                Total = Math.round((Total - 0.3) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForLaundry != 0)
        {
            if (view.getId() == R.id.bMinusLaundry)
            {
                numForLaundry--;
                runTotalLaundry = runTotalLaundry - 9;
                TextView laundryNumber = findViewById(R.id.showNum4);
                TextView runningTotal = findViewById(R.id.t4);

                laundryNumber.setText(Integer.toString(numForLaundry));
                runningTotal.setText(Integer.toString(runTotalLaundry) + " l");
                Total = Math.round((Total - 9) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForDish != 0)
        {
            if (view.getId() == R.id.bMinusDish)
            {
                numForDish--;
                runTotalDish = runTotalDish - 3.5;
                TextView DishNumber = findViewById(R.id.showNum5);
                TextView runningTotal = findViewById(R.id.t5);

                DishNumber.setText(Integer.toString(numForDish));
                runningTotal.setText(Double.toString(runTotalDish) + " l");
                Total = Math.round((Total - 3.5) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForDrink != 0)
        {
            if (view.getId() == R.id.bMinusDrink)
            {
                numForDrink--;
                runTotalDrink = runTotalDrink - 3;
                TextView DrinkNumber = findViewById(R.id.showNum6);
                TextView runningTotal = findViewById(R.id.t6);

                DrinkNumber.setText(Integer.toString(numForDrink));
                runningTotal.setText(Integer.toString(runTotalDrink) + " l");
                Total = Math.round((Total - 3) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForCook != 0)
        {
            if (view.getId() == R.id.bMinusCook)
            {
                numForCook--;
                runTotalCook = runTotalCook - 2;
                TextView cookNumber = findViewById(R.id.showNum7);
                TextView runningTotal = findViewById(R.id.t7);

                cookNumber.setText(Integer.toString(numForCook));
                runningTotal.setText(Integer.toString(runTotalCook) + " l");
                Total = Math.round((Total - 2) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForClean != 0)
        {
            if (view.getId() == R.id.bMinusClean)
            {
                numForClean--;
                runTotalClean = runTotalClean - 8;
                TextView cleanNumber = findViewById(R.id.showNum8);
                TextView runningTotal = findViewById(R.id.t8);

                cleanNumber.setText(Integer.toString(numForClean));
                runningTotal.setText(Integer.toString(runTotalClean) + " l");
                Total = Math.round((Total - 8) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
        if (numForOther != 0)
        {
            if (view.getId() == R.id.bMinusOther)
            {
                numForOther--;
                runTotalOther = runTotalOther - 0.5;
                TextView otherNumber = findViewById(R.id.showNum9);
                TextView runningTotal = findViewById(R.id.t9);

                otherNumber.setText(Integer.toString(numForOther));
                runningTotal.setText(Double.toString(runTotalOther) + " l");
                Total = Math.round((Total - 0.5) * 10.0) / 10.0;
                finalEdit.setText(String.valueOf(Total) + " l");
            }
        }
    }
}
