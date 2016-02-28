package com.camino.rxdagger.presentation.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.camino.data.model.BeatClip;
import com.camino.rxdagger.presentation.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rxdroid on 2/28/16.
 */
public class BeatClipHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.item_beatclip_image) ImageView mBeatClipImage;

    private Context mContext;

    public BeatClipHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;
    }

    public void bind(BeatClip beatClip) {
        Glide.with(mContext)
                .load(beatClip.getPreviewUrl())
                .into(mBeatClipImage);
    }
}
