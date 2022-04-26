package Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Foodlist;

public class Database extends SQLiteAssetHelper {

    private static final String DB_Name = "FoodDatabase.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_Name, null,DB_VER);
    }

    //function get all foods
    @SuppressLint("Range")
    public List<Foodlist> getFood()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"Name", "Calories"};
        String tableName = "Food";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Foodlist> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Foodlist foodlist = new Foodlist();
                //here
                foodlist.setFood(cursor.getString(cursor.getColumnIndex("Name")));
                foodlist.setCalories(cursor.getString(cursor.getColumnIndex("Calories")));
                result.add(foodlist);
            }
            while (cursor.moveToNext());
        }
        return result;
    }

    //Function get all food name
    @SuppressLint("Range")
    public List<String> getNames()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"Name"};
        String tableName = "Food";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                //here
                result.add(cursor.getString(cursor.getColumnIndex("Name")));
            }
            while (cursor.moveToNext());
        }
        return result;
    }

    //Function get food by name
    @SuppressLint("Range")
    public List<String> getFoodByName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"Name"};
        String tableName = "Food";

        qb.setTables(tableName);
        //If you want to get extra name, just change
        //Cursor cursor = qb.query(db, sqlSelect, "Name = ?", new String[]{name}, null, null, null);

        //This will like query : Select * from friends where name Like "%Pattern%"
        Cursor cursor = qb.query(db, sqlSelect, "Name Like ?", new String[]{"%" + name + "%"}, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                //here
                result.add(cursor.getString(cursor.getColumnIndex("Name")));
            }
            while (cursor.moveToNext());
        }
        return result;
    }
}
