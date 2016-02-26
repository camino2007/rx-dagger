package com.camino.data.loader;

import com.camino.data.api.BeatClipApiService;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by robert on 26.02.16.
 */
public class BeatClipLoader extends ApiLoader {

    private final BeatClipApiService mBeatClipApiService;


    public BeatClipLoader(Retrofit retrofit) {
        mBeatClipApiService = retrofit.create(BeatClipApiService.class);
    }

    public Observable getLatestBeatClipsObservable() {
        return mBeatClipApiService.getLatestBeatclips("");
    }
}
