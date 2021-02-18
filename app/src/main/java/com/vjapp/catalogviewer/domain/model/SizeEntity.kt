package com.vjapp.catalogviewer.domain.model


import com.google.gson.annotations.SerializedName

data class SizeEntity(
    val id: Int,
    val name: String,
    val isoTwoLetterCountryCode: String,
    val defaultSizeLabel: String,
    val alternativeSizeLabel: String
)