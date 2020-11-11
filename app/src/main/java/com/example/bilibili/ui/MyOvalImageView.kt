package com.example.bilibili.ui

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap

/**
 * 绘制圆形的图片
 */
class MyOvalImageView(context:Context, attrs:AttributeSet) : AppCompatImageView(context, attrs) {
    private val mPaintBitmap: Paint = Paint(Paint.ANTI_ALIAS_FLAG)//抗锯齿
    private var mRawBitmap:Bitmap? = null
    private var mShader:BitmapShader? = null
    private val mMatrix:Matrix = Matrix()
    private var strokeColor:Int = 0xFFFFFF
    private var strokeWidth:Float = 0F

    override fun onDraw(canvas: Canvas?) {
        val rawBitmap:Bitmap? = getBitMap(drawable)
        if(rawBitmap != null){
            val viewMinSize:Int = width.coerceAtMost(height)// 取较小的值
            val viewWidth:Float = viewMinSize.toFloat()
            val viewHeight:Float = viewMinSize.toFloat()
            if(mShader == null || !rawBitmap.equals(mRawBitmap)){
                mRawBitmap = rawBitmap
                mShader = BitmapShader(mRawBitmap!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            }
            if(mShader != null){
                mMatrix.setScale(viewWidth/rawBitmap.width, viewHeight/rawBitmap.height)
                mShader?.setLocalMatrix(mMatrix)
            }
            mPaintBitmap.shader = mShader
            val radius:Float = viewMinSize/2.0f

            if(strokeWidth != 0f){
                val whitePaint:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
                whitePaint.color = strokeColor
                canvas?.drawCircle(radius, radius, radius, whitePaint)
                canvas?.drawCircle(radius, radius, radius - strokeWidth, mPaintBitmap)
            }else{
                canvas?.drawCircle(radius, radius, radius, mPaintBitmap)
            }
        }else{
            super.onDraw(canvas)
        }
    }

    /**
     * @param drawable 要绘制的素材
     */
    private fun getBitMap(drawable:Drawable?):Bitmap?{
        if(drawable != null){
            when(drawable::class.java){
                BitmapDrawable::class.java -> return drawable.toBitmap()
                ColorDrawable::class.java -> {
                    val rect:Rect = drawable.bounds
                    val width:Int = rect.right - rect.left
                    val height:Int = rect.bottom - rect.top
                    val drawableColor:ColorDrawable = drawable as ColorDrawable
                    val color:Int = drawableColor.color
                    val bitmap:Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                    val canvas:Canvas = Canvas(bitmap)
                    canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color))
                    return bitmap
                }
                else -> return null
            }
        }
        return null
    }
    /**
     * @param strokeWidth 边框宽度
     */
    public fun setStrokeWidth(strokeWidth:Float){
        this.strokeWidth = strokeWidth
    }

    /**
     * @param strokeColor 边框颜色
     */
    public fun setStrokeColor(strokeColor:Int){
        this.strokeColor = strokeColor
    }
}
