package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.presentation.presenter.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.presentation.view.SearchResponseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResponseFragment extends MvpAppCompatFragment
        implements RecyclerViewAdapter.OnItemClickListener, SearchResponseView {

    private static final String QUERY_EXTRA_KEY = "query_extra_key";

    private RecyclerViewAdapter adapter;
    private String query;

    @BindView(R.id.rv_search_response) RecyclerView recyclerView;

    @InjectPresenter SearchResponsePresenter presenter;

    @ProvidePresenter
    SearchResponsePresenter provideSearchResponsePresenter() {
        SearchResponsePresenter presenter = new SearchResponsePresenter();
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
        if (getArguments() != null) {
            this.query = getArguments().getString(QUERY_EXTRA_KEY);
        }

        ButterKnife.bind(this, v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<MovieModel> searchList = new ArrayList<>();
        searchList.add(new MovieModel(1, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "3000-05-06", new String[]{"Какой-то жанр"}, 10.0f));
        searchList.add(new MovieModel(2, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "1000-05-06", new String[]{"Какой-то жанр", "Какой-то жанр", "Какой-то жанр", "Какой-то жанр", "Какой-то жанр"}, 9.0f));
        searchList.add(new MovieModel(3, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "2000-05-06", new String[]{"Какой-то жанр"}, 8.0f));
        searchList.add(new MovieModel(4, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "3000-05-06", new String[]{"Какой-то жанр", "Какой-то жанр", "Какой-то жанр"}, 7.0f));
        searchList.add(new MovieModel(5, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "1000-05-06", new String[]{"Какой-то жанр"}, 6.0f));
        searchList.add(new MovieModel(6, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "2000-05-06", new String[]{"Какой-то жанр", "Какой-то жанр"}, 5.0f));
        searchList.add(new MovieModel(7, R.drawable.ic_broken_image, "Какое-то название", "Второе какое-то название", "3000-05-06", new String[]{"Какой-то жанр"}, 4.0f));

        adapter = new RecyclerViewAdapter(searchList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        presenter.showDetailsInfo();
    }
}