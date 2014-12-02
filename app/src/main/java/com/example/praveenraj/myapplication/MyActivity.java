package com.example.praveenraj.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


public class MyActivity extends FragmentActivity implements ObservableScrollView.Callbacks{
  private ObservableScrollView mObservableScrollView;
  private View mPlaceholderView;
  private TabPageIndicator mStickyView;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


    mStickyView = (TabPageIndicator) findViewById(R.id.indicator);
    mObservableScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);
    mObservableScrollView.setCallbacks(this);

    mPlaceholderView = findViewById(R.id.placeholder);

    mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
      new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
          onScrollChanged(mObservableScrollView.getScrollY());
        }
      });



  }

  @Override
  public void onScrollChanged(int scrollY) {
    if(scrollY - mPlaceholderView.getBottom() >= 0)
      mStickyView.setTranslationY(scrollY - mPlaceholderView.getBottom());

    if(scrollY - mPlaceholderView.getTop() <= 0)
      mStickyView.setTranslationY(0);

  }

  @Override
  public void onDownMotionEvent() {

  }

  @Override
  public void onUpOrCancelMotionEvent() {

  }
}
