package com.fif.tech.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.tech.android.myapplication.databinding.ActivityMainBinding
import com.fif.tech.android.myapplication.entities.ListResults
import com.fif.tech.android.myapplication.entities.People
import com.fif.tech.android.myapplication.network.RetrofitClient

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var data: ListResults<People>? = null
    lateinit var adapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MyListAdapter(listOf())
        binding.apply {
            textView4.text = "StarWars List"
            myRecycler.adapter = adapter
            myRecycler.layoutManager = LinearLayoutManager(baseContext)
        }
    }

    override fun onResume() {
        binding.button.setOnClickListener {
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
        super.onResume()
    }

    private fun fetchData(page: Int = 1) {
        lifecycleScope.launchWhenResumed {
            data = RetrofitClient.mySWClient.getPeople(page)
            data?.results?.let {
                adapter.update(it)
            }
        }
    }

}