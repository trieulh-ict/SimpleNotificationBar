package io.trieulh.simplenotificationbar.items

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import io.trieulh.simplenotificationbar.SimpleNotificationConfig

@SuppressLint("ClickableViewAccessibility")
internal abstract class SimpleNotificationViewHolder<out SimpleNotificationItem>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
    private val barConfig: SimpleNotificationConfig
) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            layoutId,
            parent,
            false
        )
    ) {

    private var timer: CountDownTimer? = null

    abstract fun bindContent(item: @UnsafeVariance SimpleNotificationItem)

    fun bindItem(item: @UnsafeVariance SimpleNotificationItem) {
        timer?.cancel()
        timer = object : CountDownTimer(barConfig.duration, 1000) {
            override fun onTick(p0: Long) {
//                TODO("Not yet implemented")
            }

            override fun onFinish() {
                itemView.performClick()
                timer?.cancel()
            }


        }
        timer?.start()
        bindContent(item)
    }

    fun unBind() {
        timer?.cancel()
    }
}