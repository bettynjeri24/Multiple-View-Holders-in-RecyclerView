package com.example.multipleviewholdersinrecyclerview.ministatement


sealed class MinistatementData {
    data class TitleData(
        val title: String
    ) : MinistatementData()


    class LatestTransactionData(
        var id: Int, // 68
        var sendorwalletid: String? = " 3818ad25-50b0-4590-9ba6-00a036501fa6", // 3818ad25-50b0-4590-9ba6-00a036501fa6
        var recipientwalletid: String? = "0ac3e245-1b0f-4e3e-a14d-dd2aec3260a6", // 0ac3e245-1b0f-4e3e-a14d-dd2aec3260a6
        var sendorwalletaccnumber: String? = "5169-6414-4523", // 5169-6414-4523
        var recipientwalletaccnumber: String? = "7732-2845-1168", // 7732-2845-1168
        var sendoraccountbalance: Int? = 6100, // 6100
        var recipientaccountbalance: Int? = 7600, // 7600
        var datecreated: String, // 2022-05-18T22:39:32.13
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
    ) : MinistatementData() {
        private val title = datecreated.toString()
        fun getDataTitle(): String {
            return title
        }
    }
}


fun getLatestTransactionData(): ArrayList<MinistatementData.LatestTransactionData> {
    val itemList = arrayListOf<MinistatementData.LatestTransactionData>()
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 1,
            datecreated = "2022-11-22T23:31:21.593"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 2,
            datecreated = "2022-11-23T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 3,
            datecreated = "2022-11-23T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 4,
            datecreated = "2022-11-22T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 5,
            datecreated = "2022-11-22T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 6,
            datecreated = "2022-11-25T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 7,
            datecreated = "2022-11-25T23:36:59.02"
        )
    )
    itemList.add(
        MinistatementData.LatestTransactionData(
            id = 8,
            datecreated = "2022-11-26T23:36:59.02"
        )
    )
    return itemList
}