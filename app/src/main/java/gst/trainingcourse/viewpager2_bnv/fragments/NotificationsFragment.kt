package gst.trainingcourse.viewpager2_bnv.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gst.trainingcourse.viewpager2_bnv.R


class NotificationsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView =inflater.inflate(R.layout.fragment_notifications, container, false)
        return mView

    }


}