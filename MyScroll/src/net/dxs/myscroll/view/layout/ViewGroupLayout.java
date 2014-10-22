package net.dxs.myscroll.view.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class ViewGroupLayout extends ViewGroup {

	private Context mContext;

	public ViewGroupLayout(Context context) {
		super(context);
		this.mContext = context;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		for (int i = 0; i < getChildCount(); i++) {
			View view = getChildAt(i);
			view.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
		}
	}

}
