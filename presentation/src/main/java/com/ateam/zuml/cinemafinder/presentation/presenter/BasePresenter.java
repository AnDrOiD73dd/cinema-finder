package com.ateam.zuml.cinemafinder.presentation.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    protected String getStringFromArrayGenres(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (arr.length == 1 || i == (arr.length - 1)) {
                break;
            }
            sb.append(", ");
        }

        return sb.toString();
    }
}
