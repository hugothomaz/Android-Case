package com.hugothomaz.domain.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.localString(): String {
    return toStringFormat("dd/MM/yyyy")
}

fun Date.localDateHourString(): String {
    return toStringFormat("dd/MM/yyyy HH:mm:ss")
}

fun Date.localHourString(): String {
    return toStringFormat("HH:mm").replace(":", "h")
}

fun Date.localTime(): String {
    return toStringFormat("HH:mm")
}

infix fun Date.toStringFormat(format: String): String {
    return SimpleDateFormat(
        format,
        Locale("pt", "BR")
    ).format(this)
}
