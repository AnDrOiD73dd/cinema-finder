package com.ateam.zuml.cinemafinder.ui.common.collection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.util.CollectionsRow;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionRowFragment extends MvpAppCompatFragment implements CollectionRowView {

    private final static String COLLECTION_TAG = "CollectionType";

    private CollectionRowAdapter adapter;

    @BindView(R.id.cl_collection_row) ConstraintLayout rootView;
    @BindView(R.id.pb_collection_row) ProgressBar progressBarView;
    @BindView(R.id.rv_collection_row) RecyclerView recyclerView;
    @BindView(R.id.tv_no_search_results) TextView noSearchResultsView;
    @BindView(R.id.tv_collection_row_name) TextView collectionName;

    @Inject ImageLoader imageLoader;

    @InjectPresenter CollectionRowPresenter presenter;

    @ProvidePresenter
    CollectionRowPresenter provideRowPresenter() {
        CollectionRowPresenter presenter = new CollectionRowPresenter(getRowTag());
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static CollectionRowFragment newInstance(CollectionsRow collection) {
        CollectionRowFragment fragment = new CollectionRowFragment();
        Bundle args = new Bundle();
        args.putSerializable(COLLECTION_TAG, collection);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_row, container, false);
        init(view);
        return view;
    }

    private void init(View v) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, v);

        adapter = new CollectionRowAdapter(presenter.getListPresenter(), imageLoader);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        if (getRowTag() == CollectionsRow.POPULAR) {
            collectionName.setText(R.string.category_title_popular);
        }
    }

    private CollectionsRow getRowTag() {
        if (getArguments() != null) {
            return (CollectionsRow) getArguments().getSerializable(COLLECTION_TAG);
        } else {
            return CollectionsRow.NONE;
        }
    }

    // ##################################### CollectionRowView ###################################

    @Override
    public void showError() {
        Snackbar.make(rootView, R.string.collection_row_error_message, Snackbar.LENGTH_LONG).show();
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