package com.vjapp.catalogviewer.components

import android.app.Activity
import android.app.Dialog
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.vjapp.catalogviewer.R
import kotlin.math.truncate


class VJDialog(val contextActivity: FragmentActivity, val layoutResId: Int, val matchParent:Boolean=false): Dialog(contextActivity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // before
        setContentView(layoutResId)

        val dpWidth2=getDialogDefaultWidth(contextActivity)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(window!!.attributes)

        if (!matchParent)
        {lp.width = truncate(dpWidth2 * 0.9).toInt()
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        }
        else
        {lp.width  = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
        }

        if (window!=null) {
            if (!matchParent) window!!.setBackgroundDrawableResource(R.drawable.round_corners)
            else window!!.setBackgroundDrawableResource(R.drawable.small_round_corners)
            window!!.attributes = lp
        }
    }


    fun getDialogDefaultWidth(context: FragmentActivity):Int {
        return getScreenWidth(context)
    }

    fun getScreenWidth(activity: Activity): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = activity.windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

}