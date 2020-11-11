package com.example.bilibili

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DrawableUtils
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.toDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.bilibili.ui.ZoomDrawable
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.my_toolbar.*


/**
 * 主要的Activity只有这一个 @_A_@!!!
 */
class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_view)
    }
}
















//    var mViewPager:ViewPager? = null
//    var mTabLayout:TabLayout? = null
//    var mDrawerLayout:DrawerLayout? = null
//    var mToolbar:Toolbar? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.home_fragment)
//        initViewPager()
//    }
//    fun initViewPager(){
//        //这里改了一点
//        mToolbar = findViewById(R.id.toolbar)
//        mToolbar!!.title = ""
//        //设定左边的icon
//        val icon: Drawable = resources.getDrawable(R.mipmap.ic_header_round)
//        val zoomDrawable:ZoomDrawable = ZoomDrawable()
//        mToolbar!!.navigationIcon = zoomDrawable.ZoomDrawableImage(icon, true, null, null, 1.5f, 1.5f)
//
//        setSupportActionBar(mToolbar)
//        val ab:androidx.appcompat.app.ActionBar = supportActionBar!!
//        ab.setDisplayHomeAsUpEnabled(true)
//        mTabLayout = findViewById(R.id.tab_layout)
//        mViewPager = findViewById(R.id.view_pager)
//        val titles = ArrayList<String>()
//        val fragments= ArrayList<Fragment>()
//        titles.add("直播")
//        titles.add("推荐")
//        titles.add("热门")
//        titles.add("追番")
//        titles.add("影视")
//        titles.add("抗击肺炎")
//        titles.add("小康")
//        //初始化tab与fragment
//        titles.forEach { mTabLayout!!.addTab(mTabLayout!!.newTab().setText(it)); fragments.add(ListFragment()) }
//        val mFragmentAdapter:FragmentAdapter = FragmentAdapter(this.supportFragmentManager, fragments, titles)
//        mViewPager!!.adapter = mFragmentAdapter
//        mTabLayout!!.setupWithViewPager(mViewPager)
//        mTabLayout!!.setTabsFromPagerAdapter(mFragmentAdapter)
//        //在这里设置新的抽屉界面
//        val navigationView:NavigationView = findViewById(R.id.navigation_view)
//        mDrawerLayout = findViewById(R.id.draw_layout)
//        navigationView!!.setNavigationItemSelectedListener {
//            it.setChecked(true)
//            val title:String = it.title.toString()
//            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
//            mDrawerLayout!!.closeDrawers()
//            true
//        }
//        //显示左边栏
//        toolbar.setNavigationOnClickListener {
//            mDrawerLayout!!.openDrawer(Gravity.LEFT)
//        }
//    }
//    //点击浮动按钮触发
//    fun checkin(view:View):Unit{
//        Snackbar.make(view, "点击", Snackbar.LENGTH_SHORT)
//            .setAction("评论", View.OnClickListener {  })
//            .setDuration(BaseTransientBottomBar.LENGTH_SHORT)
//            .show()
//    }
