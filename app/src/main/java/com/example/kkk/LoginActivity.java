package com.example.kkk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kkk.helper.MySQLiteOpenHelper;
import com.example.kkk.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    // 保存密码
    private SharedPreferences sp;

    // 数据库
    private SQLiteDatabase db;

    public static List<User> list = new ArrayList<>();

    private EditText et_account;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences("account_save", MODE_PRIVATE);

        // 打开数据库
//        MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(this);
        db = new MySQLiteOpenHelper(this).getWritableDatabase();

        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);

        // 按钮点击事件绑定
        // 登录按钮跳转主页
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (et_account.getText().toString().trim().length() == 0) {
                Toast.makeText(LoginActivity.this, "请输入账号/学号邮箱", Toast.LENGTH_SHORT).show();
            }
            else if (!isExistByAccountAndEmail(et_account.getText().toString().trim())) {
                Toast.makeText(LoginActivity.this, "该账户不存在，请重新输入账号/学号邮箱", Toast.LENGTH_SHORT).show();
            }
            else if (et_password.getText().toString().length() == 0) {
                Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            }
            else if (!isCorrectByPassword(et_account.getText().toString().trim(), et_password.getText().toString())) {
                Toast.makeText(LoginActivity.this, "密码输入错误，请重新输入", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(); // 意图
                // 从哪里跳到哪里
                intent.setClass(LoginActivity.this, HomeActivity.class);
                // 执行跳转
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "成功登陆粉色星球", Toast.LENGTH_SHORT).show();
            }
            }
        });

        // 注册按钮跳转注册
        Button btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(); // 意图
            // 从哪里跳到哪里
            intent.setClass(LoginActivity.this, RegisterActivity.class);
            // 执行跳转
            startActivity(intent);
            }
        });

        // QQ跳转主页
        ImageView iv_qq = findViewById(R.id.iv_qq);
        iv_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(); // 意图
            // 从哪里跳到哪里
            intent.setClass(LoginActivity.this, HomeActivity.class);
            // 执行跳转
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "成功通过QQ登陆粉色星球", Toast.LENGTH_SHORT).show();
            }
        });

        // 微信跳转主页
        ImageView iv_wc = findViewById(R.id.iv_wc);
        iv_wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(); // 意图
            // 从哪里跳到哪里
            intent.setClass(LoginActivity.this, HomeActivity.class);
            // 执行跳转
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "成功通过微信登陆粉色星球", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 检查密码是否正确
     * @param account 账号或者学号邮箱
     * @param password 密码
     * @return 密码是否正确
     */
    public boolean isCorrectByPassword (String account, String password) {

        boolean result = false;

        Cursor cursor = db.query("user",
                null,
                "email=? OR account=?",
                new String[]{account, account},
                null,
                null,
                null,
                null
        );

        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            String pass = cursor.getString(cursor.getColumnIndex("password"));
            result = pass.equals(password);
        }

        cursor.close();

        return result;

//        for (User user : LoginActivity.list) {
//            if (user.getEmail().equals(account) || user.getAccount().equals(account)) {
//                return user.getPassword().equals(password);
//            }
//        }
//        return false;
    }

    /**
     * 检查账号或者学邮的账户是否存在
     * @param account 账号或者学邮
     * @return 账户是否存在
     */
    public boolean isExistByAccountAndEmail (String account) {

        boolean result;

        Cursor cursor = db.query("user",
                null,
                "email=? OR account=?",
                new String[]{account, account},
                null,
                null,
                null,
                null
                );

        result = (cursor.getCount() != 0);

        cursor.close();

        return result;


//        for (User user : LoginActivity.list) {
//            if (user.getEmail().equals(account) || user.getAccount().equals(account)) {
//                return true;
//            }
//        }
//        return false;
    }


}