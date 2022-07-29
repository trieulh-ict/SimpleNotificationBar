package io.trieulh.simplenotificationbar

import android.graphics.drawable.Drawable

sealed class SimpleNotificationArg(
    val id: Long = System.currentTimeMillis(),
    val type: SimpleNotificationType = SimpleNotificationType.Success
) {
    class Success(val itemId: Long? = null, val content: String) : SimpleNotificationArg(
        id = itemId ?: System.currentTimeMillis(),
        type = SimpleNotificationType.Success
    )

    class Error(val itemId: Long? = null, val content: String) : SimpleNotificationArg(
        id = itemId ?: System.currentTimeMillis(),
        type = SimpleNotificationType.Error
    )

    class Warning(val itemId: Long? = null, val content: String) : SimpleNotificationArg(
        id = itemId ?: System.currentTimeMillis(),
        type = SimpleNotificationType.Warning
    )

    class Custom(
        val itemId: Long? = null,
        val content: String,
        val additionalArg: CustomSimpleNotificationArg
    ) : SimpleNotificationArg(
        id = itemId ?: System.currentTimeMillis(),
        type = SimpleNotificationType.Custom
    )
}

data class CustomSimpleNotificationArg(
    val iconDrawable: Drawable? = null,
    val backgroundDrawable: Drawable? = null
)
