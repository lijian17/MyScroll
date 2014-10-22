package net.dxs.myscroll.view.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * 同步水平滚动
 */
public class SyncHorizontalScrollView extends HorizontalScrollView {
	private ScrollViewListener scrollViewListener = null;
	private boolean mboo_ableScroll = true;

	public SyncHorizontalScrollView(Context context) {
		super(context);
	}

	public SyncHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setScrollViewListener(ScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
		}
	}

	public void ableScroll(boolean _canScroll) {
		mboo_ableScroll = _canScroll;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (!mboo_ableScroll) {
			return false;
		}

		return super.onTouchEvent(ev);
	}

}
