package com.example.kkk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kkk.Adapter.GoodCourseAdapter;
import com.example.kkk.Fragment.CommentFragment;
import com.example.kkk.Fragment.HomeFragment;
import com.example.kkk.Fragment.MyFragment;
import com.example.kkk.Fragment.SearchFragment;
import com.example.kkk.model.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment homePage = new HomeFragment();
    private Fragment searchPage = new SearchFragment();
    private Fragment commentPage = new CommentFragment();
    private Fragment myPage = new MyFragment();

    private FragmentManager fm;

    private ImageView iv_nag_home;
    private ImageView iv_nag_search;
    private ImageView iv_nag_comment;
    private ImageView iv_nag_my;

    private LinearLayout tab_nag_home;
    private LinearLayout tab_nag_search;
    private LinearLayout tab_nag_comment;
    private LinearLayout tab_nag_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        int jumpTo = intent.getIntExtra("id", 0);

        initialView();
        initialFragment();
        initialEvent();

        selectFragment(jumpTo);

    }

    private void initialView () {

        iv_nag_home = findViewById(R.id.iv_nag_home);
        iv_nag_search = findViewById(R.id.iv_nag_search);
        iv_nag_comment = findViewById(R.id.iv_nag_comment);
        iv_nag_my = findViewById(R.id.iv_nag_my);

    }

    private void initialFragment () {

        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.tab_content, homePage);
        transaction.add(R.id.tab_content, searchPage);
        transaction.add(R.id.tab_content, commentPage);
        transaction.add(R.id.tab_content, myPage);
        transaction.commit();

    }

    private void initialEvent () {

        iv_nag_home.setOnClickListener(this);
        iv_nag_search.setOnClickListener(this);
        iv_nag_comment.setOnClickListener(this);
        iv_nag_my.setOnClickListener(this);

    }

    private void hideFragment (FragmentTransaction transaction) {

        transaction.hide(homePage);
        transaction.hide(searchPage);
        transaction.hide(commentPage);
        transaction.hide(myPage);

    }

    private void selectFragment (int i) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i) {
            case 0:
                transaction.show(homePage);
                break;
            case 1:
                transaction.show(searchPage);
                break;
            case 2:
                transaction.show(commentPage);
                break;
            case 3:
                transaction.show(myPage);
                break;
            default:
                break;
        }

        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_nag_home:
                selectFragment(0);
                break;
            case R.id.iv_nag_search:
                selectFragment(1);
                break;
            case R.id.iv_nag_comment:
                selectFragment(2);
                break;
            case R.id.iv_nag_my:
                selectFragment(3);
                break;
            default:
                break;
        }
    }
}