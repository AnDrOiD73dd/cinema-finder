package com.ateam.zuml.cinemafinder.ui;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.enums.RowCollection;
import com.ateam.zuml.cinemafinder.presentation.presenter.RowPresenter;
import com.ateam.zuml.cinemafinder.presentation.view.RowCollectionView;
import com.ateam.zuml.cinemafinder.util.image.ImageLoader;

import javax.inject.Inject;

public class RowFragment extends MvpAppCompatFragment implements RowCollectionView {

    private final static String COLLECTION_TAG = "CollectionType";

    private RowAdapter adapter;

    @BindView(R.id.cl_row_collection) ConstraintLayout rootView;
    @BindView(R.id.pb_search_response) ProgressBar progressBarView;
    @BindView(R.id.rv_row_collection) RecyclerView recyclerView;
    @BindView(R.id.tv_no_search_results) TextView noSearchResultsView;
    @BindView(R.id.tv_collection_name) TextView collectionName;

    @Inject ImageLoader<ImageView> imageLoader;

    @InjectPresenter RowPresenter presenter;

    @ProvidePresenter
    RowPresenter provideRowPresenter() {
        RowPresenter presenter = new RowPresenter((RowCollection) getArguments().getSerializable(COLLECTION_TAG));
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static RowFragment newInstance(RowCollection collection) {
        RowFragment fragment = new RowFragment();
        Bundle args = new Bundle();
        args.putSerializable(COLLECTION_TAG, collection);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_row, container, false);
        init(view);
        return view;
    }

    private void init(View v) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, v);

        adapter = new RowAdapter(presenter.getListPresenter(), imageLoader);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        if (getArguments().getSerializable(COLLECTION_TAG) == RowCollection.POPULAR) {
            collectionName.setText(R.string.category_title_popular);
        }
    }

    @Override
    public void showError() {
        Snackbar.make(rootView, R.string.search_response_error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBarView.setVisibility(View.GONE);
    }

    @Override
    public void updateCollectionRow() {
        adapter.refreshView();
    }

    @Override
    public void showNoInCollection() {
        noSearchResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoInCollection() {
        noSearchResultsView.setVisibility(View.GONE);
    }
}
