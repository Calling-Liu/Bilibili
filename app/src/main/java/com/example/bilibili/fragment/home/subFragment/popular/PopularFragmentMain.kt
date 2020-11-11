package com.example.bilibili.fragment.home.subFragment.popular

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.bilibili.R

class PopularFragmentMain :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root:View = inflater.inflate(R.layout.popular_fragment, container, false)
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
        val list:RecyclerView = root.findViewById(R.id.popular_recyclerView)
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        list.layoutManager = LinearLayoutManager(context)
        list.layoutParams = params
        list.itemAnimator = DefaultItemAnimator()
        val adapter:PopularAdapter = PopularAdapter(data, data_image, context!!)
        adapter.setOnItemClickListener(object : PopularAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(context, "单击第${position+1}条", Toast.LENGTH_LONG).show()
            }
        })
        list.adapter = adapter
        //设置刷新
        val swipeRefreshLayout: SwipeRefreshLayout = root.findViewById(R.id.refresh_layout_popular)
        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.setColorSchemeResources(R.color.bilibili)
        swipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
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