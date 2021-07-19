package com.org.sweather.core.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun debounce(
    waitMs: Long = 300L,
    scope: CoroutineScope,
    destinationFunction: suspend () -> Unit

) {
    var debounceJob: Job? = null
    debounceJob?.cancel()
    debounceJob = scope.launch {
        delay(waitMs)
        destinationFunction()
    }
}