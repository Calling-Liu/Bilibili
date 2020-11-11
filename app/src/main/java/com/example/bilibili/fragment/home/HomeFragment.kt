package com.example.bilibili.fragment.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.example.bilibili.FragmentAdapter
import com.example.bilibili.ListFragment
import com.example.bilibili.R
import com.example.bilibili.fragment.home.subFragment.RecommendFragment
import com.example.bilibili.fragment.home.subFragment.popular.PopularFragmentMain
import com.example.bilibili.ui.ZoomDrawable
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

/**
 * 主页
 */
class HomeFragment:Fragment(){
    var mViewPager: ViewPager? = null
    var mTabLayout: TabLayout? = null
    var mDrawerLayout: DrawerLayout? = null
    var mToolbar: Toolbar? = null
    var mView:View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root:View = inflater.inflate(R.layout.home_fragment, container, false)
        mView = root
        initViewPager()
//      fragment跳转设置
        val imageView_tv:ImageView = root.findViewById(R.id.nav_tv_guider)
        imageView_tv.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_tv)
        }
        val imageView_news:ImageView = root.findViewById(R.id.nav_news_guider)
        imageView_news.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_news)
        }
        val imageView_shop:ImageView = root.findViewById(R.id.nav_shop_guider)
        imageView_shop.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_shop)
        }
        return root
    }
    fun initViewPager(){
        mToolbar = mView!!.findViewById(R.id.toolbar)
        mToolbar!!.title = ""
        //设定左边icon
        val icon:Drawable = resources.getDrawable(R.mipmap.ic_header_round)
        val zoomDrawable:ZoomDrawable = ZoomDrawable()
        mToolbar!!.navigationIcon = zoomDrawable.ZoomDrawableImage(icon, true, null, null, 1.5f, 1.5f)
        val activity:AppCompatActivity = activity  as AppCompatActivity
        activity.setSupportActionBar(mToolbar)
        val ab:androidx.appcompat.app.ActionBar = activity.supportActionBar!!
        ab.setDisplayHomeAsUpEnabled(true)
        mTabLayout = mView!!.findViewById(R.id.tab_layout)
        mViewPager = mView!!.findViewById(R.id.view_pager)
        val titles = ArrayList<String>()
        val fragments = ArrayList<Fragment>()
        titles.add("直播")
        titles.add("推荐")
        titles.add("热门")
        titles.add("追番")
        titles.add("影视")
        titles.add("抗击肺炎")
        titles.add("小康")
        //初始化tab与fragment
        titles.forEach {
            mTabLayout!!.addTab(mTabLayout!!.newTab().setText(it))
            when(it){
                "推荐" -> fragments.add(RecommendFragment())
                "热门" -> fragments.add(PopularFragmentMain())
                else -> fragments.add(ListFragment())
            }
        }
        val mFragmentAdapter:FragmentAdapter = FragmentAdapter(activity.supportFragmentManager, fragments, titles)
        mViewPager!!.adapter = mFragmentAdapter
        mTabLayout!!.setupWithViewPager(mViewPager)
        mTabLayout!!.setTabsFromPagerAdapter(mFragmentAdapter)
        //设置新的抽屉界面
        val navigationView:NavigationView = mView!!.findViewById(R.id.navigation_view)
        mDrawerLayout = mView!!.findViewById(R.id.draw_layout)
        navigationView!!.setNavigationItemSelectedListener {
            it.setChecked(true)
            val title:String = it.title.toString()
            Toast.makeText(activity.applicationContext, title, Toast.LENGTH_SHORT).show()
            mDrawerLayout!!.closeDrawers()
            true
        }
        //显示左边栏
        val mToolbarNew:Toolbar = mView!!.findViewById(R.id.toolbar)
        mToolbarNew.setNavigationOnClickListener {
            mDrawerLayout!!.openDrawer(Gravity.LEFT)
        }
        //设置右下角的按钮触发事件
//        val button:com.google.android.material.floatingactionbutton.FloatingActionButton = mView!!.findViewById(R.id.float_button)
//        button.setOnClickListener {
//            checkin(mView!!)
//        }
        //设置viewpager默认选中的项
        mViewPager!!.currentItem = 1
    }

    /**
     * view设置为自己所处的父view
     */
    fun checkin(view:View):Unit{
        Snackbar.make(view, "点击", Snackbar.LENGTH_SHORT)
            .setAction("评论", View.OnClickListener {  })
            .setDuration(BaseTransientBottomBar.LENGTH_SHORT)
            .show()
    }
}