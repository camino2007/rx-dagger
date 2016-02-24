package com.camino.domain;

import android.database.Observable;

import java.util.List;

/**
 * Created by robert on 24.02.16.
 */
public interface AccountRepository {

    Observable<List<User>> getUserList();

    Observable<List<User>> getUserListWithOffset(String offset);

    Observable<User> getSingleUser(String userId);

}
