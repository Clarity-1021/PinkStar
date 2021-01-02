package com.example.kkk.Fragment;

import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import com.example.kkk.Adapter.SearchResultAdapter;
import com.example.kkk.CommentCourseActivity;
import com.example.kkk.CourseDetailActivity;
        import com.example.kkk.HomeActivity;
        import com.example.kkk.LoginActivity;
        import com.example.kkk.R;
        import com.example.kkk.SearchResultActivity;
        import com.example.kkk.model.Course;
        import com.example.kkk.model.SearchResult;

        import java.util.Objects;

public class CommentFragment extends Fragment implements View.OnClickListener {

    private EditText et_course_name;
    private EditText et_teacher_name;

    private Button btn_search_course_name;
    private Button btn_search_teacher_name;

    private void initAllId (View v) {

        et_course_name = v.findViewById(R.id.et_course_name);
        et_teacher_name = v.findViewById(R.id.et_teacher_name);

        btn_search_course_name = v.findViewById(R.id.btn_search_course_name);
        btn_search_teacher_name = v.findViewById(R.id.btn_search_teacher_name);
    }

    private void initEvent () {

        btn_search_course_name.setOnClickListener(this);
        btn_search_teacher_name.setOnClickListener(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);

        initAllId(view);
        initEvent();

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = 0;
        switch (v.getId()) {
            case R.id.btn_search_course_name:
                if (et_course_name.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "请输入查询内容", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (et_course_name.getText().toString().equals("线性代数B")) {
                    id = 1;
                }
                goToSearchResult(id, et_course_name.getText().toString());
                break;
            case R.id.btn_search_teacher_name:
                if (et_teacher_name.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "请输入查询内容", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (et_teacher_name.getText().toString().equals("A老师")) {
                    id = 2;
                }
                goToSearchResult(id, et_teacher_name.getText().toString());
                break;
            default:
                break;
        }
    }

    public void goToSearchResult (int id, String searchItem) {
        Intent intent = new Intent(); // 意图
        // 从哪里跳到哪里
        intent.setClass(Objects.requireNonNull(getActivity()), CommentCourseActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("searchItem", searchItem);
        // 执行跳转
        startActivity(intent);
    }
}
