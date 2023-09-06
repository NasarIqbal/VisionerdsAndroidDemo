package com.nasar.visionerdsdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BeneficiaryAddress(
    val city: String, // Greenwood Village
    val country: String, // US
    val firstLineMailing: String, // 8515 E Orchard Rd
    val scndLineMailing: String, // null
    val stateCode: String, // CO
    val zipCode: String // 80111
) : Parcelable