package com.example.ourmeetingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.lang.ref.Reference;

public class DataBase extends SQLiteOpenHelper {
    private Context context;
    private static final String DataBase_name ="OurMeetingApp.db";
    private static final int Version=1;
    private static final String  Table_name1 = "dependency";
    private static final String PlaceID = "PlaceID";
    private static final String NamePlace = "NamePlace";
    private static final String  Description = "Description";
    private static final String  Table_name2 = "agent ";
    private static final String PersonID = "PersonID";
    private static final String PersonName = "PersonName";
    private static final String  Description1 = "Description1";
    private static final String  Table_name3 = "Date";
    private static final String AppointmentID = "AppointementID";
    private static final String Appointment = "Appointment";

    public DataBase(@Nullable Context context) {
        super(context, DataBase_name, null, Version);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_name1 +
                "(" + PlaceID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NamePlace + " TEXT, " +
                Description + " TEXT );";
        db.execSQL(query);

        String query1 = "CREATE TABLE " + Table_name2 +
                "(" + PersonID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PersonName + " TEXT, " +
                Description1 + " TEXT );";
        db.execSQL(query1);

        String query2 = "CREATE TABLE " + Table_name3 +
                "(" + AppointmentID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Appointment + " DATE ," + PlaceID + " INTEGER," + PersonID + " INTEGER ,"+
                "FOREIGN KEY (" + PlaceID + ") REFERENCES " + Table_name2 + "(" + PlaceID + "),"+
                "FOREIGN KEY (" + PersonID + ") REFERENCES " + Table_name1 + "(" + PersonID + "));";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name1);
        db.execSQL("DROP TABLE IF EXISTS " + Table_name2);
        db.execSQL("DROP TABLE IF EXISTS " + Table_name3);
        onCreate(db);

    }
}
