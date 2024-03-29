package com.appnroll.recruitment.view.viper.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public abstract class ViperAiPassiveDialog<ViewType extends MvpView>
        extends MvpDialogFragment<ViewType, ViperPresenter<ViewType>>
        implements ViperView {

    /**
     * <b>DO NOT</b> use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br>
     * Instead you should use getters to provide
     * event sources that will notify presenter after presenter's registration to them. To use
     * getPresenter() method you shall use non-passive Moviper view.
     *
     * @return raw {@link ViperPresenter}, so you can't call any custom methods on it anyway
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<ViewType> getPresenter() {
        return super.getPresenter();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }
}
