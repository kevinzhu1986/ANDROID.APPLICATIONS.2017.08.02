package com.handmark.pulltorefresh.library.internal;

import android.util.Log;

public class Utils {

	static final String LOG_TAG = "PullToRefresh";

	public static void warnDeprecation(String depreacted, String replacement) {
		Log.w(LOG_TAG, "You're using the deprecated " + depreacted + " attr, please switch over to " + replacement);
	}

	public static float floor(float values) {
		return (float) Math.floor(values);
	}
}
