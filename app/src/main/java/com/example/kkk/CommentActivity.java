package com.example.kkk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kkk.Adapter.HotCommentAdapter;
import com.example.kkk.model.Course;
import com.example.kkk.model.HotComment;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_back;
    TextView tv_course_name;
    TextView tv_teacher_name;

    Button btn_submit_course;
    Button btn_submit_teacher;

    private void initAllId () {

        iv_back = findViewById(R.id.iv_back);
        tv_course_name = findViewById(R.id.tv_course_name);
        tv_teacher_name = findViewById(R.id.tv_teacher_name);

        btn_submit_course = findViewById(R.id.btn_submit_course);
        btn_submit_teacher = findViewById(R.id.btn_submit_teacher);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        // 拿到课程
        Intent intent = getIntent();
        Course course = (Course) intent.getSerializableExtra("course");

        initAllId();

        tv_course_name.setText(course.getCourseName());
        tv_teacher_name.setText(course.getTeacherName());


        // 按钮点击事件绑定
        // 返回图标返回上一个页面
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_submit_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CommentActivity.this, "成功提交课程评价", Toast.LENGTH_SHORT).show();
            }
        });

        btn_submit_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CommentActivity.this, "成功提交教师评价", Toast.LENGTH_SHORT).show();
            }
        });


        ImageView iv_nag_home = findViewById(R.id.iv_nag_home);
        ImageView iv_nag_search = findViewById(R.id.iv_nag_search);
        ImageView iv_nag_comment = findViewById(R.id.iv_nag_comment);
        ImageView iv_nag_my = findViewById(R.id.iv_nag_my);

        iv_nag_home.setOnClickListener(this);
        iv_nag_search.setOnClickListener(this);
        iv_nag_comment.setOnClickListener(this);
        iv_nag_my.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = -1;

        switch (v.getId()) {
            case R.id.iv_nag_home:
                id = 0;
                break;
            case R.id.iv_nag_search:
                id = 1;
                break;
            case R.id.iv_nag_comment:
                id = 2;
                break;
            case R.id.iv_nag_my:
                id = 3;
                break;
            default:
                break;
        }

        if (id != -1) {
            Intent intent = new Intent(); // 意图
            // 从哪里跳到哪里
            intent.setClass(this, HomeActivity.class);
            intent.putExtra("id", id);
            // 执行跳转
            startActivity(intent);
        }
    }
}