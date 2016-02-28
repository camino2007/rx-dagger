package com.camino.rxdagger.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.di.components.BeatClipCreateComponent;

/**
 * Created by rxdroid on 2/28/16.
 */
public class BeatClipCreateFragment extends BaseFragment {

    public static BeatClipCreateFragment initFragment() {
        return new BeatClipCreateFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(BeatClipCreateComponent.class).inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_create_beatclip;
    }

    @Override
    public String getTagText() {
        return BeatClipCreateFragment.class.getSimpleName();
    }


}
