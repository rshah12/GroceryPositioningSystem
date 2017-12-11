package edu.rshah12.grocerypositioningsystem;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MapActivity extends CheckBoxActivity {

    ScrollView sv = null;
    LinearLayout ll = null;
    SQLiteDatabase db;
    Bitmap map = null;
    ImageView mapImage = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapPoint BooksCards = new mapPoint(980, 272);
        mapPoint Condiments = new mapPoint(980, 272);
        mapPoint International = new mapPoint(980, 272);
        mapPoint Baking = new mapPoint(980, 272);
        mapPoint Beverages = new mapPoint(980, 272);
        mapPoint TeaCoffee = new mapPoint(980, 272);
        mapPoint PersonalCare = new mapPoint(980, 272);
        mapPoint Snacks = new mapPoint(980, 272);
        mapPoint Cleaning = new mapPoint(980, 272);
        mapPoint Household = new mapPoint(980, 272);
        mapPoint Produce = new mapPoint(980, 272);
        mapPoint Bakery = new mapPoint(980, 272);
        mapPoint Deli = new mapPoint(980, 272);
        mapPoint Dairy = new mapPoint(980, 272);
        mapPoint PackagedMeats = new mapPoint(980, 272);
        mapPoint Alcohol = new mapPoint(980, 272);
        mapPoint Frozen = new mapPoint(980, 272);
        mapPoint Canned = new mapPoint(980, 272);
        mapPoint Breads = new mapPoint(980, 272);
        mapPoint Flowers = new mapPoint(980, 272);
        mapPoint Pizza = new mapPoint(980, 272);

        mapImage = (ImageView)  findViewById(R.drawable.floorplan);

        map = ((BitmapDrawable)mapImage.getDrawable()).getBitmap();
        int testPixel = map.getPixel(980, 272);
        map.setPixel(980, 272, Color.RED);

        String[] data = getIntent().getExtras().getStringArray("dbData");

        sv = (ScrollView) findViewById(R.id.sv);
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        for (int i = 0; i < data.length; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText(data[i]);
            ll.addView(cb);
        }


    }
}
