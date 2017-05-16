package com.scorpiomiku.opendoormanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */

public class KeyExchangeRecord {
    private String mMessage;
    private Date mDate;
    private String mTime;

    //测试
    public static List<KeyExchangeRecord> createTestList() {
        List<KeyExchangeRecord> mList = new ArrayList<>();
        KeyExchangeRecord k = new KeyExchangeRecord();
        k.setMessage("王天锐把钥匙给了鲍骞月");
        k.setTime("5月21日 14：00");
        for (int i = 0; i < 10; i++) {
            mList.add(k);
        }
        return mList;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getMessage() {
        return mMessage;
    }

    public Date getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }
}
