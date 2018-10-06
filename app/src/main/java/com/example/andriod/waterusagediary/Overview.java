package com.example.andriod.waterusagediary;

/* When the user launches the application this activity is invoked
 *
 * Author: Songeziwe S. Soboois
 * Date: 12/09/2018
 */

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Overview extends AppCompatActivity {

    private static final String TAB = "overview2";
    public DatabaseHelper db;
    Item item;
    ArrayList<Item> itemList;

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        db = new DatabaseHelper(this);
        itemList = new ArrayList<>();
        Cursor pointer = db.getData();
        pointer.moveToFirst();
        long rows = db.numRows();

        Log.d( TAB, "Started");

        mListView = findViewById(R.id.listView);

        // adding a listener to the list of diary entries such that when one of them is clicked
        // the user is directed to the entries page.
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if( view != null)
                {
                    Intent intent = new Intent( Overview.this, FirstEntry.class);
                    TextView v = findViewById(R.id.textView62);
                    String message = v.getText().toString();
                    intent.putExtra("TIME_STAMP", message);

                    startActivity(intent);
                }

            }
        });

        // creating objects of type Item
        double averageWater = 0;

        for (long i = 0; i < rows;i++)
        {
            item = new Item(pointer.getString(20),pointer.getString(19));
            averageWater += Double.parseDouble(item.getAmount().substring(0,item.getAmount().length() - 2));
            itemList.add(item);
            pointer.moveToNext();
        }
        averageWater /= db.numRows();
        ItemListAdapter adapter = new ItemListAdapter( this, R.layout.adapter_view_layout, itemList );
        averageWater = Math.round(averageWater * 10.0) / 10.0;
        mListView.setAdapter( adapter );

        final TextView tv = findViewById(R.id.textView31);
        String stringVersion = Double.toString(averageWater);
        tv.setText(stringVersion);

    }

    // open the calculator activity when button clicked
    public void openCalculator(View view)
    {
        System.out.println(item.getAmount().substring(0,item.getAmount().length() - 2));
        startActivity( new Intent( this, Calculator.class) );
    }
}
