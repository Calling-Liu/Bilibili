package com.example.bilibili

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentAdapter(val fm:FragmentManager, val fragments:ArrayList<Fragment>,val  titles:ArrayList<String>) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount():Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles.get(position)
}
