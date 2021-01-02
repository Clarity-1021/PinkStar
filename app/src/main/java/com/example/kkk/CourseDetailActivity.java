package com.example.kkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.kkk.Adapter.GoodCourseAdapter;
import com.example.kkk.Adapter.HotCommentAdapter;
import com.example.kkk.model.Course;
import com.example.kkk.model.HotComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ScrollView sv;
    private ListView lv_courses;
    private ListView lv_teachers;
    private HotCommentAdapter adapter_course;
    private HotCommentAdapter adapter_teacher;
    private List<HotComment> items_course;
    private List<HotComment> items_teacher;

    ImageView iv_back;
    TextView tv_course_name;
    TextView tv_course_category;
    TextView tv_teacher_category;
    TextView tv_teacher_name_course;
    TextView tv_course_score;
    TextView tv_teacher_score;
    TextView tv_teacher_name;

    private void initAllId () {
        sv = findViewById(R.id.sv_good_course);
        lv_courses = findViewById(R.id.lv_hot_comments_course);
        lv_teachers = findViewById(R.id.lv_hot_comments_teacher);

        iv_back = findViewById(R.id.iv_back);
        tv_course_name = findViewById(R.id.tv_course_name);
        tv_course_category = findViewById(R.id.tv_course_category);
        tv_teacher_name_course = findViewById(R.id.tv_teacher_name_course);
        tv_course_score = findViewById(R.id.tv_course_score);
        tv_teacher_score = findViewById(R.id.tv_teacher_score);
        tv_teacher_name = findViewById(R.id.tv_teacher_name);
        tv_teacher_category = findViewById(R.id.tv_teacher_category);
    }

    private void initScroller () {

        sv.smoothScrollTo(0,20);

        iv_back.setFocusable(true);
        iv_back.setFocusableInTouchMode(true);
        iv_back.requestFocus();
    }

    private void initCourse () {

        items_course = new ArrayList<>();
        items_course.add(new HotComment(
                HotComment.tag1_icon,
                "老师上的课很有趣，讲的很好！",
                "讲课很好懂",
                "给分好",
                "有随堂测试",
                5
        ));

        items_course.add(new HotComment(
                HotComment.tag2_icon,
                "希望对于某一部分知识点能有更加清晰的解释。",
                "逻辑清晰",
                "给分好",
                "有随堂测试",
                4
        ));

        items_course.add(new HotComment(
                HotComment.tag3_icon,
                "如果能不拖课就更好啦~",
                "讲课很好懂",
                "给分好",
                "会拖课",
                3
        ));

        // 单元格布局
        adapter_course = new HotCommentAdapter(this, items_course);
        // 将适配器指定给ListView对象
        lv_courses.setAdapter(adapter_course);
    }

    private void initTeacher () {

        items_teacher = new ArrayList<>();
        items_teacher.add(new HotComment(
                HotComment.tag4_icon,
                "学到了很多东西，但是作业量很大。",
                "难",
                "开卷",
                "有很多lab",
                2
        ));

        items_teacher.add(new HotComment(
                HotComment.tag5_icon,
                "学到了很多新知识。",
                "作业多",
                "难",
                "开卷",
                4
        ));

        items_teacher.add(new HotComment(
                HotComment.tag6_icon,
                "很有用的课。",
                "开卷",
                "有很多lab",
                "不拖课",
                3
        ));

        // 单元格布局
        adapter_teacher = new HotCommentAdapter(this, items_teacher);
        // 将适配器指定给ListView对象
        lv_teachers.setAdapter(adapter_teacher);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        // 拿到课程
        Intent intent = getIntent();
        Course course = (Course) intent.getSerializableExtra("course");

        initAllId();
        initCourse();
        initTeacher();
        initScroller();

        tv_course_name.setText(course.getCourseName());
        tv_course_category.setText(course.getCourseCategory());
        tv_teacher_name_course.setText(course.getTeacherName());
        tv_course_score.setText(course.getChorseScore() + " / 5.0");
        tv_teacher_score.setText(course.getTeacherScore() + " / 5.0");
        tv_teacher_name.setText(course.getTeacherName());
        tv_teacher_category.setText(course.getCourseCategory());


        // 按钮点击事件绑定
        // 返回图标返回上一个页面
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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