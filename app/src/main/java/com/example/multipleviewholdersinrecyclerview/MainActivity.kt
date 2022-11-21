package com.example.multipleviewholdersinrecyclerview

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleviewholdersinrecyclerview.databinding.ActivityMainBinding
import com.example.multipleviewholdersinrecyclerview.multiplview.MultipleViewAdapter
import com.example.multipleviewholdersinrecyclerview.multiplview.MultipleViewData
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_BODY
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.TYPE_HEADER
import com.example.multipleviewholdersinrecyclerview.multiplview.OfflineDataSource.getBodyData
import com.example.multipleviewholdersinrecyclerview.multiplview.setMultipleViewData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val multipleViewAdapter by lazy { MultipleViewAdapter() }

    // private lateinit var multipleViewAdapter: MultipleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val multipleViewData = OfflineDataSource.getData()


        // multipleViewAdapter = MultipleViewAdapter()
        // Log.e("M_ACTIVITY", "${multipleViewData}")
        multipleViewAdapter.updateAllData(setMultipleViewData(getBodyData()))



        inflateRecyclerView()


    }


    private fun inflateRecyclerView(itemsRV:List<MultipleViewData>? = null) {
        /* if (itemsRV!!.isEmpty()) {
             binding.tvWhenEmpty.visibility = View.VISIBLE
             binding.recyclerView.visibility = View.GONE
         } else {*/
        val spanCount =
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3
        val gridlayoutManager = GridLayoutManager(this, spanCount)
        gridlayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (multipleViewAdapter.getItemViewType(position)) {
                    TYPE_HEADER -> gridlayoutManager.spanCount
                    else -> TYPE_BODY
                }
            }
        }
        binding.tvWhenEmpty.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this.context!!)//gridlayoutManager//LinearLayoutManager(this.context!!)
            adapter = multipleViewAdapter
            setHasFixedSize(true)
        }
        // }
    }
}