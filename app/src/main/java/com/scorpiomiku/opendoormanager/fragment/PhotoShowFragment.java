package com.scorpiomiku.opendoormanager.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.scorpiomiku.opendoormanager.R;

/**
 * Created by Administrator on 2017/5/16.
 */

public class PhotoShowFragment extends AppCompatDialogFragment {
    private String mPhotoPath;
    private ImageView mImageView;
    private Bitmap mBitmap;

    public static PhotoShowFragment newInstance(String mPath) {
        PhotoShowFragment f = new PhotoShowFragment();
        BitmapFactory.Options options = new BitmapFactory.Options();
        return f;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View v = layoutInflater.inflate(R.layout.photo_show_fragment, null);
        mImageView = (ImageView) v.findViewById(R.id.photo_show_dialog_image_view);
        Drawable placeHolder = getResources().getDrawable(R.mipmap.information_image, getActivity().getTheme());


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
