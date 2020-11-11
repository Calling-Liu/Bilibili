package com.example.bilibili.fragment.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bilibili.R

/**
 * 会员购
 */
class ShopFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root:View = inflater.inflate(R.layout.shop_fragment, container, false)
        //      fragment跳转设置
        val imageView_home: ImageView = root.findViewById(R.id.nav_home_guider)
        imageView_home.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_shop_to_nav_home)
        }
        val imageView_news: ImageView = root.findViewById(R.id.nav_news_guider)
        imageView_news.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_shop_to_nav_news)
        }
        val imageView_tv: ImageView = root.findViewById(R.id.nav_tv_guider)
        imageView_tv.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_shop_to_nav_tv)
        }
        return root
    }
}