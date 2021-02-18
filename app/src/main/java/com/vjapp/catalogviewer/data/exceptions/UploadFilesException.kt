package com.vjapp.catalogviewer.data.exceptions

class UploadFilesException(cause: Throwable?) : Exception(cause) {
    constructor() : this(null)
}