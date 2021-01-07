package com.homework.uilistshomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
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

    private val gamesLiveData: MutableLiveData<List<Item>> = MutableLiveData()

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gamesLiveData.value = getData()
    }

    @ExperimentalStdlibApi
    private fun getData(): MutableList<Item> {
        val resultList: MutableList<Item> = mutableListOf()
        resultList.apply {
            addAll(DataUtils.getSecondTypeData(requireContext()))
            addAll(DataUtils.getThirdTypeData(requireContext()))
            shuffle()
        }
        return resultList
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

        binding.recyclerView.adapter = MainRecyclerAdapter(null).apply {
            gamesLiveData.observe(viewLifecycleOwner) {
                submitList(it)
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}