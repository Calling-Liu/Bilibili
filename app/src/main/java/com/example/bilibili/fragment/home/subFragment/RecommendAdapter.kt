package com.example.bilibili.fragment.home.subFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bilibili.R

class RecommendAdapter(val mList:ArrayList<String>, val mImageList:ArrayList<Int>, val mContext:Context) : RecyclerView.Adapter<RecommendAdapter.MyViewHolder>(){
    private var mOnItemClickListener:OnItemClickListener? = null
    public fun removeData(position:Int) :Unit {
        mList.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendAdapter.MyViewHolder {
        val contentView = LayoutInflater.from(mContext).inflate(R.layout.recommend_adapter, parent, false)
        val holder:MyViewHolder = MyViewHolder(contentView)
        //设置单击事件，和我们的接口挂钩
        contentView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mOnItemClickListener!!.onItemClick(v!!, v.tag as Int)// as真好用
            }
        })

        return holder
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.setText(mList.get(position))
        holder.itemView.tag = position
        holder.image_list.setImageResource(mImageList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val tv:TextView = view.findViewById(R.id.text_id)
        val image_list:ImageView = view.findViewById(R.id.recommend_recyclerView_listImage)
    }
    //我们的事件接口，可以在这里扩充
    public interface OnItemClickListener{
        //单击
        fun onItemClick(view: View, position: Int)
    }
    //设置点击属性
    public fun setOnItemClickListener(mOnItemClickListener: OnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener
    }
}
