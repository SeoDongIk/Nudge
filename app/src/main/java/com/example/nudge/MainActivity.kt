package com.example.nudge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.StashEntity
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

        // Basic

        val Fragment4231 = Fragment4231()
        val Fragment433 = Fragment433()
        val Fragment343 = Fragment343()

        // Click Listener

        binding.uploadPlayer.setOnClickListener {
            val intent = Intent(baseContext, UploadActivity::class.java)
            startActivity(intent)
        }

        binding.saveSquad.setOnClickListener {
            if(viewModel.stashList.value != null){
                for(stashEntity in viewModel.stashList.value!!){
                    viewModel.insertData(stashEntity.position, stashEntity.formation, stashEntity.name, stashEntity.key)
                }
                viewModel.getData()
                viewModel.removeStashData()
            }
        }

        viewModel.squadList.observeForever {
            viewModel.getData()
        }

        binding.loadSquad.setOnClickListener {
            val bundle : Bundle = Bundle()

            var image_list = ArrayList<String>()
            image_list.add(0, "test")
            for(squadEntity in viewModel.squadList.value!!){
                image_list.add(squadEntity.position, squadEntity.key)
            }
            bundle.putStringArrayList("message", image_list)
            if(viewModel.squadList.value!!.get(1).formation == 4231){
                Toast.makeText(baseContext, "1", Toast.LENGTH_SHORT).show()
                Fragment4231.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment4231).commit()
            }
            if(viewModel.squadList.value!!.get(1).formation == 433){
                Fragment433.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment433).commit()
            }
            if(viewModel.squadList.value!!.get(1).formation == 343){
                Fragment343.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment343).commit()
            }

        }

        // Spinner + Fragment

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("4231", "433", "343"))

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

    override fun sendMessage(message: StashEntity) {
        Log.d("log", message.toString())
        viewModel.insertStashData(message.position, message.formation, message.name, message.key)
        viewModel.getStashData()
    }

}