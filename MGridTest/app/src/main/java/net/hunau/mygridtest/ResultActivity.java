package net.hunau.mygridtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView display = findViewById(R.id.display);
        Button bt_return = findViewById(R.id.bt_return);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        display.setText(String.format("接收的用户名是：%s\t\t密码是：%s.\n",bundle.getString("username"),bundle.getString("password")));

        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.et_username.setText("");
                MainActivity.et_password.setText("");
                finish();
            }
        });
    }
}
