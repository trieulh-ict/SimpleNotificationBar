package io.trieulh.simplenotificationbar

enum class SimpleNotificationType(val value: Int) {
    // More type will be added later (eg. Error, Warning, Information...)
    Success(1),
    Error(2),
    Warning(3);

    companion object {
        fun getTypeByInt(valueInt: Int): SimpleNotificationType = values().firstOrNull {
            it.value == valueInt
        } ?: Success
    }
}
