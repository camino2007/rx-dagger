package com.camino.rxdagger.presentation.view;

import com.camino.data.model.User;

import java.util.List;

/**
 * Created by robert on 25.02.16.
 */
public interface MainView extends LoadDataView {

    void showResult(List<User> userList);
}
