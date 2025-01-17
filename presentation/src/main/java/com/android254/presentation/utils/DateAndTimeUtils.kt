/*
 * Copyright 2023 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.presentation.utils

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.getTimeDifference(): String {
    return try {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val timePosted = dateFormat.parse(this)
        val currentTime = Date()

        val timeDifference = currentTime.time - timePosted.time

        val minutesDifference = timeDifference / (1000 * 60)
        if (minutesDifference <= 60) {
            "$minutesDifference mins ago"
        } else {
            "${minutesDifference / 60} hours ago"
        }
    } catch (e: Exception) {
        Timber.e(e)
        this
    }
}