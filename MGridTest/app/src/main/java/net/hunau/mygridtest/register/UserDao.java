package net.hunau.mygridtest.register;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 用户注册数据表，注册时读取用户对象信息存入数据表中，登陆时按用户名和密码检索表中的数据进行鉴权
 *
 */
public class UserDao {

    private DatabaseHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // 登录时按输入的username,password查询user数据表的数据进行鉴权（是否为合法用户）
    public boolean login(String username, String password) {
        // 以读写方式打开数据库，做查询数据表中的username,password字段的所有元组
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        // 使用游标 (Cursors) 来导航浏览查询结果
        Cursor cursor = sdb.rawQuery(sql, new String[] { username, password});
        // 如果游标指向第一行，则返回 true
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    // 注册用户输入的信息存入user数据表
    public boolean register(User user) {
        // 以读写方式打开数据库，按照表定义插入数据
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into user(username,password,name,identification) values(?,?,?,?)";
        Object obj[] = { user.getUsername(), user.getPassword(), user.getName(), user.getIdentification()};
        sdb.execSQL(sql, obj);
        return true;
    }

    // 进入系统后按用户名搜索数据库的信息并输出
    public String[] readDisplay(String username) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=?;";
        Cursor cursor = sdb.rawQuery(sql, new String[] { username });
        cursor.moveToFirst();
        String baseInfo[] = { cursor.getString(1), cursor.getString(2)};
        return baseInfo;
    }
}
