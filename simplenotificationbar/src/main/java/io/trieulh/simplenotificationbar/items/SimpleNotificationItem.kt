package io.trieulh.simplenotificationbar.items

import io.trieulh.simplenotificationbar.SimpleNotificationType

sealed class SimpleNotificationItem(
    val id: Long = System.currentTimeMillis(),
    val type: SimpleNotificationType = SimpleNotificationType.Success
) {
    class Success(val itemId: Long, val content: String) : SimpleNotificationItem(
        id = itemId,
        type = SimpleNotificationType.Success
    )

    class Error(val itemId: Long, val content: String) : SimpleNotificationItem(
        id = itemId,
        type = SimpleNotificationType.Error
    )

    class Warning(val itemId: Long, val content: String) : SimpleNotificationItem(
        id = itemId,
        type = SimpleNotificationType.Warning
    )
}