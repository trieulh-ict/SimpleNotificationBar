package io.trieulh.simplenotificationbar.items.viewholder

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import io.trieulh.simplenotificationbar.R
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.items.SimpleNotificationItem
import io.trieulh.simplenotificationbar.items.SimpleNotificationViewHolder

internal class WarningViewHolder(parent: ViewGroup, barConfig: SimpleNotificationConfig) :
    SimpleNotificationViewHolder<SimpleNotificationItem.Warning>(
        parent,
        R.layout.view_simple_notification_warning,
        barConfig
    ) {
    @SuppressLint("SetTextI18n")
    override fun bindContent(item: SimpleNotificationItem.Warning) {
        itemView.findViewById<TextView>(R.id.txt_content)?.apply {
            text = item.content
        }
    }
}