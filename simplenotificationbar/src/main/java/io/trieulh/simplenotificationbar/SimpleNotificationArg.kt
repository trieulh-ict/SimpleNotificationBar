package io.trieulh.simplenotificationbar

import io.trieulh.simplenotificationbar.items.SimpleNotificationItem

/**
 * @property content The displayed String content
 * @property type Type of the Notification View. Currently only support SUCCESS type
 */
data class SimpleNotificationArg(
    val content: String = "",
    val type: SimpleNotificationType = SimpleNotificationType.Success,
) {

    fun buildItem(): SimpleNotificationItem {
        return when (type) {
            SimpleNotificationType.Success -> buildSuccessItem()
            SimpleNotificationType.Error -> buildErrorItem()
            SimpleNotificationType.Warning -> buildWarningItem()
        }
    }

    private fun buildWarningItem(): SimpleNotificationItem =
        SimpleNotificationItem.Warning(itemId = System.currentTimeMillis(), content = content)

    private fun buildErrorItem(): SimpleNotificationItem =
        SimpleNotificationItem.Error(itemId = System.currentTimeMillis(), content = content)

    private fun buildSuccessItem() =
        SimpleNotificationItem.Success(itemId = System.currentTimeMillis(), content = content)
}