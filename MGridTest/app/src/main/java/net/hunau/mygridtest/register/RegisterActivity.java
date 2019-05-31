package net.hunau.mygridtest.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import net.hunau.mygridtest.MainActivity;
import net.hunau.mygridtest.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username_register;
    private EditText et_password_register;
    private EditText et_name_register;
    private Button bt_register;
    private RadioGroup rb_group;
    private RadioButton rb;

    public static String username_register;
    public static String password_register;
    public static String name_register;
    public static String identification_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        //注册输入信息
        et_username_register = findViewById(R.id.et_username_register);
        et_password_register = findViewById(R.id.et_password_register);
        et_name_register = findViewById(R.id.et_name_register);
        bt_register = findViewById(R.id.bt_register);
        rb_group = findViewById(R.id.RadioGroup);

        rb_group.setOnCheckedChangeListener(RadioGroupListener);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    RadioGroup.OnCheckedChangeListener RadioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(group.getId()){
                case R.id.RadioGroup:
                    String TAG = "RegisterActivity";
                    rb = RegisterActivity.this.findViewById(rb_group.getCheckedRadioButtonId());
                    identification_register = rb.getText().toString().trim();
                    Log.d(TAG,identification_register);
                    return;
            }
        }
    };


    private void register(){

        username_register = et_username_register.getText().toString().trim();
        password_register = et_password_register.getText().toString().trim();
        name_register = et_name_register.getText().toString().trim();

        rb_group.setOnCheckedChangeListener(RadioGroupListener);


        //判断是否输入了用户名
        if(TextUtils.isEmpty(username_register)){
            Toast.makeText(this, "用户名不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        //判断是否输入了密码
        else if(TextUtils.isEmpty(password_register)){
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断是否输入了姓名
        else if(TextUtils.isEmpty(name_register)){
            Toast.makeText(this, "姓名不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断是否选择了身份
        else if(TextUtils.isEmpty(identification_register)){
            Toast.makeText(this, "身份不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            //填写的信息由用户类收集后统一存入数据库
            User user = new User();
            user.setUsername(username_register);
            user.setPassword(password_register);
            user.setName(name_register);
            user.setIdentification(identification_register);

            // 存入数据库
            UserDao uService = new UserDao(RegisterActivity.this);
            uService.register(user);

            Toast.makeText(this, "注册成功!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
