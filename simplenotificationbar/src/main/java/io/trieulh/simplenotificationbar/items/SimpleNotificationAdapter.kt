package io.trieulh.simplenotificationbar.items

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.SimpleNotificationType
import io.trieulh.simplenotificationbar.helper.SimpleItemTouchHelperAdapter
import io.trieulh.simplenotificationbar.items.viewholder.ErrorViewHolder
import io.trieulh.simplenotificationbar.items.viewholder.SuccessViewHolder
import io.trieulh.simplenotificationbar.items.viewholder.WarningViewHolder

internal class SimpleNotificationAdapter(private val barConfig: SimpleNotificationConfig) :
    ListAdapter<SimpleNotificationItem, SimpleNotificationViewHolder<SimpleNotificationItem>>(
        SimpleNotificationDiffUtilCallback()
    ), SimpleItemTouchHelperAdapter {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimpleNotificationViewHolder<SimpleNotificationItem> {
        return when (SimpleNotificationType.getTypeByInt(viewType)) {
            SimpleNotificationType.Success -> SuccessViewHolder(parent, barConfig)
            SimpleNotificationType.Error -> ErrorViewHolder(parent, barConfig)
            SimpleNotificationType.Warning -> WarningViewHolder(parent, barConfig)
        }
    }

    override fun onBindViewHolder(
        holder: SimpleNotificationViewHolder<SimpleNotificationItem>,
        position: Int
    ) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            submitList(currentList.filter {
                it.id != item.id
            })
        }
        holder.bindItem(item)
    }

    override fun onViewRecycled(holder: SimpleNotificationViewHolder<SimpleNotificationItem>) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item.type.value
    }

    override fun onItemDismiss(position: Int) {
        submitList(currentList.filterIndexed { index, _ ->
            index != position
        })
    }
}