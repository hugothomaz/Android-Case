package com.hugothomaz.rotafrete.screen.freight

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class ViewPagerFreight(context: Context , attrs: AttributeSet) : ViewPager(context, attrs) {

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return false
    }

}