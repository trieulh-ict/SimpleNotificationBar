package io.trieulh.simplenotificationbar.items.viewholder

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import io.trieulh.simplenotificationbar.R
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.items.SimpleNotificationItem
import io.trieulh.simplenotificationbar.items.SimpleNotificationViewHolder

internal class ErrorViewHolder(parent: ViewGroup, barConfig: SimpleNotificationConfig) :
    SimpleNotificationViewHolder<SimpleNotificationItem.Error>(
        parent,
        R.layout.view_simple_notification_error,
        barConfig
    ) {
    @SuppressLint("SetTextI18n")
    override fun bindContent(item: SimpleNotificationItem.Error) {
        itemView.findViewById<TextView>(R.id.txt_content)?.apply {
            text = item.content
        }
    }
}