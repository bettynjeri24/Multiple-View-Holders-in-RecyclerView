package com.example.multipleviewholdersinrecyclerview.multiplview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemBodyLayoutBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemTitleLayoutBinding

sealed class MultipleViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: ItemTitleLayoutBinding) :
        MultipleViewHolder(binding) {
        fun bind(model: MultipleViewData.TitleData) {
            binding.textViewTitle.text = model.title
        }
    }

    class BodyViewHolder(private val binding: ItemBodyLayoutBinding) :
        MultipleViewHolder(binding) {
        fun bind(model: MultipleViewData.BodyData) {
            binding.textViewTitle.text = model.description
        }
    }

}
