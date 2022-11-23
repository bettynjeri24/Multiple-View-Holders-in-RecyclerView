package com.example.multipleviewholdersinrecyclerview.ministatement.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemAdapterMiniStatementBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemMinistatementLayoutBinding
import com.example.multipleviewholdersinrecyclerview.databinding.ItemTitleLayoutBinding
import com.example.multipleviewholdersinrecyclerview.ministatement.MinistatementData
import com.example.multipleviewholdersinrecyclerview.utils.cashFormatter

sealed class MinistatementViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: ItemTitleLayoutBinding) :
        MinistatementViewHolder(binding) {
        fun bind(model: MinistatementData.TitleData) {
            binding.textViewTitle.text = model.title
        }
    }

    class BodyViewHolder(private val binding: ItemMinistatementLayoutBinding) :
        MinistatementViewHolder(binding) {
        fun bind(model: MinistatementData.LatestTransactionData) {
            binding.tVTitleMiniStatement.text = model.recipientName
            binding.tVMiniStatementAmount.text = cashFormatter(model.amount.toString())
            binding.tVAccountNumber.text = model.recipientPhoneNumber
            binding.tVMiniStatementDateTime.text = model.reasons
        }
    }
    /*class BodyViewHolder(private val binding: ItemAdapterMiniStatementBinding) :
        MinistatementViewHolder(binding) {
        fun bind(model: MinistatementData.LatestTransactionData) {
            binding.tvReceiverName.text = model.recipientName
            binding.tvAmount.text = model.amount
            binding.tvAccountNo.text = model.recipientName
            binding.tvAccountNo.text = model.recipientPhoneNumber
            binding.tvDescription.text = model.reasons
        }
    }*/

}
