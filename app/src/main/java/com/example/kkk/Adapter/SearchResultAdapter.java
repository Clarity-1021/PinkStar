package com.example.kkk.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kkk.R;
import com.example.kkk.model.HotComment;
import com.example.kkk.model.SearchResult;

import java.util.List;

public class SearchResultAdapter extends BaseAdapter {

    private List<SearchResult> searchResults;

    public SearchResultAdapter(Context context, List<SearchResult> searchResults) {
        this.searchResults = searchResults;
        System.out.println("searchSize=" + searchResults.size());
        this.context = context;
    }

    private Context context;

    @Override
    public int getCount() {
        return searchResults.size();
    }

    @Override
    public Object getItem(int position) {
        return searchResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.search_result_list_view, null);
        }

        // 绑定控件id
        TextView tv_course_name = convertView.findViewById(R.id.tv_course_name);
        TextView tv_teacher_name = convertView.findViewById(R.id.tv_teacher_name);

        // 获取指定record
        SearchResult searchResult = searchResults.get(position);
        tv_course_name.setText(searchResult.getCourse().getCourseName());
        tv_teacher_name.setText(searchResult.getTeacher().getTeacherName());

        return convertView;
    }
}
