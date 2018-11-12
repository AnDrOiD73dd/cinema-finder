package com.ateam.zuml.cinemafinder.ui.screens.main.favorites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class FavoritesFragment extends BaseFragment implements FavoritesView, BackButtonListener {

    private FavoritesListAdapter adapter;

    @BindView(R.id.favorite_root) ConstraintLayout rootView;
    @BindView(R.id.rv_favorites_list) RecyclerView favoritesListView;

    @Inject ImageLoader imageLoader;

    @InjectPresenter FavoritesPresenter presenter;

    @ProvidePresenter
    FavoritesPresenter provideFavoritesPresenter() {
        FavoritesPresenter presenter = new FavoritesPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        init(view);
        return view;
    }

    private void init(View v) {
        App.getApp().getAppComponent().inject(this);
        ButterKnife.bind(this, v);
        setupToolbar(R.string.favorites, false);
        adapter = new FavoritesListAdapter(presenter.getListPresenter(), imageLoader);
        favoritesListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoritesListView.setAdapter(adapter);
        adapter.setOnItemClickListener(favoriteItemClickListener);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    private FavoritesListAdapter.OnItemClickListener favoriteItemClickListener = new FavoritesListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            presenter.onItemClicked(position);
        }

        @Override
        public void onRemoveItemClick(int position) {
            presenter.onRemoveItemClicked(position);
        }
    };

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }

    // #################################### FavoritesView ###################################

    @Override
    public void updateItemsList() {
        adapter.refreshView();
    }

    @Override
    public void itemRemoved(int position) {
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void showNotifyingMessage() {
        Snackbar.make(rootView, R.string.removed_favorite_item, Snackbar.LENGTH_LONG).show();
    }
}
