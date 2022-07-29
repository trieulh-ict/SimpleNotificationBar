package io.trieulh.simplenotificationbar

/**
 * @property maxCount Maximum number of notification displayed on screen
 * @property duration Duration before Notification is dismissed automatically
 */
data class SimpleNotificationConfig(
    val maxCount: Int = 3,
    val duration: Long = DURATION_DEFAULT,
) {

    companion object {
        const val DURATION_DEFAULT = 3000L
        const val DURATION_LONG = 5000L
        const val DURATION_SHORT = 1500L

        const val MINIMUM_SWIPE_DISTANCE = 300F
    }
}
