package com.example.nudge.FormationFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nudge.R
import com.example.nudge.SelectActivity
import com.example.nudge.databinding.Fragment343Binding
import com.example.nudge.databinding.Fragment4231Binding

class Fragment343 : Fragment() {

    private var _binding : Fragment343Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment343Binding.inflate(inflater, container, false)

        // Image Listener

        binding.image1.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 1)
            startActivityForResult(intent,103)
        }
        binding.image2.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 2)
            startActivityForResult(intent,103)
        }
        binding.image3.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 3)
            startActivityForResult(intent,103)
        }
        binding.image4.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 4)
            startActivityForResult(intent,103)
        }
        binding.image5.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 5)
            startActivityForResult(intent,103)
        }
        binding.image6.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 6)
            startActivityForResult(intent,103)
        }
        binding.image7.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 7)
            startActivityForResult(intent,103)
        }
        binding.image8.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 8)
            startActivityForResult(intent,103)
        }
        binding.image9.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 9)
            startActivityForResult(intent,103)
        }
        binding.image10.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 10)
            startActivityForResult(intent,103)
        }
        binding.image11.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 11)
            startActivityForResult(intent,103)
        }

        return binding.root
    }

}