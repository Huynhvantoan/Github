package com.toanit.core.base.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

public abstract class BaseActivity <T extends BasePresenter> extends SupportActivity implements BaseView {
  @Inject
  protected T mPresenter;
  private StateLayout mStateLayout = null;
  private ActivityComponent mActivityComponent;

  @SuppressWarnings("unchecked")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(setLayoutResourceID());
    if (mPresenter != null)
      mPresenter.attachView(this);
    ActivityCollector.addActivity(this);
    injectDependencies();
    // changeStatusColor();
    setNightOrDayMode();
    initNightModeSwitch();
    initViews(savedInstanceState);
    initData();
  }
  //Intent activity
	/*public static void navigate(@NonNull AppCompatActivity activity, @NonNull View transitionImage,
	                            @NonNull Movie movie) {
		Intent intent = new Intent(activity, MovieDetailsActivity.class);
		intent.putExtra(EXTRA_MOVIE, movie);

		ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, IMAGE);
		ActivityCompat.startActivity(activity, intent, options.toBundle());
	}
*/
  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
    if (null != getLoadingTargetView()) {
      mStateLayout = getLoadingTargetView();
    }
  }

  protected abstract void initViews(Bundle bundle);

  protected abstract @LayoutRes
  int setLayoutResourceID();

  protected abstract void initData();

  protected abstract void injectDependencies();

  protected abstract StateLayout getLoadingTargetView();

  protected void toggleShowLoading(boolean toggle) {
    if(checkProgress()) {
      if (toggle)
        mStateLayout.showProgressView();
      else
        mStateLayout.showContentView();
    }
  }

  protected void toggleShowEmpty(String msg, View.OnClickListener onClickListener) {
    if(checkProgress()) {
      mStateLayout.showEmptyView(msg);
      if (onClickListener != null) {
        mStateLayout.setEmptyAction(onClickListener);
      }
    }
  }

  protected void toggleShowError(String msg, View.OnClickListener onClickListener) {
    if(checkProgress()) {
      mStateLayout.showErrorView(msg);
      if (onClickListener != null) {
        mStateLayout.setErrorAction(onClickListener);
      }
    }
  }

  private boolean checkProgress(){
    return mStateLayout!=null;
  }

  @Override
  public void showEmptyView(String message) {
    toggleShowEmpty(message, null);
  }

  @Override
  public void showError(String message) {
    toggleShowError(message, null);
  }

  @Override
  public void showLoading() {
    toggleShowLoading(true);
  }

  @Override
  public void hideLoading() {
    toggleShowLoading(false);
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((BaseApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityComponent getActivityComponent(){
    if (mActivityComponent == null) {
      mActivityComponent = DaggerActivityComponent.builder()
              .applicationComponent(getApplicationComponent())
              .activityModule(new ActivityModule(this))
              .build();
    }
    return mActivityComponent;
  }

  protected Snackbar snackBarBuild(String message) {
    if (getLoadingTargetView() == null) {
      throw new RuntimeException("This getLoadingTargetView not view!");
    }
    return Snackbar.make(getLoadingTargetView(), message, Snackbar.LENGTH_LONG);
  }

  private void initNightModeSwitch() {
    //ColorfulNews-master
		/*if (this instanceof NewsActivity || this instanceof PhotoActivity) {
			MenuItem menuNightMode = mBaseNavView.getMenu().findItem(R.id.nav_night_mode);
			SwitchCompat dayNightSwitch = (SwitchCompat) MenuItemCompat
					.getActionView(menuNightMode);
			setCheckedState(dayNightSwitch);
			setCheckedEvent(dayNightSwitch);
		}*/
  }

  private void setNightOrDayMode() {
		/*if (MyUtils.isNightMode()) {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

			initNightView();
			mNightView.setBackgroundResource(R.color.night_mask);
		} else {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
		}*/
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (mPresenter != null)
      mPresenter.detachView();
    Logger.d("BaseActivity:onDestroy");
    RefWatcher refWatcher = BaseApplication.getRefWatcher();
    refWatcher.watch(this);
    ActivityCollector.removeActivity(this);
  }

}
