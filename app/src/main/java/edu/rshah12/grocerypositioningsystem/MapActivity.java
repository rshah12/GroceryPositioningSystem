package edu.rshah12.grocerypositioningsystem;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapActivity extends CheckBoxActivity {

    ScrollView sv = null;
    LinearLayout ll = null;
    SQLiteDatabase db;
    Bitmap map = null;
    Bitmap og;
    Drawable mapImage = null;
    Map coordMap = new HashMap<String, mapPoint>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//        mapPoint BooksCards = new mapPoint(980, 272);
//        coordMap.put("Books & Cards", BooksCards);
//        mapPoint Condiments = new mapPoint(980, 272);
//        coordMap.put("Condiments", Condiments);
//        mapPoint International = new mapPoint(980, 272);
//        coordMap.put("International", International);
//        mapPoint Baking = new mapPoint(980, 272);
//        coordMap.put("Baking Goods", Baking);
//        mapPoint Beverages = new mapPoint(980, 272);
//        coordMap.put("Juice & Water", Beverages);
//        mapPoint TeaCoffee = new mapPoint(980, 272);
//        coordMap.put("Tea & Coffee", TeaCoffee);
//        mapPoint PersonalCare = new mapPoint(980, 272);
//        coordMap.put("Personal Care", PersonalCare);
//        mapPoint Snacks = new mapPoint(980, 272);
//        coordMap.put("Snacks", Snacks);
//        mapPoint Cleaning = new mapPoint(980, 272);
//        coordMap.put("Cleaning Items", Cleaning);
//        mapPoint Household = new mapPoint(980, 272);
//        coordMap.put("Household Items", Household);
//        mapPoint Produce = new mapPoint(980, 272);
//        coordMap.put("Produce", Produce);
//        mapPoint Bakery = new mapPoint(980, 272);
//        coordMap.put("Bakery", Bakery);
//        mapPoint Deli = new mapPoint(980, 272);
//        coordMap.put("Deli", Deli);
//        mapPoint Dairy = new mapPoint(980, 272);
//        coordMap.put("Dairy", Dairy);
//        mapPoint PackagedMeats = new mapPoint(980, 272);
//        coordMap.put("Packaged Meats", PackagedMeats);
//        mapPoint Alcohol = new mapPoint(980, 272);
//        coordMap.put("Alcohol", Alcohol);
//        mapPoint Frozen = new mapPoint(980, 272);
//        coordMap.put("Frozen Foods", Frozen);
//        mapPoint Canned = new mapPoint(980, 272);
//        coordMap.put("Canned Goods", Canned);
//        mapPoint Breads = new mapPoint(980, 272);
//        coordMap.put("Breads", Breads);
//        mapPoint Flowers = new mapPoint(980, 272);
//        coordMap.put("Flowers", Flowers);
//        mapPoint Pizza = new mapPoint(980, 272);
//        coordMap.put("Pizza", Pizza);

        new Thread(new Runnable() {
            @Override
            public void run() {
                og = BitmapFactory.decodeResource(getResources(),R.drawable.floorplan);
                map = og.copy(Bitmap.Config.ARGB_8888, true);
                int test = map.getPixel(980, 272);
                int width = map.getWidth();
                int height = map.getHeight();
                Log.v("PixelTag", "width: " + Integer.toString(width) + "height: " + Integer.toString(height));
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        map.setPixel(i, j, Color.RED);
                    }
                }
            }
        }).start();



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
