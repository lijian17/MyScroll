package net.dxs.myscroll.view.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class ViewGroupLayout extends ViewGroup {

	private Context mContext;
	private Scroller scroller;
	/**
	 * 当前屏幕显示的子view的下标
	 */
	private int curId;

	public ViewGroupLayout(Context context) {
		super(context);
		this.mContext = context;
		init();
	}

	private void init() {
		scroller = new Scroller(mContext);
	}

	/**
	 * 对子view进行测量大小 view显示出来的几个步骤： 1、构造方法 2、测量大小 3、指定位置 4、绘制出来
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		for (int i = 0; i < getChildCount(); i++) {
			View view = getChildAt(i);
			view.measure(widthMeasureSpec, heightMeasureSpec);
		}
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		for (int i = 0; i < getChildCount(); i++) {
			View view = getChildAt(i);
			view.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
		}
	}

	/**
	 * 将viewGroup的内容移动到适当的位置上
	 */
	private void moveToDest() {
		int destId = (getScrollX() + getWidth() / 2) / getWidth();
		moveToDest(destId);
	}

	/**
	 * 将指定下标的子view移动到屏幕上来
	 * 
	 * @param destId 子view下标
	 */
	public void moveToDest(int destId) {

		if (destId > getChildCount() - 1) {//处理下标超过边界的问题
			destId = getChildCount() - 1;
		}

		curId = destId;

		if (changedListener != null) {
			changedListener.changedTo(curId);
		}

		int distance = destId * getWidth() - getScrollX();
		//scroller.startScroll(getScrollX(), 0, distance, 0);//使用默认完成时间250ms
		/**
		 * 处理下速度问题(让播放时间与距离成正比)
		 */
		scroller.startScroll(getScrollX(), 0, distance, 0, Math.abs(distance));

		invalidate();//刷新视图     会执行  computeScroll() 这个方法 
	}

	@Override
	public void computeScroll() {//当父类要去更新子类的ScrollX,ScrollY的时候调用该方法
		if (scroller.computeScrollOffset()) {//是否还有偏移量，判断动画结束了没
			scrollTo(scroller.getCurrX(), 0);
			invalidate();
		}
	}

	/**
	 * 对外暴露一个接口
	 * 
	 * @author lijian
	 * 
	 */
	public interface IPageChangedListener {
		public void changedTo(int pageId);
	}

	private IPageChangedListener changedListener;

	public IPageChangedListener getChangedListener() {
		return changedListener;
	}

	public void setChangedListener(IPageChangedListener changedListener) {
		this.changedListener = changedListener;
	}

	/**
	 * 图片自动轮播的下标传递
	 * 
	 * @return
	 */
	public int getCurId() {
		return curId;
	}
}
