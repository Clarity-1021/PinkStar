package com.example.kkk;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kkk.helper.MySQLiteOpenHelper;
import com.example.kkk.model.User;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    // 数据库
    private SQLiteDatabase db;

    private EditText et_account;
    private EditText et_email;
    private EditText et_check_code;
    private EditText et_password;
    private EditText et_password_check;

    // 复旦学邮pattern
    public final static String EMAIL_PATTERN = "^[0-9]{11}@fudan.edu.cn$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 打开数据库
//        MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(this);
        db = new MySQLiteOpenHelper(this).getWritableDatabase();

        et_account = findViewById(R.id.et_account);
        et_email = findViewById(R.id.et_email);
        et_check_code = findViewById(R.id.et_check_code);
        et_password = findViewById(R.id.et_password);
        et_password_check = findViewById(R.id.et_password_check);

        // 按钮点击事件绑定
        // 注册按钮跳转注册
        Button btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_account.getText().toString().trim().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                }
                else if (et_account.getText().toString().trim().length() > 18) {
                    Toast.makeText(RegisterActivity.this, "账号长度不能超过18位", Toast.LENGTH_SHORT).show();
                }
                else if (isExistByAccount(et_account.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "该账号已被占用，请重新输入", Toast.LENGTH_SHORT).show();
                }
                else if (et_email.getText().toString().trim().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请输入学号邮箱", Toast.LENGTH_SHORT).show();
                }
                else if (isExistByEmail(et_email.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "该学号邮箱已被注册，请重新输入", Toast.LENGTH_SHORT).show();
                }
                else if (!Pattern.matches(EMAIL_PATTERN, et_email.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "请正确输入孵蛋大学的学号邮箱", Toast.LENGTH_SHORT).show();
                }
                else if (et_check_code.getText().toString().trim().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }
                else if (et_password.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }
                else if (et_password.getText().toString().length() < 6) {
                    Toast.makeText(RegisterActivity.this, "密码长度至少为6位", Toast.LENGTH_SHORT).show();
                }
                else if (et_password.getText().toString().length() > 18) {
                    Toast.makeText(RegisterActivity.this, "密码长度不能超过18位", Toast.LENGTH_SHORT).show();
                }
                else if (et_password_check.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                }
                else if (!et_password.getText().toString().equals(et_password_check.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "输入的密码与第一次不一致，请重新输入", Toast.LENGTH_SHORT).show();
                }
                else {
                    // 创建用户
                    User user = new User(et_account.getText().toString().trim(),
                            et_email.getText().toString().trim(),
                            et_password_check.getText().toString());

                    // 把用户插入用户表
                    if (insertUser(user.getAccount(), user.getEmail(), user.getPassword())) {
                        //                    LoginActivity.list.add(user);
                        // 跳转登录页面
                        Intent intent = new Intent(); // 意图
                        // 从哪里跳到哪里
                        intent.setClass(RegisterActivity.this, LoginActivity.class);
                        // 执行跳转
                        startActivity(intent);
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "注册失败，请重试", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // 按钮点击事件绑定
        // 返回图标返回上一个页面
        ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 发送验证码
        Button btn_check_code = findViewById(R.id.btn_check_code);
        btn_check_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 根据账号查找是否已经存在该账户
     * @param account 账号
     * @return 是否存在账户
     */
    public boolean isExistByAccount (String account) {

        boolean result;

        Cursor cursor = db.query("user",
                null,
                "account=?",
                new String[]{account},
                null,
                null,
                null,
                null
        );

        result = (cursor.getCount() != 0);

        cursor.close();

        return result;

//        for (User user : LoginActivity.list) {
//            if (user.getAccount().equals(account)) {
//                return true;
//            }
//        }
//        return false;
    }

    public boolean insertUser (String account, String email, String password) {

        ContentValues values = new ContentValues();
        values.put("account", account);
        values.put("email", email);
        values.put("password", password);

        return (db.insert("user", null, values) != 0);
    }

    /**
     * 根据学邮查找是否已经存在该账户
     * @param email 学邮
     * @return 是否存在账户
     */
    public boolean isExistByEmail (String email) {

        boolean result;

        Cursor cursor = db.query("user",
                null,
                "email=?",
                new String[]{email},
                null,
                null,
                null,
                null
        );

        result = (cursor.getCount() != 0);

        cursor.close();

        return result;

//        for (User user : LoginActivity.list) {
//            if (user.getEmail().equals(email)) {
//                return true;
//            }
//        }
//        return false;
    }
}