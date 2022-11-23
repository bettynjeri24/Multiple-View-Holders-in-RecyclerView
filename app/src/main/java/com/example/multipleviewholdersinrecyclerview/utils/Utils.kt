package com.example.multipleviewholdersinrecyclerview.utils

import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(dateGiven: String?): String {
    var returnString: String
    try {
        val sourceDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val date = sourceDateFormat.parse("${dateGiven.toString()}Z")
        //val targetDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val targetDateFormat = SimpleDateFormat("dd-MM-yyyy")
        println(targetDateFormat.format(date))
        returnString = targetDateFormat.format(date)
    } catch (e: ParseException) {
        returnString = dateGiven.toString()
        e.printStackTrace()
    }
    return returnString

}

fun cashFormatter(cash: String): String {
    var str: String
    val amountUnformated = cash.toDouble()
    val COUNTRY = "KE" // CI for Côte d'Ivoire
    val LANGUAGE = "en" // fr for french language
    str = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(amountUnformated)
   /* if (str.contains(",")) {
        str = str.replace(",", ".")
    }*/
    return str
}

