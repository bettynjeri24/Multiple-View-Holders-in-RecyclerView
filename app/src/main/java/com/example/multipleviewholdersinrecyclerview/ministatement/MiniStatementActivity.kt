package com.example.multipleviewholdersinrecyclerview.ministatement

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleviewholdersinrecyclerview.databinding.ActivityMiniStatementBinding
import com.example.multipleviewholdersinrecyclerview.ministatement.adapters.MinistatementAdapter
import com.example.multipleviewholdersinrecyclerview.ministatement.adapters.setMinistatementData

class MiniStatementActivity : AppCompatActivity() {
    private val ministatementAdapter by lazy { MinistatementAdapter() }
    private lateinit var binding: ActivityMiniStatementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMiniStatementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ministatementAdapter.updateAllData(setMinistatementData(getLatestTransactionData()))


        inflateRecyclerView()
    }


    private fun inflateRecyclerView(itemsRV: List<MinistatementData>? = null) {

        binding.tvWhenEmpty.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this.context!!)
            adapter = ministatementAdapter
            setHasFixedSize(true)
        }
        // }
    }
}