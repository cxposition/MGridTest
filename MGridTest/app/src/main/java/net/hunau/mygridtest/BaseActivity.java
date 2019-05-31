package net.hunau.mygridtest;//package com.frcx1079408377;
//
//import androidx.appcompat.app.AppCompatActivity;
//import hunau.net.util.SharedPreferencesUtil;
//
//public class BaseActivity extends AppCompatActivity {
//
//    /**
//     * 访问修饰符改为protected
//     */
//    protected SharedPreferencesUtil sp;
//
//    /**
//     * 重写了setContentView方法
//     * 因为在子类调用了setContentView方法设置布局
//     * @param layoutResID
//     */
//    @Override
//    public void setContentView(int layoutResID) {
//        super.setContentView(layoutResID);
//
//        //配置文件
//        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
//
//        //其他公共逻辑也可以这样重构(如数据库)
//    }
//}
