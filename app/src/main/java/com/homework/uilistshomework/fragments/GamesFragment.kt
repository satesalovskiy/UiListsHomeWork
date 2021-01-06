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
import com.homework.uilistshomework.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {

    private val binding: FragmentGamesBinding by lazy {
        val tmpBinding = FragmentGamesBinding.inflate(layoutInflater)
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
            val firstList = DataUtils.getThirdTypeData(requireContext())
            val secondList = DataUtils.getSecondTypeData(requireContext())
            val resultList: MutableList<Item> = mutableListOf()
            resultList.addAll(secondList)
            resultList.addAll(firstList)
            resultList.shuffle()

            list = resultList
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}