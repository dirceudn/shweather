package com.org.sweather.core.common

import io.github.aakira.napier.Napier

sealed class DefaultErrorEntity(
    open val throwable: Throwable? = null,
    open val message: String? = null,
) {
    data class Network(val error: String? = null, override val throwable: Throwable? = null) :
        DefaultErrorEntity(throwable, error) {
        init {
            Napier.e("Network error caught: ${throwable?.stackTraceToString()}")
        }
    }

    data class ErrorWithMessage(val error: String, override val throwable: Throwable? = null) :
        DefaultErrorEntity(throwable, error) {
        init {
            Napier.e("error caught: ${throwable?.stackTraceToString()}")
        }
    }

    data class Unknown(val error: String? = null, override val throwable: Throwable? = null) :
        DefaultErrorEntity(throwable, error) {
        init {
            Napier.e("Unknown error caught: ${throwable?.stackTraceToString()}")
        }
    }

    data class CheckInError(val error: String? = null) :
        DefaultErrorEntity(message = error) {
    }

    data class UnknownBusNetwork(val error: String? = null) :
        DefaultErrorEntity(message = error) {
    }

    data class UnknownBusLine(val error: String? = null) :
        DefaultErrorEntity(message = error) {
    }

    data class PermissionNotConfirmedError(val error: String? = null) :
        DefaultErrorEntity(message = error) {
    }

    data class CityNotFound(val error: String? = null) :
        DefaultErrorEntity(message = error) {
    }

    data class FirebaseError(override val throwable: Throwable? = null) :
        DefaultErrorEntity(throwable = throwable) {
        init {
            Napier.e("firebase error caught: ${throwable?.stackTraceToString()}")
        }
    }
}
