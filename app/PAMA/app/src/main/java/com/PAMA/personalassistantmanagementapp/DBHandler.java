package com.PAMA.personalassistantmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.PAMA.personalassistantmanagementapp.Model.User;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // Creating a constant variables for our database.
    // Below variable is for our database name.
    private static final String DB_NAME = "userDB";

    // Below int is our database version
    private static final int DB_VERSION = 1;

    // Below variable is for our table name.
    private static final String TABLE_NAME = "userTable";

    // Below variable is for our id column.
    private static final String ID_COL = "ID";
    private static final String EMAIL_COL = "email";
    private static final String FIRSTNAME_COL = "firstName";
    private static final String LASTNAME_COL = "lastName";
    private static final String GENDER_COL = "gender";
    private static final String ADDRESS_COL = "Address";
    private static final String COUNTRY_COL = "Country";
    private static final String IDPASSPORT_COL = "ID_Passport";
    private static final String DOB_COL = "DateOfBirth";
    private static final String PHONENUMBER_COL = "PhoneNumber";
    private static final String PASSWORD_COL = "Password";
    private static final String REPASSWORD_COL = "Re-Pass";


    // Creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // On below line we are creating an sqlite query and we are setting our column names along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + FIRSTNAME_COL + " TEXT,"
                + LASTNAME_COL + " TEXT,"
                + GENDER_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + COUNTRY_COL + " TEXT,"
                + IDPASSPORT_COL + " TEXT,"
                + DOB_COL + " TEXT,"
                + PHONENUMBER_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + REPASSWORD_COL + " TEXT)";
        // At last we are calling a exec sql method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to "ADD NEW USER" to our sqlite database.
    public void addNewUser(String email, String firstName, String lastName, String gender, String address,
                             String country, String IDPassport, String DOB, String phoneNumber, String pass,
                             String rePass) {

        // On below line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // On below line we are creating a variable for content values.
        ContentValues values = new ContentValues();

        // On below line we are passing all values along with its key and value pair.
        values.put(EMAIL_COL, email);
        values.put(FIRSTNAME_COL, firstName);
        values.put(LASTNAME_COL, lastName);
        values.put(GENDER_COL, gender);
        values.put(ADDRESS_COL, address);
        values.put(COUNTRY_COL, country);
        values.put(IDPASSPORT_COL, IDPassport);
        values.put(DOB_COL, DOB);
        values.put(PHONENUMBER_COL, phoneNumber);
        values.put(PASSWORD_COL, pass);
        values.put(REPASSWORD_COL, rePass);

        // After adding all values we are passing  content values to our table.
        db.insert(TABLE_NAME, null, values);

        // At last we are closing our database after adding database.
        db.close();
    }

    // We have created a new method for reading all the courses.
    public ArrayList<User> readUser() {
        // On below line we are creating a database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorUser = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // On below line we are creating a new array list.
        ArrayList<User> userArrayList = new ArrayList<>();

        // Moving our cursor to first position.
        if (cursorUser.moveToFirst()) {
            do {
                // On below line we are adding the data from cursor to our array list.
                userArrayList.add(new User(cursorUser.getString(1), cursorUser.getString(2),
                        cursorUser.getString(3), cursorUser.getString(4),
                        cursorUser.getString(5), cursorUser.getString(6),
                        cursorUser.getString(7), cursorUser.getString(8),
                        cursorUser.getString(9), cursorUser.getString(10), cursorUser.getString(11)));
            } while (cursorUser.moveToNext());
            // Moving our cursor to next.
        }
        // At last closing our cursor and returning our array list.
        cursorUser.close();
        return userArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
