package com.houston.buy.tools

import android.view.View

abstract class Debouncer(private val millis: Long = 1000L) : View.OnClickListener {
    override fun onClick(view: View) {
        if (enabled) {
            enabled = false
            view.postDelayed(ENABLE_AGAIN, millis)
            doClick(view)
        }
    }

    abstract fun doClick(view: View)

    companion object {
        var enabled = true
        private val ENABLE_AGAIN = Runnable { enabled = true }
    }
}