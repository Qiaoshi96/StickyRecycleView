package com.example.stickylib;

import android.graphics.Rect;

public interface IPinnedHeaderDecoration {

	Rect getPinnedHeaderRect();

	int getPinnedHeaderPosition();

	/**
	 * 筛选时点击不同的部分要有不同的响应事件这里平分处理响应事件
	 * @return
	 */

	int getType();

}
