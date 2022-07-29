package io.trieulh.simplenotificationbar.items

import androidx.recyclerview.widget.DiffUtil
import io.trieulh.simplenotificationbar.SimpleNotificationArg

internal class SimpleNotificationDiffUtilCallback :
    DiffUtil.ItemCallback<SimpleNotificationArg>() {

    override fun areItemsTheSame(oldItem: SimpleNotificationArg, newItem: SimpleNotificationArg) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: SimpleNotificationArg,
        newItem: SimpleNotificationArg
    ) =
        oldItem.id == newItem.id
}
