package com.example.bilibili.fragment.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bilibili.R

/**
 * 频道
 */
class TVFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root:View = inflater.inflate(R.layout.tv_fragment, container, false)
        //      fragment跳转设置
        val imageView_home: ImageView = root.findViewById(R.id.nav_home_guider)
        imageView_home.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_tv_to_nav_home)
        }
        val imageView_news: ImageView = root.findViewById(R.id.nav_news_guider)
        imageView_news.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_tv_to_nav_news)
        }
        val imageView_shop: ImageView = root.findViewById(R.id.nav_shop_guider)
        imageView_shop.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_tv_to_nav_shop)
        }
        return root
    }
}