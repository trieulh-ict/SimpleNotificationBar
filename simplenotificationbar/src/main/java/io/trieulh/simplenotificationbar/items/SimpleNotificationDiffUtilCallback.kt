package io.trieulh.simplenotificationbar.items

import androidx.recyclerview.widget.DiffUtil

internal class SimpleNotificationDiffUtilCallback :
    DiffUtil.ItemCallback<SimpleNotificationItem>() {

    override fun areItemsTheSame(oldItem: SimpleNotificationItem, newItem: SimpleNotificationItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: SimpleNotificationItem,
        newItem: SimpleNotificationItem
    ) =
        oldItem.id == newItem.id
}
