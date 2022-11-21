package com.example.multipleviewholdersinrecyclerview.multiplview

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

object OfflineDataSource {

    const val TYPE_HEADER = 0
    const val TYPE_BODY = 1

    fun getBodyData(): ArrayList<MultipleViewData.BodyData> {
        val itemList = arrayListOf<MultipleViewData.BodyData>()
        itemList.add(MultipleViewData.BodyData(1, "Daniel"))
        itemList.add(MultipleViewData.BodyData(2, "Betty"))
        itemList.add(MultipleViewData.BodyData(3, "Daniel"))
        itemList.add(MultipleViewData.BodyData(4, "Migwi"))
        itemList.add(MultipleViewData.BodyData(5, "Cahlady"))
        itemList.add(MultipleViewData.BodyData(6, "Migwi"))
        itemList.add(MultipleViewData.BodyData(7, "Njeri"))
        itemList.add(MultipleViewData.BodyData(8, "Magda"))
        return itemList
    }


    fun setMultipleViewData(events: ArrayList<MultipleViewData.BodyData>): List<MultipleViewData> {
        val listItem = arrayListOf<MultipleViewData>()
        val mutableMap: MutableMap<String, MutableList<MultipleViewData.BodyData>> = TreeMap()
        events.forEach{event->
            var bodyDataMutableList: MutableList<MultipleViewData.BodyData>? =
                mutableMap[event.getDataTitle()]
            if (bodyDataMutableList == null) {
                bodyDataMutableList = ArrayList()
                mutableMap[event.getDataTitle()] = bodyDataMutableList
            }
            bodyDataMutableList.add(event)
        }

        val assetMap: Map<String, List<MultipleViewData.BodyData>?> = mutableMap
        Log.e(" : assetMap", assetMap.toString())


        for (date in assetMap.keys) {
            val titleData = MultipleViewData.TitleData(date)
            listItem.add(titleData)
            for (event in assetMap[date]!!) {
                listItem.add(event)
                Log.e("bodyDataMutableList: 2 ", event.toString())
            }
        }
        return listItem
    }
}