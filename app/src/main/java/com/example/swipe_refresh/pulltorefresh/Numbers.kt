package com.example.swipe_refresh.pulltorefresh

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swipe_refresh.databinding.FragmentNumbersBinding

class Numbers : Fragment() {
    //adapter
    private var adapter: RecyclerView.Adapter<NumbersRecyclerViewAdapter.ViewHolder>? = null

    //view binding
    private var _binding: FragmentNumbersBinding? = null
    private val binding get() = _binding!!

    //numbers stuff
    var totalNumbers = mutableListOf<Int>()
    var count = 1

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNumbersBinding.inflate(inflater, container, false)

        //adding first number automatically
        addNumbers()

        //setting recycler view
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adapter = NumbersRecyclerViewAdapter(totalNumbers)
        binding.recyclerview.adapter = adapter

        //on swipe refresh
        binding.swipeRefreshLayout.setOnRefreshListener {
            //adding one number from bottom and notifying recycler
            addNumbers()
            (adapter as NumbersRecyclerViewAdapter).notifyDataSetChanged()
            if (binding.swipeRefreshLayout.isRefreshing)
                binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    //add numbers function
    private fun addNumbers() {
        totalNumbers.add(count++)
    }

}