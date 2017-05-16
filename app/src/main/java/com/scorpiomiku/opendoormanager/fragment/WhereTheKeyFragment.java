package com.scorpiomiku.opendoormanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scorpiomiku.opendoormanager.R;
import com.scorpiomiku.opendoormanager.bean.People;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */

public class WhereTheKeyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private static final String DIALOG_BUTTON = "ButtonDialog";

    public static WhereTheKeyFragment newInstance() {
        return new WhereTheKeyFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.where_the_key_fragment, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.people_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        upUi();
        return v;
    }

    /*-------------------------------------------------Holder-------------------------------*/
    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private TextView mNumberTextView;
        private TextView mInformationTextView;
        private People mPeople;


        public ItemHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.people_list_image);
            mNumberTextView = (TextView) itemView.findViewById(R.id.people_list_number_item);
            mInformationTextView = (TextView) itemView.findViewById(R.id.people_list_text_view);
        }

        private void bindView(People p) {
            mPeople = p;
            mNumberTextView.setText(p.getRank() + "");
            mInformationTextView.setText("电话号码:" + p.getCallNumber() + '\n' + "QQ号码："
                    + p.getQQNumber());
            mInformationTextView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            WhereTheKeyListDialogFragment dialogFragment = WhereTheKeyListDialogFragment.newInstance(mPeople);
            dialogFragment.show(fm, DIALOG_BUTTON);
        }
    }

    /*-------------------------------------------------Adapter--------------------------------*/
    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<People> mPeopleList;

        public ItemAdapter(List<People> p) {
            mPeopleList = p;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.people_list_item_recycler_view, parent
                    , false);
            return new ItemHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            People p = mPeopleList.get(position);
            p.setRank(position);
            holder.bindView(p);
        }

        @Override
        public int getItemCount() {
            return mPeopleList.size();
        }
    }

    /*--------------------------------------------------------upUI--------------------------------*/
    private void upUi() {
        mRecyclerView.setAdapter(new ItemAdapter(People.createPeopleListTest()));
    }
}
