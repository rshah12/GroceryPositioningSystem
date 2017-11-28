package edu.rshah12.grocerypositioningsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ScrollView sv;
    LinearLayout ll;
    SQLiteDatabase db = null;
    EditText item;
    Spinner category;
    CheckBox cb;

    //test
    // test again

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = (EditText) findViewById(R.id.item);
        category = (Spinner) findViewById(R.id.spinner);


        db = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE List (Item TEXT, Category TEXT)");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        sv = new ScrollView(this);
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        cb = new CheckBox(this);
    }

    public void makeGroceryList (View v) {
        String groceryItem = item.getText().toString();
        String categoryItem = category.getSelectedItem().toString();
        db.execSQL("INSERT INTO List VALUES ('" + groceryItem + "', '" + categoryItem + "')");
        cb.setText(groceryItem);
        ll.addView(cb);
    }
}
