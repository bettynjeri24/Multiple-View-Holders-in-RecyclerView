package com.example.multipleviewholdersinrecyclerview.multiplview

import java.text.SimpleDateFormat
import java.util.*


val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
val currentDate = sdf.format(Date())


sealed class MultipleViewData {
    data class TitleData(
        val title: String
    ) : MultipleViewData()

    class BodyData(
        val id: Int,
        title: String,
        val description: String? = "Multiple View Holders in RecyclerView with Data Binding - Android Studio (Kotlin)",
        val release_date: String = "DATE ${currentDate.toString()}"
    ) : MultipleViewData() {
        private val title = title
        fun getDataTitle(): String {
            return title
        }

//        override fun toString(): String {
//            return title
//        }
    }

    data class LatestTransactionData(
        var id: Int, // 68
        var sendorwalletid: String? = " 3818ad25-50b0-4590-9ba6-00a036501fa6", // 3818ad25-50b0-4590-9ba6-00a036501fa6
        var recipientwalletid: String? = "0ac3e245-1b0f-4e3e-a14d-dd2aec3260a6", // 0ac3e245-1b0f-4e3e-a14d-dd2aec3260a6
        var sendorwalletaccnumber: String? = "5169-6414-4523", // 5169-6414-4523
        var recipientwalletaccnumber: String? = "7732-2845-1168", // 7732-2845-1168
        var sendoraccountbalance: Int? = 6100, // 6100
        var recipientaccountbalance: Int? = 7600, // 7600
        var datecreated: String? = "2022-05-18T22:39:32.13", // 2022-05-18T22:39:32.13
        var sendoruserid: String? = "7ec59e64-ab97-4dd5-aecb-319cb73c455c", // 7ec59e64-ab97-4dd5-aecb-319cb73c455c
        var recipientuserid: String? = "304a3280-a0bd-4635-a69b-c8c5b6401696", // 304a3280-a0bd-4635-a69b-c8c5b6401696
        var walletTransactionType: Int? = 1, // 1
        var sendorPhoneNumber: String? = "2250701686379", // 2250701686379
        var recipientPhoneNumber: String? = "2250703035850", // 2250703035850
        var status: Boolean? = true, // true
        var transactiontype: Int? = 1, // 1
        var reasons: String? = " send", // send
        var amount: String? = "200", // 200
        var unixtimestamp: Int? = 1652902772, // 1652902772
        var recipientName: String? = "oscar muigai", // oscar muigai
        var sendorName: String? = "brice kanute", // brice kanute
        var transactionCode: String? = "X5KQYANND1VP", // X5KQYANND1VP
        var farmForceReferenceCode: String? = "" // null
    ) : MultipleViewData()
}