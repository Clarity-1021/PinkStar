package com.example.kkk.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.kkk.Adapter.GoodCourseAdapter;
import com.example.kkk.CourseDetailActivity;
import com.example.kkk.HomeActivity;
import com.example.kkk.R;
import com.example.kkk.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private ListView lv_good_courses;
    private GoodCourseAdapter adapter;
    private List<Course> courses;

    private static int k = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lv_good_courses = view.findViewById(R.id.lv_good_courses);

        // BaseAdapter 更加复杂的版本
        courses = new ArrayList<>();
        courses.add(new Course(
                "线性代数",
                "计算机学院",
                "A老师",
                4.9,
                4.5
        ));

        courses.add(new Course(
                "数学分析B1",
                "计算机学院",
                "B老师",
                4.8,
                4.6
        ));

        courses.add(new Course(
                "数学分析B2",
                "计算机学院",
                "B老师",
                4.8,
                5.0
        ));

        courses.add(new Course(
                "数据结构与算法分析",
                "软件学院",
                "C老师",
                4.7,
                4.2
        ));

        courses.add(new Course(
                "数据库设计",
                "软件学院",
                "D老师",
                4.6,
                3.8
        ));

        // 单元格布局
        adapter = new GoodCourseAdapter(getActivity(), courses);
        // 将适配器指定给ListView对象
        lv_good_courses.setAdapter(adapter);

        lv_good_courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(); // 意图
                // 从哪里跳到哪里
                intent.setClass(Objects.requireNonNull(getActivity()), CourseDetailActivity.class);
                intent.putExtra("course", (Course) adapter.getItem(position));
                // 执行跳转
                startActivity(intent);
            }
        });

        lv_good_courses.setOnScrollListener(new AbsListView.OnScrollListener() {

            private boolean isLastRow = false;

            /*
             * scrollState值：
             * 当屏幕停止滚动时为SCROLL_STATE_IDLE = 0；
             * 当屏幕滚动且用户使用的触碰或手指还在屏幕上时为SCROLL_STATE_TOUCH_SCROLL = 1；
             * 由于用户的操作，屏幕产生惯性滑动时为SCROLL_STATE_FLING = 2
             */
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                // 判断滑动是否停止
                if(scrollState == SCROLL_STATE_IDLE) {
                    // 当滑动停止的时候是否已经到达了底部
                    if (isLastRow) {
                        isLastRow = false;
                        // 执行加载更多的操作
                        if (k == 1) {
                            k++;
                            courses.add(new Course(
                                    "程序设计A",
                                    "计算机学院",
                                    "E老师",
                                    4.2,
                                    4.1
                            ));

                            courses.add(new Course(
                                    "大学物理B1",
                                    "电光源学院",
                                    "F老师",
                                    4.2,
                                    3.9
                            ));

                            courses.add(new Course(
                                    "大学物理B2",
                                    "电光源学院",
                                    "F老师",
                                    4.2,
                                    4.1
                            ));

                            courses.add(new Course(
                                    "荷马史诗1",
                                    "历史学院",
                                    "G老师",
                                    4.2,
                                    4.1
                            ));

                            courses.add(new Course(
                                    "荷马史诗2",
                                    "历史学院",
                                    "G老师",
                                    4.2,
                                    4.3
                            ));
                            adapter.notifyDataSetChanged();
                        }

                    }
                }
            }

            /*
             * firstVisibleItem:表示在现时屏幕第一个ListItem(部分显示的ListItem也算)在整个ListView的位置(下标从0开始)
             * visibleItemCount:表示在现时屏幕可以见到的ListItem(部分显示的ListItem也算)总数
             * totalItemCount:表示ListView的ListItem总数
             * listView.getFirstVisiblePosition()表示在现时屏幕第一个ListItem(第一个ListItem部分显示也算)在整个ListView的位置(下标从0开始)
             * listView.getLastVisiblePosition()表示在现时屏幕最后一个ListItem(最后ListItem要完全显示出来才算)在整个ListView的位置(下标从0开始)
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

//                if ((visibleItemCount > 0) && (firstVisibleItem == 0)) {
//                    if (view.getChildAt(0).getTop() >= 0) {
//                        // 当listview 滑动到顶部时 在这做处理
//                    }
//                }
//                // 判断是否到达listview的底部
//                if ((totalItemCount > 0) && (view.getLastVisiblePosition() == totalItemCount - 1)) {
//                    if (view.getBottom() == view.getChildAt(
//                            view.getChildCount() - 1).getBottom()) {
//                        // 到了listview 底部的时候将isLastRow 设置为true
//                        isLastRow = true;
//                    }
//
//                }

                if(totalItemCount!=0 && firstVisibleItem+visibleItemCount==totalItemCount){
                    //说明到底了
                    isLastRow=true;
                }else{
                    //没有到底
                    isLastRow=false;
                }
            }
        });


        return view;
    }
}
