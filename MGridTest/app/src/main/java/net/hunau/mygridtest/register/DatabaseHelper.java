package net.hunau.mygridtest.register;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //定义本地用户数据库的名称和版本
    static String name = "User_hb.db";
    //static final String db_table = "user_hb";
    static int dbVersion = 3;

    public final String KEY_USERNAME = "用户名";
    public final String KEY_PASSWORD = "密码";
    public final String KEY_NAME = "真实姓名";
    public final String KEY_IDENTIFICATION = "身份";

//    private SQLiteDatabase db;
//    private  Context context;
//    private DatabaseHelper dbOpenHelper;

    public DatabaseHelper(Context context){
        super(context, name, null, dbVersion);
    }

//    /** Open the database */
//    public void open() throws SQLiteException {
//        try {
//            db = dbOpenHelper.getWritableDatabase();
//        }
//        catch (SQLiteException ex) {
//            db = dbOpenHelper.getReadableDatabase();
//        }
//    }
//
    // 只在创建的时候用一次
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),name varchar(10),identification varchar(10))";
        db.execSQL(sql);
    }
//
//
//    public User[] queryAllData(){
//        Cursor results = db.query(db_table,new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_NAME,KEY_IDENTIFICATION},null,null,null,null,null);
//        return ConvertToUser(results);
//    }
//
//    public User[] queryOneData(String username) {
//        Cursor results =  db.query(db_table, new String[] { KEY_USERNAME, KEY_PASSWORD, KEY_NAME, KEY_IDENTIFICATION},
//                KEY_USERNAME + "=" + username,null, null, null, null);
//        return ConvertToUser(results);
//    }
//
//    private User[] ConvertToUser(Cursor cursor){
//        int resultCounts = cursor.getCount();
//        if (resultCounts == 0 || !cursor.moveToFirst()){
//            return null;
//        }
//        User[] user = new User[resultCounts];
//        for (int i = 0 ; i<resultCounts; i++){
//            user[i] = new User();
//            user[i].setUsername(cursor.getString(cursor.getColumnIndex(KEY_USERNAME)));// = cursor.getString(cursor.getColumnIndex(KEY_STUID));
//            user[i].setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));// = cursor.getString(cursor.getColumnIndex(KEY_NAME));
//            user[i].setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));// = cursor.getString(cursor.getColumnIndex(KEY_PASS));
//            user[i].setIdentification(cursor.getString(cursor.getColumnIndex(KEY_IDENTIFICATION)));// = cursor.getString(cursor.getColumnIndex(KEY_SEX));
//
//            cursor.moveToNext();
//        }
//        return user;
//    }
//
//    public long deleteOneData(String username) {
//        return db.delete(db_table,  KEY_USERNAME + "=" + username, null);
//    }

//    public long updateOneData(String username , User user){
//        ContentValues updateValues = new ContentValues();
//        updateValues.put(KEY_USERNAME, user.getUsername());
//        updateValues.put(KEY_PASSWORD, user.getPassword());
//        updateValues.put(KEY_NAME, user.getName());
//        updateValues.put(KEY_IDENTIFICATION, user.getIdentification());
//
//        return db.update(db_table, updateValues,  KEY_USERNAME + "=" + username, null);
//    }

    // 升级用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
