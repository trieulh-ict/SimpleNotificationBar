package io.trieulh.simplenotificationbar.items.viewholder

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import io.trieulh.simplenotificationbar.R
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.SimpleNotificationArg
import io.trieulh.simplenotificationbar.items.SimpleNotificationViewHolder

internal class CustomViewHolder(parent: ViewGroup, barConfig: SimpleNotificationConfig) :
    SimpleNotificationViewHolder<SimpleNotificationArg.Custom>(
        parent,
        R.layout.view_simple_notification_success,
        barConfig
    ) {
    override fun bindContent(item: SimpleNotificationArg) {
        if (item !is SimpleNotificationArg.Custom) return
        itemView.findViewById<TextView>(R.id.txt_content)?.apply {
            text = item.content
        }
        itemView.findViewById<ImageView>(R.id.img_icon)?.run {
            setImageDrawable(item.additionalArg.iconDrawable)
        }
        itemView.findViewById<ConstraintLayout>(R.id.cl_background)?.run {
            background = item.additionalArg.backgroundDrawable
        }
    }
}
