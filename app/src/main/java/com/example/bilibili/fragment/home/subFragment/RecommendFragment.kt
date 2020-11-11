package com.example.bilibili.fragment.home.subFragment

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.collection.arrayMapOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.bilibili.R

class RecommendFragment : Fragment(){
    lateinit var viewFilter:ViewFlipper //滚动广告
    //滚动的图片资源
    private val paperList = listOf<Int>(R.mipmap.flipper01, R.mipmap.flipper02, R.mipmap.flipper03, R.mipmap.flipper04,
                                R.mipmap.flipper05)
    //滚动动画
    private val animations = mutableListOf<Animation>()

    /**
     * 初始化函数
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root:View = inflater.inflate(R.layout.recommend_subfragment, container, false)
        //设置滚动广告
        viewFilter = root.findViewById(R.id.home_recommend_viewFlipper)
        paperList.forEach {
            var imageView:ImageView = ImageView(context)
            imageView.setImageResource(it)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            viewFilter.addView(imageView)
        }
        animations.add(AnimationUtils.loadAnimation(context, R.anim.slide_in))
        animations.add(AnimationUtils.loadAnimation(context, R.anim.slide_out))
        viewFilter.inAnimation = animations[0]
        viewFilter.outAnimation = animations[1]
        viewFilter.startFlipping()

        //设置下边的列表
        val data = ArrayList<String>()
        data.add("测试测试测试测试测试测试测试测试测试")
        data.add("再测")
        data.add("春绮美空")
        data.add("测试")
        data.add("再测")
        val data_image = ArrayList<Int>()
        data_image.add(R.mipmap.flipper01)
        data_image.add(R.mipmap.flipper02)
        data_image.add(R.mipmap.flipper03)
        data_image.add(R.mipmap.flipper04)
        data_image.add(R.mipmap.flipper05)
        //设置列表
        val list: RecyclerView = root.findViewById(R.id.recommend_recyclerView)
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        //设置为GridView布局
        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        list.layoutManager = gridLayoutManager
        list.layoutParams = params
        list.itemAnimator = DefaultItemAnimator()
        val adapter:RecommendAdapter = RecommendAdapter(data, data_image, context!!)
        //设置分割线
//        val decoration:DividerItemDecoration = DividerItemDecoration()
//        decoration.DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL_LIST)
//        list.addItemDecoration(decoration)
        //设置单击事件
        adapter.setOnItemClickListener(object :RecommendAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(context, "单击第${position+1}条", Toast.LENGTH_LONG).show()
            }
        })
        list.adapter = adapter
        //设置刷新
        val swipeRefreshLayout:SwipeRefreshLayout = root.findViewById(R.id.refresh_layout)
        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.setColorSchemeResources(R.color.bilibili)
        swipeRefreshLayout.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show()
                object : Handler(){}.postDelayed(object :Runnable{
                    override fun run() {
                        //更新列表..
                        swipeRefreshLayout.isRefreshing = false
                    }
                }, 3000)
            }
        })
        return root
    }
}