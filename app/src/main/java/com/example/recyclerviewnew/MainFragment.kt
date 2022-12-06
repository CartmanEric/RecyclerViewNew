package com.example.recyclerviewnew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewnew.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var rvAdapter: ItemAdapter
    private val itemList = mutableListOf<Items>(
    )

    init {
        for (i in 0 until 10) {
            val item = Items("Name $i", i)
            itemList.add(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
        rvAdapter.submitList(itemList)
        rvAdapter.onItemClickListener = {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(it))
        }
    }

    private fun initRV() {
        val rv = binding.rv
        rvAdapter = ItemAdapter()
        rv.adapter = rvAdapter
    }

}