package com.example.multipleviewholdersinrecyclerview.multiplview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.multipleviewholdersinrecyclerview.databinding.ItemBodyLayoutBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemTitleLayoutBinding
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_BODY
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_HEADER
import java.util.*
import kotlin.collections.ArrayList

class MultipleViewAdapter() : //RecyclerView.Adapter<RecyclerView.ViewHolder>() {
     ListAdapter<MultipleViewData, ViewHolder>(
         DIFF_UTIL_RECENT
     ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                MultipleViewHolder.TitleViewHolder(
                    ItemTitleLayoutBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            TYPE_BODY -> {
                MultipleViewHolder.BodyViewHolder(
                    ItemBodyLayoutBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid ViewType Provided")

        }
    }

    private val model: ArrayList<MultipleViewData> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is MultipleViewHolder.TitleViewHolder -> {
                holder.bind(model[position] as MultipleViewData.TitleData)
            }
            is MultipleViewHolder.BodyViewHolder -> {
                holder.bind(model[position] as MultipleViewData.BodyData)
            }
            else -> {}
        }
    }

    override fun getItemCount(): Int = model.size

    override fun getItemViewType(position: Int): Int {
        return when (model[position]) {
            is MultipleViewData.TitleData -> TYPE_HEADER//R.layout.item_title_layout//TYPE_HEADER
            is MultipleViewData.BodyData -> TYPE_BODY//R.layout.item_title_layout//TYPE_BODY
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }

    fun updateAllData(list: MutableList<MultipleViewData>) {
        model.clear()
        model.addAll(list)
        notifyDataSetChanged()
    }


}


private val DIFF_UTIL_RECENT = object : DiffUtil.ItemCallback<MultipleViewData>() {
    override fun areItemsTheSame(
        oldItem: MultipleViewData,
        newItem: MultipleViewData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MultipleViewData,
        newItem: MultipleViewData
    ): Boolean {
        return oldItem == newItem
    }

}

interface OnMultipleViewAdapterItemListener {
    fun onItemClicked(view: View, model: MultipleViewData)
}

fun setMultipleViewData(events: ArrayList<MultipleViewData.BodyData>): MutableList<MultipleViewData> {
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