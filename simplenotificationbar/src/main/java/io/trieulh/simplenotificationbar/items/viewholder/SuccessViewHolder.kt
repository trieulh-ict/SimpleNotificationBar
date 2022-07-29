package io.trieulh.simplenotificationbar.items.viewholder

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import io.trieulh.simplenotificationbar.R
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.items.SimpleNotificationItem
import io.trieulh.simplenotificationbar.items.SimpleNotificationViewHolder

internal class SuccessViewHolder(parent: ViewGroup, barConfig: SimpleNotificationConfig) :
    SimpleNotificationViewHolder<SimpleNotificationItem.Success>(
        parent,
        R.layout.view_simple_notification_success,
        barConfig
    ) {
    @SuppressLint("SetTextI18n")
    override fun bindContent(item: SimpleNotificationItem.Success) {
        itemView.findViewById<TextView>(R.id.txt_content)?.apply {
            text = item.content
        }
    }
}