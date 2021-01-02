package com.example.kkk.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kkk.R;
import com.example.kkk.model.Course;
import com.example.kkk.model.HotComment;

import java.util.List;

public class HotCommentAdapter extends BaseAdapter {

    private List<HotComment> hotComments;

    public HotCommentAdapter(Context context, List<HotComment> hotComments) {
        this.hotComments = hotComments;
        this.context = context;
    }

    private Context context;

    @Override
    public int getCount() {
        return hotComments.size();
    }

    @Override
    public Object getItem(int position) {
        return hotComments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hot_comment_list_view, null);
        }

        // 绑定控件id
        ImageView ic_dog = convertView.findViewById(R.id.ic_dog);
        ImageView iv_score_icon = convertView.findViewById(R.id.iv_score_icon);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);
        TextView tv_comment_score = convertView.findViewById(R.id.tv_comment_score);
        TextView tv_tag1 = convertView.findViewById(R.id.tv_tag1);
        TextView tv_tag2 = convertView.findViewById(R.id.tv_tag2);
        TextView tv_tag3 = convertView.findViewById(R.id.tv_tag3);

        // 获取指定record
        HotComment hotComment = hotComments.get(position);
        ic_dog.setImageResource(hotComment.getIcon());
        tv_comment.setText(hotComment.getComment());
        tv_tag1.setText(hotComment.getTag1());
        tv_tag2.setText(hotComment.getTag2());
        tv_tag3.setText(hotComment.getTag3());
        iv_score_icon.setImageResource(hotComment.getScoreIcon());
        tv_comment_score.setText(hotComment.getScore() + "");

        return convertView;
    }
}
