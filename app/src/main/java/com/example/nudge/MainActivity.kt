package com.example.nudge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkManager
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.StashEntity
import com.example.nudge.FormationFragment.Fragment343
import com.example.nudge.FormationFragment.Fragment4231
import com.example.nudge.FormationFragment.Fragment433
import com.example.nudge.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

        // Init

        viewModel.removeStashData()
        viewModel.getData()

        // Click Listener

        binding.uploadPlayer.setOnClickListener {
            val intent = Intent(baseContext, UploadActivity::class.java)
            startActivity(intent)
        }

        binding.saveSquad.setOnClickListener {
            if(viewModel.stashList.value!!.size == 11){
                viewModel.removeData()
                if(viewModel.stashList.value != null){
                    for(stashEntity in viewModel.stashList.value!!){
                        viewModel.insertData(stashEntity.position, stashEntity.formation, stashEntity.name, stashEntity.key)
                        viewModel.getData()
                    }
                }
            }else{
                Toast.makeText(baseContext, "11명을 모두 채워주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.loadSquad.setOnClickListener {
            viewModel.getStashData()
            viewModel.getData()
            for(squadEntity in viewModel.squadList.value!!){
                viewModel.insertStashData(squadEntity.position, squadEntity.formation, squadEntity.name, squadEntity.key)
            }
            Handler().postDelayed({
                viewModel.getStashData()
                Toast.makeText(baseContext, viewModel.stashList.value.toString() + "0", Toast.LENGTH_SHORT).show()
                Toast.makeText(baseContext, viewModel.squadList.value.toString() + "1", Toast.LENGTH_SHORT).show()
                Fragment4231.loadSquad(viewModel.squadList.value!!)
            },1000)
        }

        // Spinner + Fragment

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("4231", "433", "343"))

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    viewModel.removeStashData()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment4231).commit()
                }
                if(p2 == 1){
                    viewModel.removeStashData()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment433).commit()
                }
                if(p2 == 2){
                    viewModel.removeStashData()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Fragment343).commit()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    override fun sendMessage(message: StashEntity) {
        viewModel.insertStashData(message.position, message.formation, message.name, message.key)
        viewModel.getStashData()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.removeStashData()
        viewModel.getData()
    }

}