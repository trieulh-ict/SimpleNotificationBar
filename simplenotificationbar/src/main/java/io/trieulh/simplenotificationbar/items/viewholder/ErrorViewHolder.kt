package io.trieulh.simplenotificationbar.items.viewholder

import android.view.ViewGroup
import android.widget.TextView
import io.trieulh.simplenotificationbar.R
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.SimpleNotificationArg
import io.trieulh.simplenotificationbar.items.SimpleNotificationViewHolder

internal class ErrorViewHolder(parent: ViewGroup, barConfig: SimpleNotificationConfig) :
    SimpleNotificationViewHolder<SimpleNotificationArg.Error>(
        parent,
        R.layout.view_simple_notification_error,
        barConfig
    ) {
    override fun bindContent(item: SimpleNotificationArg) {
        if (item !is SimpleNotificationArg.Error) return
        itemView.findViewById<TextView>(R.id.txt_content)?.apply {
            text = item.content
        }
    }
}