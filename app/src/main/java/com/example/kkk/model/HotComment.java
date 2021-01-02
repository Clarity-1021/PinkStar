package com.example.kkk.model;

import android.graphics.Bitmap;

import com.example.kkk.R;

public class HotComment {

    private int icon;
    private String comment;
    private String tag1;
    private String tag2;
    private String tag3;
//    private int goodCnt;
//    private int badCnt;
    private double score;

    public final static int tag1_icon = R.mipmap.ic_dog1;
    public final static int tag2_icon = R.mipmap.ic_dog2;
    public final static int tag3_icon = R.mipmap.ic_dog3;
    public final static int tag4_icon = R.mipmap.ic_dog4;
    public final static int tag5_icon = R.mipmap.ic_dog5;
    public final static int tag6_icon = R.mipmap.ic_dog6;

    public final static int score0_icon = R.drawable.ic_score_0_checked;
    public final static int score1_icon = R.drawable.ic_score_1_checked;
    public final static int score2_icon = R.drawable.ic_score_2_checked;
    public final static int score3_icon = R.drawable.ic_score_3_checked;
    public final static int score4_icon = R.drawable.ic_score_4_checked;

    public HotComment(int icon, String comment, String tag1, String tag2, String tag3, double score) {
        this.icon = icon;
        this.comment = comment;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getScoreIcon () {
        if (this.score >= 5.0) {
            return score4_icon;
        }
        else if (this.score >= 4.0) {
            return score3_icon;
        }
        else if (this.score >= 3.0) {
            return score2_icon;
        }
        else if (this.score >= 2.0) {
            return score1_icon;
        }
        return score0_icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
}
