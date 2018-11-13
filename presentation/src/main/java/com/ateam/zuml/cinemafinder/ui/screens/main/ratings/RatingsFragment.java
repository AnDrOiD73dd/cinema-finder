package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;
import com.ateam.zuml.cinemafinder.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingsFragment extends BaseFragment implements RatingsView, BackButtonListener {

    private RatingsCollectionRowAdapter firstAdapter;
    private RatingsCollectionRowAdapter secondAdapter;
    private RatingsCollectionRowAdapter thirdAdapter;
    private RatingsCollectionRowAdapter fourthAdapter;

    @BindView(R.id.rating_root) LinearLayout rootView;

    @BindView(R.id.tv_first_row_name) TextView firstTitleView;
    @BindView(R.id.rv_first_row) RecyclerView firstRecyclerView;
    @BindView(R.id.pb_first_row) ProgressBar firstProgressBar;
    @BindView(R.id.tv_first_row_no_results) TextView firstNoResultsView;

    @BindView(R.id.tv_second_row_name) TextView secondTitleView;
    @BindView(R.id.rv_second_row) RecyclerView secondRecyclerView;
    @BindView(R.id.pb_second_row) ProgressBar secondProgressBar;
    @BindView(R.id.tv_second_row_no_results) TextView secondNoResultsView;

    @BindView(R.id.tv_third_row_name) TextView thirdTitleView;
    @BindView(R.id.rv_third_row) RecyclerView thirdRecyclerView;
    @BindView(R.id.pb_third_row) ProgressBar thirdProgressBar;
    @BindView(R.id.tv_third_row_no_results) TextView thirdNoResultsView;

    @BindView(R.id.tv_fourth_row_name) TextView fourthTitleView;
    @BindView(R.id.rv_fourth_row) RecyclerView fourthRecyclerView;
    @BindView(R.id.pb_fourth_row) ProgressBar fourthProgressBar;
    @BindView(R.id.tv_fourth_row_no_results) TextView fourthNoResultsView;

    @Inject ImageLoader imageLoader;

    @InjectPresenter RatingsPresenter presenter;

    public static RatingsFragment newInstance() {
        return new RatingsFragment();
    }

    @ProvidePresenter
    RatingsPresenter provideRatingsPresenter() {
        RatingsPresenter presenter = new RatingsPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ratings, container, false);
        init(view);
        setupRecyclerView(firstRecyclerView, firstAdapter);
        setupRecyclerView(secondRecyclerView, secondAdapter);
        setupRecyclerView(thirdRecyclerView, thirdAdapter);
        setupRecyclerView(fourthRecyclerView, fourthAdapter);
        setupToolbar(R.string.ratings, false);
        return view;
    }

    private void init(View view) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, view);
        firstAdapter = new RatingsCollectionRowAdapter(presenter.getFirstPresenter(), imageLoader);
        secondAdapter = new RatingsCollectionRowAdapter(presenter.getSecondPresenter(), imageLoader);
        thirdAdapter = new RatingsCollectionRowAdapter(presenter.getThirdPresenter(), imageLoader);
        fourthAdapter = new RatingsCollectionRowAdapter(presenter.getFourthPresenter(), imageLoader);
    }

    private void setupRecyclerView(RecyclerView recyclerView, RatingsCollectionRowAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    //region ### RatingsView ###
    @Override
    public void updateFirstRow() {
        firstAdapter.refreshView();
    }

    @Override
    public void updateSecondRow() {
        secondAdapter.refreshView();
    }

    @Override
    public void updateThirdRow() {
        thirdAdapter.refreshView();
    }

    @Override
    public void updateFourthRow() {
        fourthAdapter.refreshView();
    }

    @Override
    public void showFirstLoading() {
        firstProgressBar.setVisibility(View.VISIBLE);
        firstTitleView.setVisibility(View.GONE);
    }

    @Override
    public void showSecondLoading() {
        secondProgressBar.setVisibility(View.VISIBLE);
        secondTitleView.setVisibility(View.GONE);
    }

    @Override
    public void showThirdLoading() {
        thirdProgressBar.setVisibility(View.VISIBLE);
        thirdTitleView.setVisibility(View.GONE);
    }


    @Override
    public void showFourthLoading() {
        fourthProgressBar.setVisibility(View.VISIBLE);
        fourthTitleView.setVisibility(View.GONE);
    }

    @Override
    public void hideFirstLoading() {
        firstProgressBar.setVisibility(View.GONE);
        firstTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSecondLoading() {
        secondProgressBar.setVisibility(View.GONE);
        secondTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideThirdLoading() {
        thirdProgressBar.setVisibility(View.GONE);
        thirdTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFourthLoading() {
        fourthProgressBar.setVisibility(View.GONE);
        fourthTitleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInFirst() {
        firstNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInSecond() {
        secondNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInThird() {
        thirdNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInFourth() {
        fourthNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        Snackbar.make(rootView, R.string.collection_row_error_message, Snackbar.LENGTH_LONG).show();
    }
    //endregion

    //region ### BackButtonListener ###
    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
    //endregion
}
