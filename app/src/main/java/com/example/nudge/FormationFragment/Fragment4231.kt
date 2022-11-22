package com.example.nudge.FormationFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nudge.MainViewModel
import com.example.nudge.R
import com.example.nudge.SelectActivity
import com.example.nudge.databinding.Fragment4231Binding

class Fragment4231 : Fragment() {

    private var _binding : Fragment4231Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment4231Binding.inflate(inflater, container, false)

        // Image Listener

        binding.image1.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 1)
            startActivityForResult(intent,101)
        }
        binding.image2.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 2)
            startActivityForResult(intent,101)
        }
        binding.image3.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 3)
            startActivityForResult(intent,101)
        }
        binding.image4.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 4)
            startActivityForResult(intent,101)
        }
        binding.image5.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 5)
            startActivityForResult(intent,101)
        }
        binding.image6.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 6)
            startActivityForResult(intent,101)
        }
        binding.image7.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 7)
            startActivityForResult(intent,101)
        }
        binding.image8.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 8)
            startActivityForResult(intent,101)
        }
        binding.image9.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 9)
            startActivityForResult(intent,101)
        }
        binding.image10.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 10)
            startActivityForResult(intent,101)
        }
        binding.image11.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 11)
            startActivityForResult(intent,101)
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val position = data?.getIntExtra("position", 0)
            val name = data?.getStringExtra("name")
            val key = data?.getStringExtra("key")
            if(requestCode == 101){
                when(position){
                    1->{
                        Toast.makeText(context, "1"+name+key, Toast.LENGTH_SHORT).show()
                    }
                    2->{
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                    }
                    3->{
                        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
                    }
                    4->{
                        Toast.makeText(context, "4", Toast.LENGTH_SHORT).show()
                    }
                    5->{
                        Toast.makeText(context, "5", Toast.LENGTH_SHORT).show()
                    }
                    6->{
                        Toast.makeText(context, "6", Toast.LENGTH_SHORT).show()
                    }
                    7->{
                        Toast.makeText(context, "7", Toast.LENGTH_SHORT).show()
                    }
                    8->{
                        Toast.makeText(context, "8", Toast.LENGTH_SHORT).show()
                    }
                    9->{
                        Toast.makeText(context, "9", Toast.LENGTH_SHORT).show()
                    }
                    10->{
                        Toast.makeText(context, "10", Toast.LENGTH_SHORT).show()
                    }
                    11->{
                        Toast.makeText(context, "11", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}