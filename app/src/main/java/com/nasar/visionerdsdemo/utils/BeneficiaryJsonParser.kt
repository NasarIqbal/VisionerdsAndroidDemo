package com.nasar.visionerdsdemo.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasar.visionerdsdemo.model.Beneficiary
import java.io.IOException

object BeneficiaryJsonParser {
    fun parseJson(context: Context,fileName:String): ArrayList<Beneficiary>? {
        return try {
            val inputStream = context.assets.open(fileName)
            val reader = inputStream.reader()

            val gson = Gson()
            val listType = object : TypeToken<ArrayList<Beneficiary>>() {}.type
            gson.fromJson(reader, listType)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}