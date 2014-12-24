package net.dxs.myscroll.utils;

/**
 * Tween.js<br>
 * t: current time（当前时间）；<br>
 * b: beginning value（初始值）；<br>
 * c: change in value（变化量）；<br>
 * d: duration（持续时间）。<br>
 * you can visit 'http://easings.net/zh-cn' to get effect<br>
 * *****************************************************************************<br>
 * Linear：无缓动效果<br>
 * Quadratic：二次方的缓动（t^2）<br>
 * Cubic：三次方的缓动（t^3）<br>
 * Quartic：四次方的缓动（t^4）<br>
 * Quintic：五次方的缓动（t^5）<br>
 * Sinusoidal：正弦曲线的缓动（sin(t)）<br>
 * Exponential：指数曲线的缓动（2^t）<br>
 * Circular：圆形曲线的缓动（sqrt(1-t^2)）<br>
 * Elastic：指数衰减的正弦曲线缓动<br>
 * 超过范围的三次方缓动（(s+1)*t^3 – s*t^2）<br>
 * 指数衰减的反弹缓动<br>
 * 每个效果都分三个缓动方式，分别是：<br>
 * easeIn：从0开始加速的缓动；<br>
 * easeOut：减速到0的缓动；<br>
 * easeInOut：前半段从0开始加速，后半段减速到0的缓动。<br>
 * *****************************************************************************<br>
 * 
 * @author lijian
 * @date 2014-12-24 21:48:16
 */
public class Tween {

	/**
	 * 1.Linear：无缓动效果
	 */
	public static class Linear {
		public static int ease(int t, int b, int c, int d) {
			return c * t / d + b;
		}
	}

	/**
	 * 2.Quadratic：二次方的缓动（t^2）
	 */
	public static class Quad {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeIn(int t, int b, int c, int d) {
			return c * (t /= d) * t + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeOut(int t, int b, int c, int d) {
			return -c * (t /= d) * (t - 2) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeInOut(int t, int b, int c, int d) {
			if ((t /= d / 2) < 1)
				return c / 2 * t * t + b;
			return -c / 2 * ((--t) * (t - 2) - 1) + b;
		}
	}

	/**
	 * 3.Cubic：三次方的缓动（t^3）
	 */
	public static class Cubic {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeIn(int t, int b, int c, int d) {
			return c * (t /= d) * t * t + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeOut(int t, int b, int c, int d) {
			return c * ((t = t / d - 1) * t * t + 1) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeInOut(int t, int b, int c, int d) {
			if ((t /= d / 2) < 1)
				return c / 2 * t * t * t + b;
			return c / 2 * ((t -= 2) * t * t + 2) + b;
		}
	}

	/**
	 * 4.Quartic：四次方的缓动（t^4）
	 */
	public static class Quart {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeIn(int t, int b, int c, int d) {
			return c * (t /= d) * t * t * t + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeOut(int t, int b, int c, int d) {
			return -c * ((t = t / d - 1) * t * t * t - 1) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeInOut(int t, int b, int c, int d) {
			if ((t /= d / 2) < 1)
				return c / 2 * t * t * t * t + b;
			return -c / 2 * ((t -= 2) * t * t * t - 2) + b;
		}
	}

	/**
	 * 5.Quintic：五次方的缓动（t^5）
	 */
	public static class Quint {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeIn(int t, int b, int c, int d) {
			return c * (t /= d) * t * t * t * t + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeOut(int t, int b, int c, int d) {
			return c * ((t = t / d - 1) * t * t * t * t + 1) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static int easeInOut(int t, int b, int c, int d) {
			if ((t /= d / 2) < 1)
				return c / 2 * t * t * t * t * t + b;
			return c / 2 * ((t -= 2) * t * t * t * t + 2) + b;
		}
	}

	/**
	 * 6.Sinusoidal：正弦曲线的缓动（sin(t)）
	 */
	public static class Sine {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			return -c * Math.cos(t / d * (Math.PI / 2)) + c + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			return c * Math.sin(t / d * (Math.PI / 2)) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b;
		}
	}

