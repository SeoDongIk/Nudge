package com.example.nudge

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nudge.Entity.PlayerData
import com.example.nudge.Entity.PlayerEntity
import com.example.nudge.databinding.ActivitySelectBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SelectActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var selectRecyclerViewAdapter: SelectRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        // RecyclerView

        val selectrecyclerview = binding.selectRecyclerView
        selectRecyclerViewAdapter = SelectRecyclerViewAdapter(baseContext)
        selectrecyclerview.adapter = selectRecyclerViewAdapter
        selectrecyclerview.layoutManager = LinearLayoutManager(baseContext)

        viewModel.getPlayerData().observe(this, Observer {
            selectRecyclerViewAdapter.setPlayerList(it)
            selectRecyclerViewAdapter.notifyDataSetChanged()
        })

        // Click Listener

        val position = intent.getIntExtra("position",1)

        selectRecyclerViewAdapter.itemClick = object : SelectRecyclerViewAdapter.ItemClick{
            override fun onClick(view: View, item: PlayerEntity) {
                intent.putExtra("name", item.name)
                intent.putExtra("key",item.imageUrl)
                intent.putExtra("position", position)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }
}