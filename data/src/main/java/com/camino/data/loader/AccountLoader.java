package com.camino.data.loader;

import com.camino.data.api.AccountApiService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by robert on 25.02.16.
 */
public class AccountLoader extends ApiLoader {

    private final AccountApiService mAccountApiService;

    @Inject
    public AccountLoader(Retrofit retrofit) {
        mAccountApiService = retrofit.create(AccountApiService.class);
    }

    public Observable getLatestUsersObservable() {
        return mAccountApiService.getLatestUsers("");
    }

}
