package com.ateam.zuml.cinemafinder.ui.screens.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.ui.common.WidgetTuning;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResponseFragment extends BaseFragment
        implements SearchResultAdapter.OnItemClickListener, SearchResponseView, BackButtonListener {

    private static final String QUERY_EXTRA_KEY = "query_extra_key";

    private SearchResultAdapter adapter;

    @BindView(R.id.cl_search_response) ConstraintLayout rootView;
    @BindView(R.id.pb_search_response) ProgressBar progressBarView;
    @BindView(R.id.rv_search_response) RecyclerView recyclerView;
    @BindView(R.id.tv_no_search_results) TextView noSearchResultsView;

    @Inject ImageLoader imageLoader;

    @InjectPresenter SearchResponsePresenter presenter;

    public static SearchResponseFragment newInstance(String query) {
        SearchResponseFragment fragment = new SearchResponseFragment();
        Bundle args = new Bundle();
        args.putString(QUERY_EXTRA_KEY, query);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    SearchResponsePresenter provideSearchResponsePresenter() {
        SearchResponsePresenter presenter = new SearchResponsePresenter(getMovieTitle());
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    private String getMovieTitle() {
        Bundle bundle = getArguments();
        String movieTitle = "";
        if (bundle != null && bundle.containsKey(QUERY_EXTRA_KEY)) {
            movieTitle = bundle.getString(QUERY_EXTRA_KEY);
        }
        return movieTitle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_response, container, false);
        init(view);
        setupToolbar(R.string.search_response, true);
        return view;
    }

    private void init(View v) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, v);

        adapter = new SearchResultAdapter(presenter.getListPresenter(), imageLoader);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    // ########################## SearchResultAdapter.OnItemClickListener ########################

    @Override
    public void onItemClick(int position) {
        presenter.onItemClicked(position);
    }

    // #################################### SearchResponseView ###################################

    @Override
    public void closeSearch() {
        if (getActivity() != null) {
            ((WidgetTuning) getActivity()).closeSearch();
        }
    }

    @Override
    public void updateSearchList() {
        adapter.refreshView();
    }

    @Override
    public void showNoSearchResults() {
        noSearchResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoSearchResults() {
        noSearchResultsView.setVisibility(View.GONE);
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

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
