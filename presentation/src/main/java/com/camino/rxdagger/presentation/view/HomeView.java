package com.camino.rxdagger.presentation.view;

import com.camino.data.model.BeatClip;

import java.util.List;

/**
 * Created by robert on 26.02.16.
 */
public interface HomeView extends LoadDataView {
    void showResult(List<BeatClip> beatClipList);
}
