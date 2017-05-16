package com.scorpiomiku.opendoormanager.bean;

import android.app.PendingIntent;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */

public class People {
    private String mName;
    int mRank;

    public void setRank(int rank) {
        mRank = rank;
    }

    public int getRank() {

        return mRank;
    }

    private Bitmap mImage;
    private String mCallNumber;
    private String mQQNumber;

    public People(String name, Bitmap image, String callNumber, String QQNumber) {
        mName = name;
        mImage = image;
        mCallNumber = callNumber;
        mQQNumber = QQNumber;
    }

    public People(String name, String callNumber, String QQNumber) {
        mName = name;
        mImage = null;
        mCallNumber = callNumber;
        mQQNumber = QQNumber;
    }

    public static List<People> createPeopleListTest() {
        List<People> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People p = new People("王天锐", "18406587433", "1056992492");
            mList.add(p);
        }
        return mList;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setImage(Bitmap image) {
        mImage = image;
    }

    public void setCallNumber(String callNumber) {
        mCallNumber = callNumber;
    }

    public void setQQNumber(String QQNumber) {
        mQQNumber = QQNumber;
    }

    public String getName() {
        return mName;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public String getCallNumber() {
        return mCallNumber;
    }

    public String getQQNumber() {
        return mQQNumber;
    }
}
