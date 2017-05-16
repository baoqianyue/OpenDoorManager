package com.scorpiomiku.opendoormanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.scorpiomiku.opendoormanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class DoorOpenFragment extends Fragment {
    private String TAG = "DoorOpenFragment";

    private RecyclerView mRecyclerView;

    public static DoorOpenFragment newInstance() {
        return new DoorOpenFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.door_open_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.door_open_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        ItemUpData();
        return view;
    }


    /*----------------------------------------------ItemUp----------------------------*/
    private void ItemUpData() {
        List<String> list = new ArrayList<>();

        String s[] = new String[35];
        s[0] = "王琳";
        s[1] = "金浩";
        s[2] = " ";
        s[3] = "王天锐";
        s[4] = " ";
        s[5] = "许景贤";
        s[6] = "王莹莹";

        s[7] = "朱溯蓉";
        s[8] = "陈静怡";
        s[9] = " ";
        s[10] = "靳璐";
        s[11] = "贺乾真";
        s[12] = "陈茹";
        s[13] = "陈静怡";

        s[14] = "鲍骞月";
        s[15] = "冯志勇";
        s[16] = " ";
        s[17] = "许景贤";
        s[18] = "王琳";
        s[19] = "王宇飞";
        s[20] = "冯志勇";

        s[21] = "李宏辉";
        s[22] = "王天锐";
        s[23] = "鲍骞月 ";
        s[24] = "朱原东";
        s[25] = "王莹莹";
        s[26] = "朱原东";
        s[27] = "刘洋";

        s[28] = "刘洋";
        s[29] = "王宇飞";
        s[30] = "谭卓";
        s[31] = "金浩";
        s[32] = "谭卓";
        s[33] = "朱溯蓉";
        s[34] = "陈茹";
        for (int i = 0; i < 35; i++) {
            list.add(s[i]);
        }
        mRecyclerView.setAdapter(new ItemAdapter(list));
    }

    /*--------------------------------------------------holder--------------------------------*/
    private class ItemHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ItemHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_door_open_text_view);
        }

        private void bindItem(String s) {
            mTextView.setText(s);
        }
    }

    /*--------------------------------Adapter----------------------------------------*/
    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

        List<String> mStringList;

        public ItemAdapter(List<String> list) {
            mStringList = list;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.item_door_open_recycler_view, parent, false);
            return new ItemHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            String str = mStringList.get(position);
            holder.bindItem(str);
        }

        @Override
        public int getItemCount() {
            return mStringList.size();
        }
    }
}
