package com.example.kkk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kkk.Adapter.CommentCourseAdapter;
import com.example.kkk.Adapter.SearchResultAdapter;
import com.example.kkk.model.Course;
import com.example.kkk.model.SearchResult;
import com.example.kkk.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class CommentCourseActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv;
    private CommentCourseAdapter adapter;
    private List<Course> items;

    private String searchItem;
    private int id;

    private ImageView iv_back;
    private TextView tv_search_item;

    private void initAllId () {
        lv = findViewById(R.id.lv_comment_course);
        iv_back = findViewById(R.id.iv_back);
        tv_search_item = findViewById(R.id.tv_search_item);
    }

    private void initSearchResult () {

        items = new ArrayList<>();

        System.out.println("id=" + id);
        System.out.println("searchItem=" + searchItem);

        switch (id) {
            case 0:
                items.add(new Course(
                                "无查询结果",
                                "",
                                "",
                                0,
                                0));
                break;
            case 1:
                items.add(new Course(
                                "线性代数B",
                                "计算机学院",
                                "A老师",
                                4.2,
                                4.3));
                items.add(new Course(
                                "线性代数B",
                                "计算机学院",
                                "B老师",
                                3.8,
                                3.5));
                break;
            case 2:
                items.add(new Course(
                                "线性代数B",
                                "计算机学院",
                                "A老师",
                                4.2,
                                4.3));
                items.add(new Course(
                                "数学分析B1",
                                "计算机学院",
                                "A老师",
                                4.2,
                                4.6));
                items.add(new Course(
                                "数学分析B1",
                                "计算机学院",
                                "A老师",
                                4.2,
                                4.8));
                break;
            default:
                break;
        }

        // 单元格布局
        adapter = new CommentCourseAdapter(this, items);
        // 将适配器指定给ListView对象
        lv.setAdapter(adapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_course);

        // 拿到搜索项目
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        searchItem = intent.getStringExtra("searchItem");

        initAllId();
        initSearchResult();

        tv_search_item.setText(searchItem);

        // 按钮点击事件绑定
        // 返回图标返回上一个页面
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("click_lv");
                Intent intent = new Intent(); // 意图
                // 从哪里跳到哪里
                intent.setClass(CommentCourseActivity.this, CommentActivity.class);
                intent.putExtra("course", (Course) adapter.getItem(position));
                // 执行跳转
                startActivity(intent);
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