package com.example.lengary_l.wanandroid.mvp.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lengary_l.wanandroid.R;
import com.example.lengary_l.wanandroid.data.source.ArticlesDataRepository;
import com.example.lengary_l.wanandroid.data.source.local.ArticlesDataLocalSource;
import com.example.lengary_l.wanandroid.data.source.remote.ArticlesDataRemoteSource;

public class CategoryActivity extends AppCompatActivity {
    public static final String CATEGORY_ID = "CATEGORY_ID";
    public static final String CATEGORY_NAME = "CATEGORY_NAME";

    private CategoryFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        if (savedInstanceState != null) {
            fragment = (CategoryFragment) getSupportFragmentManager().getFragment(savedInstanceState, CategoryFragment.class.getSimpleName());
        } else {
            fragment = CategoryFragment.newInstance();
        }

        new CategoryPresenter(fragment, ArticlesDataRepository.getInstance(ArticlesDataRemoteSource.getInstance(), ArticlesDataLocalSource.getInstance()));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.view_pager, fragment, CategoryFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (fragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, CategoryFragment.class.getSimpleName(), fragment);
        }
    }
}
