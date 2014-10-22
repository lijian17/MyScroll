package net.dxs.myscroll.view.scroll;

import android.widget.FrameLayout;

public interface ScrollViewListener {

	void onScrollChanged(FrameLayout layout, int x, int y, int oldx, int oldy);

}