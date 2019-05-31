package net.hunau.mygridtest;//package com.frcx1079408377;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.frcx1079408377.register.DatabaseHelper;
//import com.frcx1079408377.register.User;
//
//public class AdministratorActivity extends AppCompatActivity {
//
//    private Button bt_query_all;
//    private Button bt_clear;
//    private Button bt_delete;
//    private Button bt_query;
//    private EditText et_username_entry;
//    private TextView tv_display;
//    private DatabaseHelper databaseHelper;
//    private TextView tv_label;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_administrator);
//
//        bt_query_all = findViewById(R.id.query_all);
//        bt_clear = findViewById(R.id.clear);
//        bt_delete = findViewById(R.id.delete);
//        bt_query = findViewById(R.id.query);
//
//        et_username_entry = findViewById(R.id.username_entry);
//
//
//        tv_label = findViewById(R.id.label);
//        tv_display = findViewById(R.id.display);
//
//        databaseHelper = new DatabaseHelper(this);
//        databaseHelper.open();
//
//        bt_query_all.setOnClickListener(button);
//        bt_query.setOnClickListener(button);
//        bt_clear.setOnClickListener(button);
//        bt_delete.setOnClickListener(button);
//
//    }
//
//    Button.OnClickListener button = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            User user = new User();
//            switch(v.getId()){
//                case R.id.query_all:
//                    User[] users = databaseHelper.queryAllData();
//                    if(users == null){
//                        tv_label.setText("数据库中没有数据");
//                        return;
//                    }
//                    tv_label.setText("数据库：");
//                    String msg = "";
//                    for(int i=0;i<users.length;i++){
//                        msg += users[i].toString()+"\n";
//                    }
//                    tv_display.setText(msg);
//                    return;
//
//                case R.id.query:
//                    try{
//
//                        user.setUsername(et_username_entry.getText().toString());
//                        String username= user.getUsername();
//                        if(et_username_entry.getText().toString()!=null){
//                            users = databaseHelper.queryOneData(username);
//
//                            if (users == null){
//                                tv_label.setText("数据库中没有ID为"+String.valueOf(username)+"的数据");
//                                return;
//                            }
//                            tv_label.setText("数据库：");
//                            tv_display.setText(users[0].toString());
//                        }
//                    }catch(NumberFormatException e){
//                        Toast.makeText(AdministratorActivity.this, "输入账号不能为空！", Toast.LENGTH_SHORT).show();
//                        e.printStackTrace();
//                    }
//                    return;
//                case R.id.delete:
//                    try{
//                        String username = et_username_entry.getText().toString();
//                        if (et_username_entry.getText().toString()!=null){
//                            long result = databaseHelper.deleteOneData(username);
//                            msg = "删除账号为"+et_username_entry.getText().toString()+"的数据" + (result>0?"成功":"失败");
//                            tv_label.setText(msg);
//                        }
//
//                    }catch(NumberFormatException e){
//                        Toast.makeText(AdministratorActivity.this, "输入ID不能为空！", Toast.LENGTH_SHORT).show();
//                    }
//                    return;
//                }
//            }
//        };
//    }
//
