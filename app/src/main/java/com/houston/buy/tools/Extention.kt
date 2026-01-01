package com.houston.buy.tools

import android.view.View

inline fun View.onClick(mills: Long = 500L, crossinline l: (view: View) -> Unit) {
    setOnClickListener(object : Debouncer(mills) {
        override fun doClick(view: View) = l.invoke(view)
    })
}