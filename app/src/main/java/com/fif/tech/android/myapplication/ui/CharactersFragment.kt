package com.fif.tech.android.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.tech.android.myapplication.MyListAdapter
import com.fif.tech.android.myapplication.databinding.FragmentCharactersBinding
import com.fif.tech.android.myapplication.entities.ListResults
import com.fif.tech.android.myapplication.entities.People
import com.fif.tech.android.myapplication.network.RetrofitClient

class CharactersFragment: Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    val binding get() = _binding!!

    var data: ListResults<People>? = null
    lateinit var adapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyListAdapter(listOf())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            textView4.text = "StarWars List"
            myRecycler.adapter = adapter
            myRecycler.layoutManager = LinearLayoutManager(requireContext())
            button.setOnClickListener {
                // si data mo es null y si tiene next llamamos a next page
                data?.takeIf {it.next != null }?.let {
                    "\\d+".toRegex().find(data?.next?:"")?.value?.toInt()?.let {
                        fetchData(it)
                    }
                }
                if (data == null) {
                    fetchData()
                }
            }
        }
    }

    private fun fetchData(page: Int = 1) {
        lifecycleScope.launchWhenResumed {
            data = RetrofitClient.mySWClient.getPeople(page)
            data?.results?.let {
                adapter.update(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }
}