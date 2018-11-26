package com.appnroll.recruitment.utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat

const val DATE_PATTERN = "dd.MM.yyyy HH:mm:ss"

fun getFormatedStringFromDate(date: DateTime) = DateTimeFormat
        .forPattern(DATE_PATTERN)
        .print(date.withZone(DateTimeZone.getDefault()).toLocalDateTime())
