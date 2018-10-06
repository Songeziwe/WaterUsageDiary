package com.example.andriod.waterusagediary;

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
    Item shower;
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

        for (long i = 0; i < rows;i++)
        {
            shower = new Item(pointer.getString(20),pointer.getString(19));
            itemList.add(shower);
            pointer.moveToNext();
        }
        ItemListAdapter adapter = new ItemListAdapter( this, R.layout.adapter_view_layout, itemList );
        mListView.setAdapter( adapter );
    }

    // open the calculator activity when button clicked
    public void openCalculator(View view)
    {
        startActivity( new Intent( this, Calculator.class) );
    }
}
