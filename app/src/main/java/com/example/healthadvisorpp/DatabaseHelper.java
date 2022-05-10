package com.example.healthadvisorpp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String dbname = "FoodDatabase.db";
    private static final int dbversion = 1;
    private final Context context;


    public DatabaseHelper(@Nullable Context context) {

        super(context, dbname, null, dbversion);
        this.context = context;

        this.copydbifnotexists();
    }

    private void copydbifnotexists()
    {
        //Ensures that /data/data/YOUR_PACKAGE_NAME/databases/ directory is created
        File dbdir = new File(context.getDatabasePath(dbname).getParentFile().getPath());
        if (dbdir.exists())
            dbdir.mkdir();

        //copy the database
        String dbpath = this.context.getDatabasePath(dbname).getAbsolutePath();
        File dbfile = new File(dbpath);
        if(!dbfile.exists()){
            try {
                InputStream mInput = context.getAssets().open(dbname);
                OutputStream mOutput = new FileOutputStream(dbpath);
                byte[] mBuffer = new byte[1024];
                int mLength;
                while ((mLength = mInput.read(mBuffer, 0, 1024)) > 0)
                    mOutput.write(mBuffer, 0, mLength);
                mOutput.flush();

                mOutput.close();
                mInput.close();
            }
            catch (IOException ex){
                throw new Error("Error copying database: "+ex.getMessage());
            }
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Using exiting database, so this does nothing
    }

    //this is called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //upgrades
    }

    public List<FoodModel> getFood(){

        List<FoodModel> returnList = new ArrayList<>();

        //get data from database
        String queryString = "SELECT * FROM Food";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            // loop through the cursor (result set) and create new customer objects.  Put them into the return list.
            do{
                String Name = cursor.getString(0);
                int Calories = cursor.getInt(1);

                FoodModel newFood = new FoodModel(Name, Calories);
                returnList.add(newFood);
            }while(cursor.moveToNext());
        }
        else{
            //do not add anything to the list
        }
        cursor.close();
        db.close();
        return returnList;
    }
}

