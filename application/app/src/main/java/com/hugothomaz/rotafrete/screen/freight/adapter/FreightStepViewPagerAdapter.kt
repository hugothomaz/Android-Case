package com.hugothomaz.rotafrete.screen.freight.adapter

import android.view.MotionEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hugothomaz.domain.model.enums.OperationPointEnum
import com.hugothomaz.rotafrete.screen.freight.steps.*


class FreightStepViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val listFragments: List<Fragment> =
        arrayListOf(
            FragmentAxis(),
            FragmentFuelPrice(),
            FragmentFuelConsumption(),
            FragmentPoint(OperationPointEnum.OPERATION_START),
            FragmentPoint(OperationPointEnum.OPERATION_END),
            FragmentResume()
        )


    fun getFragment(position : Int) : Fragment{
        return listFragments.get(position)
    }

    override fun getItem(position: Int): Fragment {
        return listFragments.get(position)
    }

    override fun getCount(): Int {
        return listFragments.size
    }


    fun onTouchEvent(event: MotionEvent?): Boolean {
        return false
    }




}