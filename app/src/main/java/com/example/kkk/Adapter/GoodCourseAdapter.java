package com.example.kkk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kkk.R;
import com.example.kkk.model.Course;

import java.util.List;
import java.util.Map;

public class GoodCourseAdapter extends BaseAdapter {

    private List<Course> courses;

    public GoodCourseAdapter(Context context, List<Course> courses) {
        this.courses = courses;
        this.context = context;
    }

    private Context context;

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.good_course_list_view, null);
        }

        // 绑定控件id
        TextView tv_course_name = convertView.findViewById(R.id.tv_course_name);
        TextView tv_course_category = convertView.findViewById(R.id.tv_course_category);
        TextView tv_teacher_name = convertView.findViewById(R.id.tv_teacher_name);
//        TextView tv_teacher_score = convertView.findViewById(R.id.tv_teacher_score);
        TextView tv_course_score = convertView.findViewById(R.id.tv_course_score);

        // 获取指定record
        Course course = courses.get(position);
        tv_course_name.setText(course.getCourseName());
        tv_course_category.setText(course.getCourseCategory());
        tv_teacher_name.setText(course.getTeacherName());
//        tv_teacher_score.setText(String.valueOf(course.getTeacherScore()));
        tv_course_score.setText(String.valueOf(course.getChorseScore()));

        return convertView;
    }
}
