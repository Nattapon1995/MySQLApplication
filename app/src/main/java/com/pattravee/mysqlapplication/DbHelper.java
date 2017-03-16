package com.pattravee.mysqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 10/2/2560.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "dbtodolist.sqlite";
    private static final int datavaseVesion = 1;
    Context myContext;

    private static final String SQLCreateTable =
            "CREATE TABLE tbtodo_list (" +
                    "taskid INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "taskname TEXT)";

    public  DbHelper(Context context){
        super(context, databaseName, null, datavaseVesion);
        this.myContext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQLCreateTable);
        String insertData1 = "INSERT INTO tbtodo_list (taskname) VALUES ('homework1')";

        db.execSQL(insertData1);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
