package gst.trainingcourse.viewpager2_bnv

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import gst.trainingcourse.viewpager2_bnv.fragments.DashBoardFragment
import gst.trainingcourse.viewpager2_bnv.fragments.HomeFragment
import gst.trainingcourse.viewpager2_bnv.fragments.NotificationsFragment

class MyViewPagerAdapter(val items: ArrayList<Fragment>,
        activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
     return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}