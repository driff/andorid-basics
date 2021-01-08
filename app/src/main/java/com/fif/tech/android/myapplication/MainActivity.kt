package com.fif.tech.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.tech.android.myapplication.databinding.ActivityMainBinding
import com.fif.tech.android.myapplication.entities.ListResults
import com.fif.tech.android.myapplication.entities.People
import com.fif.tech.android.myapplication.network.RetrofitClient

class MainActivity : AppCompatActivity(R.layout.activity_main)