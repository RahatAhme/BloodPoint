package com.soft_scatch.rahat.bloodpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "UserDetails.db";
    private static final String USER_TABLE_NAME = "User_Details";
    private static final String ID = "_id";
    private static final String USER_NAME = "UserName";
    private static final String PASSWORD = "Password";

    private static final String DONER_TABLE_NAME = "Doer_Details";
    private static final String DONER_ID = "_DonerId";
    private static final String DONER_NAME = "Doner_Name";
    private static final String MOBILE = "Mobile";
    private static final String GENDER = "Gender";
    private static final String BLOOD = "Blood_Group";
    private static final String DISTRICT = "District";
    private static final String SUB_DISTRICT = "SubDistrict";
    private static final int DB_VERSIONT = 1;

    private Context context;

    private static final String CREATE_User_TABLE = "CREATE TABLE "+ USER_TABLE_NAME +
            " ( "+ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +USER_NAME + " VARCHAR(255), "
            + PASSWORD + " VARCHAR(255)); ";

    private static final String CREATE_Doner_TABLE = "CREATE TABLE "+DONER_TABLE_NAME
            + " ( "+DONER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +DONER_NAME + " VARCHAR(255), "
            + GENDER + " VARCHAR(255), "
            + BLOOD + " VARCHAR(255), "
            + MOBILE+ " VARCHAR(255), "
            + DISTRICT + " VARCHAR(255), "
             + SUB_DISTRICT + " VARCHAR(255)); ";

    private static final String DROP_User_TABLE = "DROP TABLE IF EXISTS "+ USER_TABLE_NAME;
    private static final String DROP_Doner_TABLE = "DROP TABLE IF EXISTS "+ DONER_TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSIONT);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_User_TABLE);
            Toast.makeText(context, "USER Table is created at onCreate", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, CREATE_User_TABLE, Toast.LENGTH_SHORT).show();
        }
        try{
            sqLiteDatabase.execSQL(CREATE_Doner_TABLE);
            Toast.makeText(context, "Doner Table is created at onCreate", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, CREATE_Doner_TABLE, Toast.LENGTH_SHORT).show();
            Log.d("tag",CREATE_Doner_TABLE);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            sqLiteDatabase.execSQL(DROP_User_TABLE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "user table is updated", Toast.LENGTH_SHORT).show();
        }catch (Exception e ){
            Toast.makeText(context, DROP_User_TABLE +"\n" + CREATE_User_TABLE, Toast.LENGTH_SHORT).show();
        }
        try{
            sqLiteDatabase.execSQL(DROP_Doner_TABLE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "donertable is updated", Toast.LENGTH_SHORT).show();
        }catch (Exception e ){
            Toast.makeText(context, DROP_Doner_TABLE +"\n" + CREATE_Doner_TABLE, Toast.LENGTH_SHORT).show();
        }

    }
    public long insert_data(String username,String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put(USER_NAME,username);
        cv.put(PASSWORD,pass);
        long rowNO= sqLiteDatabase.insert(USER_TABLE_NAME,null,cv);
        return  rowNO;
    }
    public long insert_doner_data(String name,String gender,String bGroup,String district,String subDistrict,String mobile){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put(DONER_NAME,name);
        cv.put(GENDER,gender);
        cv.put(BLOOD,bGroup);
        cv.put(DISTRICT,district);
        cv.put(SUB_DISTRICT,subDistrict);
        cv.put(MOBILE,mobile);

        long rowNO= sqLiteDatabase.insert(DONER_TABLE_NAME,null,cv);
        return  rowNO;
    }
public Boolean checking(String username,String password){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ USER_TABLE_NAME ,null);
    Boolean result = false;

        while (cursor.moveToNext()){
        String UserName = cursor.getString(1);
        Toast.makeText(context, UserName+"\n"+username, Toast.LENGTH_SHORT).show();
        String Password = cursor.getString(2);
        Toast.makeText(context, Password+"\n"+password, Toast.LENGTH_SHORT).show();
        if(UserName.equals(username)){
            if(Password.equals(password)){
                result = true;
                break;
            }else {
                Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(context, "Invalid user name", Toast.LENGTH_SHORT).show();
        }
    }
       return result;
}

    public  Boolean Request(String blood,String district,String subdistrict){

    return true;
    }
}
