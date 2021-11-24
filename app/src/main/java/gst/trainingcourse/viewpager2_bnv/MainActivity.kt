package gst.trainingcourse.viewpager2_bnv

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import gst.trainingcourse.viewpager2_bnv.fragments.DashBoardFragment
import gst.trainingcourse.viewpager2_bnv.fragments.HomeFragment
import gst.trainingcourse.viewpager2_bnv.fragments.NotificationsFragment
import gst.trainingcourse.viewpager2_bnv.transformer.DepthPageTransformer
import gst.trainingcourse.viewpager2_bnv.transformer.ZoomOutTransformer

class MainActivity : AppCompatActivity() {
    private lateinit var vp2 :ViewPager2
    private lateinit var choose :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        vp2=findViewById(R.id.vp2)
        val bnv :BottomNavigationView = findViewById(R.id.bnv)

     val fragments :ArrayList<Fragment> = arrayListOf(
        HomeFragment(),
        DashBoardFragment(),
        NotificationsFragment()
     )

        val adapter =MyViewPagerAdapter(fragments,this)
        vp2.adapter =adapter
        vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0-> bnv.menu.findItem(R.id.home).setChecked(true)
                    1-> bnv.menu.findItem(R.id.dashboard).setChecked(true)
                    2-> bnv.menu.findItem(R.id.notifications).setChecked(true)
                }
            }
        })

        choose =findViewById(R.id.choose)
        choose.setOnClickListener{
          showPopup(choose)
        }
        bnv.setOnItemSelectedListener(mOnNaviagation)
    }

    private fun showPopup(view:View) {
        val popupMenu = PopupMenu(this,view)
        popupMenu.inflate(R.menu.menu_main)
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {item:MenuItem?->
                when(item!!.itemId){
                    R.id.zoom ->{
                        vp2.setPageTransformer(ZoomOutTransformer())
                    }
                    R.id.depth-> {
                        vp2.setPageTransformer(DepthPageTransformer())
                    }
                }
            true
        })
        popupMenu.show()
    }

    private val mOnNaviagation =BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId){
            R.id.home ->{
                vp2.currentItem =0
                return@OnNavigationItemSelectedListener true
            }
            R.id.dashboard ->{
                vp2.currentItem =1
                return@OnNavigationItemSelectedListener true
            }
            R.id.notifications ->{
                vp2.currentItem =2
                return@OnNavigationItemSelectedListener true
            }
            else ->{
                vp2.currentItem =0
                return@OnNavigationItemSelectedListener true
            }
        }
    }



    override fun onBackPressed() {
        if(vp2.currentItem == 0){
            super.onBackPressed()
        }else{
            vp2.currentItem = vp2.currentItem -1
        }

    }


}

