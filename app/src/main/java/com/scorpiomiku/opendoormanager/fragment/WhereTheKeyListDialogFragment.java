package com.scorpiomiku.opendoormanager.fragment;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.scorpiomiku.opendoormanager.R;
import com.scorpiomiku.opendoormanager.bean.People;

/**
 * Created by Administrator on 2017/5/15.
 */

public class WhereTheKeyListDialogFragment extends AppCompatDialogFragment implements View.OnClickListener {
    private People mPeople;
    private ImageButton mQQImageButton;
    private ImageButton mCallImageButton;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.where_the_key_list_dialog_fragment, null);
        mQQImageButton = (ImageButton) v.findViewById(R.id.button_beifeng_qq);
        mQQImageButton.setOnClickListener(this);
        mCallImageButton = (ImageButton) v.findViewById(R.id.button_beifang_call);
        mCallImageButton.setOnClickListener(this);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }

    public static WhereTheKeyListDialogFragment newInstance(People p) {
        WhereTheKeyListDialogFragment fragment = new WhereTheKeyListDialogFragment();
        fragment.mPeople = p;
        return fragment;
    }

    @Override
    public void onClick(View v) {
        ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData cdQQ = ClipData.newPlainText("", mPeople.getQQNumber());
        ClipData cdCall = ClipData.newPlainText("", mPeople.getCallNumber());
        int ID = v.getId();
        switch (ID) {
            case R.id.button_beifeng_qq:
                cm.setPrimaryClip(cdQQ);
                Toast.makeText(getActivity(), "QQ号已经复制", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_beifang_call:
                cm.setPrimaryClip(cdCall);
                Toast.makeText(getActivity(), "电话号码已经复制", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
