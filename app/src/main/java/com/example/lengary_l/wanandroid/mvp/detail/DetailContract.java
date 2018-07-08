package com.example.lengary_l.wanandroid.mvp.detail;

import com.example.lengary_l.wanandroid.mvp.BasePresenter;
import com.example.lengary_l.wanandroid.mvp.BaseView;

import java.util.List;

public interface DetailContract {
    interface Presenter extends BasePresenter{

        void collectArticle(int userId,int originId);

        void uncollectArticle(int userId, int originId);

        void insertReadLaterArticle(int userId, int id, long timeStamp);

        void removeReadLaterArticle(int userId, int id);

        void checkIsReadLater(int userId, int id);

        void refreshCollectIdList(int userId);


        
    }

    interface View extends BaseView<Presenter>{
        void showCollectStatus(boolean isSuccess);

        void showUnCollectStatus(boolean isSuccess);

        boolean isActive();

        void changeFavoriteState();

        void saveReadLaterState(boolean isReadLater);

        void saveFavoriteArticleIdList(List<Integer> list);


    }
}
