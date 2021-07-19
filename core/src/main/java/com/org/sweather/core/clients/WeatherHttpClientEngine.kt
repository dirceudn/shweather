package com.org.sweather.core.clients

import io.ktor.client.*

val httpClientEngine = HttpClient() {
    engine {
        // Configure an engine
    }
}