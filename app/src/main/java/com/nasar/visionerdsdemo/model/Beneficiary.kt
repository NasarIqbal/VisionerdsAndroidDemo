package com.nasar.visionerdsdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beneficiary(
    val beneType: String, // Spouse
    val beneficiaryAddress: BeneficiaryAddress,
    val dateOfBirth: String, // 04201979
    val designationCode: String, // P
    val firstName: String, // John
    val lastName: String, // Smith
    val middleName: String, // D
    val phoneNumber: String, // 3035555555
    val socialSecurityNumber: String // XXXXX3333
) : Parcelable