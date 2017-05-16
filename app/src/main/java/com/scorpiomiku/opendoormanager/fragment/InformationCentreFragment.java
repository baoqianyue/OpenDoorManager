package com.scorpiomiku.opendoormanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.scorpiomiku.opendoormanager.bean.KeyExchangeRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */

public class InformationCentreFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private String DIALOGPHOTO;


    public static InformationCentreFragment newInstance() {
        return new InformationCentreFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.information_centre_fragment, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.information_key_exchange_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mImageView = (ImageView) v.findViewById(R.id.informantion_image_view);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                PhotoShowFragment fragment = PhotoShowFragment.newInstance("");
                fragment.show(fm,DIALOGPHOTO);
            }
        });
        bindView();
        return v;
    }


    /*----------------------------------------------Holder--------------------------------------*/
    private class InformationItemHolder extends RecyclerView.ViewHolder {
        private TextView mMessageTextView;
        private TextView mTimeTextView;

        public InformationItemHolder(View itemView) {
            super(itemView);
            mMessageTextView = (TextView) itemView.findViewById(R.id.information_item_message);
            mTimeTextView = (TextView) itemView.findViewById(R.id.information_item_time);
        }

        private void bindItem(KeyExchangeRecord mKER) {
            mMessageTextView.setText(mKER.getMessage());
            mTimeTextView.setText(mKER.getTime());
        }
    }

    /*---------------------------------------------Adapter---------------------------------------*/
    private class InformationItemAdapter extends RecyclerView.Adapter<InformationItemHolder> {

        private List<KeyExchangeRecord> mKeyExchangeRecordList;

        public InformationItemAdapter(List<KeyExchangeRecord> list) {
            mKeyExchangeRecordList = list;
        }

        @Override
        public InformationItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.key_exchange_record_item, parent, false);
            return new InformationItemHolder(v);
        }

        @Override
        public void onBindViewHolder(InformationItemHolder holder, int position) {
            KeyExchangeRecord k = mKeyExchangeRecordList.get(position);
            holder.bindItem(k);
        }

        @Override
        public int getItemCount() {
            return mKeyExchangeRecordList.size();
        }
    }

    /*--------------------------------------------------------bindView---------------------------*/
    private void bindView() {
        mRecyclerView.setAdapter(new InformationItemAdapter(KeyExchangeRecord.createTestList()));
    }

}
