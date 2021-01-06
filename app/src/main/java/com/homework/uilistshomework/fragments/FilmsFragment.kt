package com.homework.uilistshomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.uilistshomework.DataUtils
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.MainRecyclerAdapter
import com.homework.uilistshomework.databinding.FragmentFilmsBinding

class FilmsFragment : Fragment() {

    private val binding: FragmentFilmsBinding by lazy {
        val tmpBinding = FragmentFilmsBinding.inflate(layoutInflater)
        tmpBinding
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    @ExperimentalStdlibApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = MainRecyclerAdapter().apply {
            list = mutableListOf<Item>().apply {
                addAll(DataUtils.getFirstTypeData(requireContext()))
                addAll(DataUtils.getFirstTypeData(requireContext()))
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}