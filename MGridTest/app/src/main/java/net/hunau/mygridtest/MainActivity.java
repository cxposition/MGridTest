package net.hunau.mygridtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.hunau.mygridtest.register.RegisterActivity;
import net.hunau.mygridtest.register.User;
import net.hunau.mygridtest.register.UserDao;

public class MainActivity extends AppCompatActivity {

    private Button bt_login;
    private Button bt_clear;
    static EditText et_username;
    static EditText et_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);
        bt_clear = findViewById(R.id.bt_clear);

        //ck_rememberpassword = findViewById(R.id.remember_password);
        //output();
        bt_login.setOnClickListener(button);
        bt_clear.setOnClickListener(button);
    }

    Button.OnClickListener button = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.bt_login:
//                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                    Bundle bundle = new Bundle();   //两个Activity通讯可以通过Bundle类来实现
//                        String username = et_username.getText().toString().trim();
//                        String password = et_password.getText().toString().trim();
//
//                        if(username.isEmpty()||password.isEmpty()) {
//                            Toast.makeText(MainActivity.this, "用户名或密码不可为空！", Toast.LENGTH_SHORT).show();
//                        }else{
//                            bundle.putString("username", username);
//                            bundle.putString("password", password);
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        }
                    login();
                    return;
                case R.id.bt_clear:
                    //清空用户名与密码
                    et_username.setText("");
                    et_password.setText("");
                    return;
            }
        }
    };

    private void login() {

        //获取用户输入的邮箱，密码做校验
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();

        UserDao uService = new UserDao(MainActivity.this);
        // 登陆成功失败的标记
        boolean flag = uService.login(username, password);


        //判断是否输入了账号
        if(TextUtils.isEmpty(username)){
            Toast.makeText(MainActivity.this, R.string.username_empty,Toast.LENGTH_SHORT).show();
            return;
        }

//        //通过正则表达式(需参考其他课程)判断邮箱格式是否正确
//        if(!RegexUtil.isEmail(username)){
//            Toast.makeText(this, R.string.email_error, Toast.LENGTH_SHORT).show();
//            return;
//        }

        //判断是否输入了密码
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.password_empty, Toast.LENGTH_SHORT).show();
            return;
        }

//        //判断密码长度是否为6~15位
////        if(password.length()<6||password.length()>15){
////            Toast.makeText(this, R.string.password_length_error, Toast.LENGTH_SHORT).show();
////            return;
////        }

        //在这里调用服务端登录接口
        //这里就简单实现，将密码和用户名写到本地
        if(flag){

            User user = new User();




            //登陆成功，进入首页
            //Toast.makeText(this, R.string.loading, Toast.LENGTH_SHORT).show();

            //登录完成后保存一个标记，下次不用再登录了
            //sp.setLogin(true);
            //input();
            Bundle bundle = new Bundle();

            Intent intent = new Intent(this,ResultActivity.class);
            bundle.putString("username", username);
            bundle.putString("password", password);
            intent.putExtras(bundle);
            startActivity(intent);




            //关闭当前页面
            finish();
        }else{
            //登录失败，进行提示
            Toast.makeText(this, R.string.username_or_password_error, Toast.LENGTH_SHORT).show();

        }
    }

//    private void output() {
////第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
//        SharedPreferences shared = getSharedPreferences("mypsd", MODE_PRIVATE);
//        //第一个参数就是关键字，第二个参数为默认值，意思是说如果没找到值就用默认值代替
//        String name1 = shared.getString("name", "");//同上，若没找到就让它为空""
//        String psd1 = shared.getString("psd", "");
//        boolean ischecked1 = shared.getBoolean("isChecked", false);
//        et_username.setText(name1);
//        et_password.setText(psd1);
//        ck_rememberpassword.setChecked(ischecked1);
//    }
//    /**
//     * 存
//     */
//    private void input() {
////第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
//        SharedPreferences.Editor edit = getSharedPreferences("mypsd", MODE_PRIVATE).edit();
//        //判断选择框的状态   被选中isChecked或……
//        if (ck_rememberpassword.isChecked()) {
//            edit.putString("name", et_username.getText().toString());
//            edit.putString("psd", et_password.getText().toString());
//            edit.putBoolean("isChecked", true);
//        } else {
////            edit.clear();              //若选择全部清除就保留这行代码，注释以下三行
//            edit.putString("name", et_username.getText().toString());//只存用户名
//            edit.putString("psd", "");
//            edit.putBoolean("isChecked", false);
//        }
//        edit.commit();
//    }
//
//}

    public void OnRegisterClick(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
