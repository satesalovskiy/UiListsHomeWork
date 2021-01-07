package com.homework.uilistshomework.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
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

    private val filmsLiveData: MutableLiveData<List<Item.Film>> = MutableLiveData()

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filmsLiveData.value = getData()
    }

    @ExperimentalStdlibApi
    private fun getData(): MutableList<Item.Film> {
        val resultList: MutableList<Item.Film> = mutableListOf()
        resultList.apply {
            addAll(DataUtils.getFirstTypeData(requireContext()))
            addAll(DataUtils.getFirstTypeData(requireContext()))
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

        binding.recyclerView.adapter = MainRecyclerAdapter { item ->
            removeItem(item)
        }.apply {
            filmsLiveData.observe(viewLifecycleOwner) {
                submitList(it)
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun removeItem(item: Item) {
        val oldValue = filmsLiveData.value
        filmsLiveData.value = oldValue?.toMutableList()?.apply {
            remove(item)
        }
    }
}