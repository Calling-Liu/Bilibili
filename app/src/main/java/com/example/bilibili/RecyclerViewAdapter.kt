package com.example.bilibili

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class RecyclerViewAdapter(val mContext:Context?) : RecyclerView.Adapter<RecyclerViewAdapter.Companion.ViewHolder>(){
    companion object{
        class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.Companion.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view:View = holder.mView
        view.setOnClickListener {
            Snackbar.make(view, "点了", Snackbar.LENGTH_LONG)
                .setAction("事件", View.OnClickListener {
                    Toast.makeText(mContext, "事件触发", Toast.LENGTH_SHORT).show()
                })
                .setDuration(BaseTransientBottomBar.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}
