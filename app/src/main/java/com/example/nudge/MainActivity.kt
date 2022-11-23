package com.example.nudge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.FormationFragment.Fragment343
import com.example.nudge.FormationFragment.Fragment4231
import com.example.nudge.FormationFragment.Fragment433
import com.example.nudge.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SendEventListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        // Click Listener

        binding.uploadPlayer.setOnClickListener {
            val intent = Intent(baseContext, UploadActivity::class.java)
            startActivity(intent)
        }

        binding.saveSquad.setOnClickListener {
            viewModel.removeStashData()
        }

        binding.loadSquad.setOnClickListener {
            viewModel.getStashData()
            Log.d("viewModel", viewModel.stashList.value.toString())
        }

        // Spinner + Fragment

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("4231", "433", "343"))

        val Fragment4231 = Fragment4231()
        val Fragment433 = Fragment433()
        val Fragment343 = Fragment343()

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment4231).commit()
                }
                if(p2 == 1){
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment433).commit()
                }
                if(p2 == 2){
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment343).commit()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    override fun sendMessage(message: SquadEntity) {
        Log.d("log", message.toString())
        viewModel.insertStashData(message.formation, message.position, message.name, message.key)
    }

}