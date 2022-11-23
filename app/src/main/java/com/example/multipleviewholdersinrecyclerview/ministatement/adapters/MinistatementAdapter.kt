package com.example.multipleviewholdersinrecyclerview.ministatement.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.multipleviewholdersinrecyclerview.databinding.ItemAdapterMiniStatementBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemMinistatementLayoutBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemTitleLayoutBinding
import com.example.multipleviewholdersinrecyclerview.ministatement.MinistatementData
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_BODY
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_HEADER
import com.example.multipleviewholdersinrecyclerview.utils.formatDate
import java.util.*

class MinistatementAdapter() : //RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    ListAdapter<MinistatementData, ViewHolder>(
        DIFF_UTIL_RECENT
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                MinistatementViewHolder.TitleViewHolder(
                    ItemTitleLayoutBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            TYPE_BODY -> {
                MinistatementViewHolder.BodyViewHolder(
                    ItemMinistatementLayoutBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
                /*MinistatementViewHolder.BodyViewHolder(
                    ItemAdapterMiniStatementBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )*/
            }
            else -> throw IllegalArgumentException("Invalid ViewType Provided")

        }
    }

    private val model: ArrayList<MinistatementData> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is MinistatementViewHolder.TitleViewHolder -> {
                holder.bind(model[position] as MinistatementData.TitleData)
            }
            is MinistatementViewHolder.BodyViewHolder -> {
                holder.bind(model[position] as MinistatementData.LatestTransactionData)
            }
            else -> {}
        }
    }

    override fun getItemCount(): Int = model.size

    override fun getItemViewType(position: Int): Int {
        return when (model[position]) {
            is MinistatementData.TitleData -> TYPE_HEADER//R.layout.item_title_layout//TYPE_HEADER
            is MinistatementData.LatestTransactionData -> TYPE_BODY//R.layout.item_title_layout//TYPE_BODY
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }

    fun updateAllData(list: MutableList<MinistatementData>) {
        model.clear()
        model.addAll(list)
        notifyDataSetChanged()
    }


}


private val DIFF_UTIL_RECENT = object : DiffUtil.ItemCallback<MinistatementData>() {

    override fun areItemsTheSame(
        oldItem: MinistatementData,
        newItem: MinistatementData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MinistatementData,
        newItem: MinistatementData
    ): Boolean {
        return oldItem == newItem
    }

}

interface OnMultipleViewAdapterItemListener {
    fun onItemClicked(view: View, model: MinistatementData)
}

fun setMinistatementData(events: ArrayList<MinistatementData.LatestTransactionData>): MutableList<MinistatementData> {
    val listItem = arrayListOf<MinistatementData>()
    val mutableMap: MutableMap<String, MutableList<MinistatementData.LatestTransactionData>> =
        TreeMap()
    events.forEach { event ->
        var bodyDataMutableList: MutableList<MinistatementData.LatestTransactionData>? =
            mutableMap[formatDate(event.getDataTitle())]
        if (bodyDataMutableList == null) {
            bodyDataMutableList = ArrayList()
            mutableMap[formatDate(event.getDataTitle())] = bodyDataMutableList
        }
        bodyDataMutableList.add(event)
    }

    val assetMap: Map<String, List<MinistatementData.LatestTransactionData>?> = mutableMap
    Log.e(" : assetMap", assetMap.toString())


    for (date in assetMap.keys) {
        val titleData = MinistatementData.TitleData(date)
        listItem.add(titleData)
        for (event in assetMap[date]!!) {
            listItem.add(event)
            Log.e("bodyDataMutableList: 2 ", event.toString())
        }
    }
    return listItem
}