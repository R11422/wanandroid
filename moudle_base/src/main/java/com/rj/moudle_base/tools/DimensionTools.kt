package com.ruijie.base.tools

import android.content.res.Resources

/**
 * 系统工具类
 * Created by lqh on 2016/01/01.
 */
object DimensionTools {
    private val S_METRICS = Resources.getSystem().displayMetrics
    /**
     * @return 屏幕宽度(px)
     */
    @JvmStatic
    val screenWidth = S_METRICS.widthPixels
    /**
     * @return 获取屏幕高度(px)
     */
    @JvmStatic
    val screenHeight = S_METRICS.heightPixels

    @JvmStatic
    fun densityDpi() = S_METRICS.densityDpi

    @JvmStatic
    fun dp2px(dpValue: Float) = (dpValue * S_METRICS.density + 0.5f).toInt()// 四舍五入

    @JvmStatic
    fun px2dp(pxValue: Float) = (pxValue / S_METRICS.density + 0.5f).toInt()

    @JvmStatic
    fun px2sp(pxValue: Float) = (pxValue / S_METRICS.scaledDensity + 0.5).toInt()

    @JvmStatic
    fun sp2px(spValue: Float) = (spValue * S_METRICS.scaledDensity + 0.5f).toInt()
}
