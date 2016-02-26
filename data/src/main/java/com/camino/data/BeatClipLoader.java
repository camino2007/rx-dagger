package com.camino.data;

import com.camino.data.api.BeatClipApiService;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by robert on 26.02.16.
 */
public class BeatClipLoader extends ApiLoader {

    private final BeatClipApiService mBeatClipApiService;

    protected BeatClipLoader(Retrofit retrofit) {
        super(retrofit);
        mBeatClipApiService = retrofit.create(BeatClipApiService.class);
    }

    @Override
    protected Observable buildObservable() {
        return null;
    }
}
