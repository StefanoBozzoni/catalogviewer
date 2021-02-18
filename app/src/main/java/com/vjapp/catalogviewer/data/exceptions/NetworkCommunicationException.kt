package com.vjapp.catalogviewer.data.exceptions

class NetworkCommunicationException(cause: Throwable?) : Exception(cause) {
    constructor() : this(null)
}