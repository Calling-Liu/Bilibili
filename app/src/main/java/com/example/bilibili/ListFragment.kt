package com.example.bilibili

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contentView = LayoutInflater.from(context).inflate(R.layout.list_fragment,container, false)
        val mRecyclerView = contentView.findViewById<RecyclerView>(R.id.list)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = RecyclerViewAdapter(context)
        return contentView
    }
}
