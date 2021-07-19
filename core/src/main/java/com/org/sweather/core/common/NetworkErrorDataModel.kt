package com.org.sweather.core.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkErrorNetworkModel(
    @SerialName("error")
    val error: String
)

