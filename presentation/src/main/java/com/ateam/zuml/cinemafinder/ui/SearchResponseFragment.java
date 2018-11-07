package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;
import com.ateam.zuml.cinemafinder.util.image.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResponseFragment extends MvpAppCompatFragment
        implements SearchResultAdapter.OnItemClickListener, SearchResponseView, BackButtonListener {

    private static final String QUERY_EXTRA_KEY = "query_extra_key";

    private SearchResultAdapter adapter;

    @BindView(R.id.rv_search_response) RecyclerView recyclerView;

    @Inject ImageLoader<ImageView> imageLoader;

    @InjectPresenter SearchResponsePresenter presenter;

    @ProvidePresenter
    SearchResponsePresenter provideSearchResponsePresenter() {
        Bundle bundle = getArguments();
        String movieTitle = "";
        if (bundle != null && bundle.containsKey(QUERY_EXTRA_KEY)) {
            movieTitle = bundle.getString(QUERY_EXTRA_KEY);
        }
        SearchResponsePresenter presenter = new SearchResponsePresenter(movieTitle);
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static SearchResponseFragment newInstance(String query) {
        SearchResponseFragment fragment = new SearchResponseFragment();
        Bundle args = new Bundle();
        args.putString(QUERY_EXTRA_KEY, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_response, container, false);
        setupToolbar();
        init(view);
        return view;
    }

    private void setupToolbar() {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (MainActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(R.string.search_response), true);
            widgetTuning.setSearchVisibility(true);
        }
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

    @Override
    public void onItemClick(int position) {
        presenter.showDetailsInfo(position);
    }

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
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
