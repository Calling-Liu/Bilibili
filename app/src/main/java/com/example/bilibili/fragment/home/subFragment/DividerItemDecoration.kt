package com.example.bilibili.fragment.home.subFragment

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.DrawFilter
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.AttributedString

class DividerItemDecoration : RecyclerView.ItemDecoration() {
    companion object {
        fun get():IntArray{
            val res = IntArray(1)
            res[0] = android.R.attr.listDivider
            return res
        }
        var ATTRS = get()
        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        val VERTICAL_LIST = LinearLayoutManager.VERTICAL
    }
    private var mDivider: Drawable? = null
    private var mOrientation:Int = 0
    /**
     * 初始化
     */
    public fun DividerItemDecoration(context: Context, orientation:Int){
        val a:TypedArray = context.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)
        a.recycle()
        setOrientation(orientation)
    }

    /**
     * 设置布局
     */
    public fun setOrientation(orientation:Int){
        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw IllegalArgumentException("无效布局")
        }
        mOrientation = orientation
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if(mOrientation == VERTICAL_LIST){//这里有修改
            drawVertical(c, parent)
            drawHorizontal(c, parent)
        }else{
            drawHorizontal(c, parent)
            drawVertical(c, parent)
        }
    }

    /**
     * 绘制纵向布局分割线
     */
    fun drawVertical(c:Canvas, parent:RecyclerView){
        val childCount:Int = parent.childCount
        for(i in 0 until childCount){
            val child: View = parent.getChildAt(i)
            //这里改一下
            val left:Int = parent.paddingLeft + child.left
            val params:RecyclerView.LayoutParams = RecyclerView.LayoutParams(child.layoutParams)
            val right:Int = child.right - params.rightMargin
            val top:Int = child.bottom + params.bottomMargin
            val bootom:Int = top + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left, top, right, bootom)
            mDivider!!.draw(c)
        }
    }

    /**
     * 绘制横向布局分割线
     */
    fun drawHorizontal(c:Canvas, parent: RecyclerView){
        val childCount:Int = parent.childCount
        for(i in 0 until childCount){
            val child:View = parent.getChildAt(i)
            val top:Int = parent.paddingTop
            val params:RecyclerView.LayoutParams = RecyclerView.LayoutParams(child.layoutParams)
            //这里改一下
            val bottom:Int = child.bottom - params.bottomMargin
            val left:Int = child.right + params.rightMargin
            val right:Int = left + mDivider!!.intrinsicWidth
            mDivider!!.setBounds(left, top, right, bottom)
            mDivider!!.draw(c)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if(mOrientation == VERTICAL_LIST){
            outRect.set(0, 0, 0, mDivider!!.intrinsicHeight)
        }else{
            outRect.set(0 , 0 , mDivider!!.intrinsicWidth, 0)
        }
    }
}