	/**
	 * 7.Exponential：指数曲线的缓动（2^t）
	 */
	public static class Expo {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			if (t == 0)
				return b;
			if (t == d)
				return b + c;
			if ((t /= d / 2) < 1)
				return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
			return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
		}
	}

	/**
	 * 8.Circular：圆形曲线的缓动（sqrt(1-t^2)）
	 */
	public static class Circ {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			return -c * (Math.sqrt(1 - (t /= d) * t) - 1) + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			return c * Math.sqrt(1 - (t = t / d - 1) * t) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			if ((t /= d / 2) < 1)
				return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
			return c / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + b;
		}
	}

	/**
	 * 9.Elastic：指数衰减的正弦曲线缓动
	 */
	public static class Elastic {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			double s;
			double p = 0;
			double a = 0;
			if (t == 0)
				return b;
			if ((t /= d) == 1)
				return b + c;
			if (p == 0)
				p = d * .3;
			if (a == 0 || a < Math.abs(c)) {
				s = p / 4;
				a = c;
			} else {
				s = p / (2 * Math.PI) * Math.asin(c / a);
			}
			return -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			double s;
			double p = 0;
			double a = 0;
			if (t == 0)
				return b;
			if ((t /= d) == 1)
				return b + c;
			if (p == 0)
				p = d * .3;
			if (a == 0 || a < Math.abs(c)) {
				a = c;
				s = p / 4;
			} else {
				s = p / (2 * Math.PI) * Math.asin(c / a);
			}
			return (a * Math.pow(2, -10 * t) * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b);
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			double s;
			double p = 0;
			double a = 0;
			if (t == 0)
				return b;
			if ((t /= d / 2) == 2)
				return b + c;
			if (p == 0)
				p = d * (.3 * 1.5);
			if (a == 0 || a < Math.abs(c)) {
				a = c;
				s = p / 4;
			} else {
				s = p / (2 * Math.PI) * Math.asin(c / a);
			}
			if (t < 1)
				return -.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
			return a * Math.pow(2, -10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b;
		}
	}

	/**
	 * 10.超过范围的三次方缓动（(s+1)*t^3 – s*t^2）
	 */
	public static class Back {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			double s = 0;
			if (s == 0)
				s = 1.70158;
			return c * (t /= d) * t * ((s + 1) * t - s) + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			double s = 0;
			if (s == 0)
				s = 1.70158;
			return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b;
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			double s = 0;
			if (s == 0)
				s = 1.70158;
			if ((t /= d / 2) < 1)
				return c / 2 * (t * t * (((s *= (1.525)) + 1) * t - s)) + b;
			return c / 2 * ((t -= 2) * t * (((s *= (1.525)) + 1) * t + s) + 2) + b;
		}
	}

	/**
	 * 11.指数衰减的反弹缓动
	 */
	public static class Bounce {
		/**
		 * 从0开始加速的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeIn(int t, int b, int c, int d) {
			return c - Tween.Bounce.easeOut(d - t, 0, c, d) + b;
		}

		/**
		 * 减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeOut(int t, int b, int c, int d) {
			if ((t /= d) < (1 / 2.75)) {
				return c * (7.5625 * t * t) + b;
			} else if (t < (2 / 2.75)) {
				return c * (7.5625 * (t -= (1.5 / 2.75)) * t + .75) + b;
			} else if (t < (2.5 / 2.75)) {
				return c * (7.5625 * (t -= (2.25 / 2.75)) * t + .9375) + b;
			} else {
				return c * (7.5625 * (t -= (2.625 / 2.75)) * t + .984375) + b;
			}
		}

		/**
		 * 前半段从0开始加速，后半段减速到0的缓动
		 * 
		 * @param t current time（当前时间）
		 * @param b beginning value（初始值）
		 * @param c change in value（变化量）
		 * @param d duration（持续时间）
		 * @return
		 */
		public static double easeInOut(int t, int b, int c, int d) {
			if (t < d / 2) {
				return Tween.Bounce.easeIn(t * 2, 0, c, d) * .5 + b;
			} else {
				return Tween.Bounce.easeOut(t * 2 - d, 0, c, d) * .5 + c * .5 + b;
			}
		}
	}
}
