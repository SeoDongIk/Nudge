package com.example.nudge.FormationFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.StashEntity
import com.example.nudge.MainViewModel
import com.example.nudge.R
import com.example.nudge.SelectActivity
import com.example.nudge.SendEventListener
import com.example.nudge.databinding.Fragment4231Binding
import com.example.nudge.databinding.Fragment433Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class Fragment433 : Fragment() {

    private var _binding : Fragment433Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewmodel : MainViewModel
    private var forSaveSquadList : MutableList<SquadEntity> = mutableListOf<SquadEntity>()
    lateinit var sendEventListener : SendEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendEventListener = context as SendEventListener
        val mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment433Binding.inflate(inflater, container, false)

        // Image Listener

        binding.image1.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 1)
            startActivityForResult(intent,102)
        }
        binding.image2.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 2)
            startActivityForResult(intent,102)
        }
        binding.image3.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 3)
            startActivityForResult(intent,102)
        }
        binding.image4.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 4)
            startActivityForResult(intent,102)
        }
        binding.image5.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 5)
            startActivityForResult(intent,102)
        }
        binding.image6.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 6)
            startActivityForResult(intent,102)
        }
        binding.image7.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 7)
            startActivityForResult(intent,102)
        }
        binding.image8.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 8)
            startActivityForResult(intent,102)
        }
        binding.image9.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 9)
            startActivityForResult(intent,102)
        }
        binding.image10.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 10)
            startActivityForResult(intent,102)
        }
        binding.image11.setOnClickListener {
            val intent = Intent(context, SelectActivity::class.java)
            intent.putExtra("position", 11)
            startActivityForResult(intent,102)
        }

        return binding.root
    }

    fun loadSquad(squadEntityList : List<SquadEntity>){
        Toast.makeText(context, squadEntityList.toString() + "2", Toast.LENGTH_SHORT).show()
        for(i in 0..squadEntityList.size-1){
            val position = i
            val key = squadEntityList.get(i).key
            val myRef = Firebase.storage.reference.child(key + ".png")
            when(position){
                0->{
                    val imageView = binding.image1
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                1->{
                    val imageView = binding.image2
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                2->{
                    val imageView = binding.image3
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                3->{
                    val imageView = binding.image4
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                4->{
                    val imageView = binding.image5
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                5->{
                    val imageView = binding.image6
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                6->{
                    val imageView = binding.image7
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                7->{
                    val imageView = binding.image8
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                8->{
                    val imageView = binding.image9
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                9->{
                    val imageView = binding.image10
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
                10->{
                    val imageView = binding.image11
                    myRef.downloadUrl.addOnCompleteListener({
                        if(it.isSuccessful){
                            Glide.with(this)
                                .load(it.result)
                                .into(imageView)
                        }
                    })
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val position = data?.getIntExtra("position", 0)
            val name = data?.getStringExtra("name")
            val key = data?.getStringExtra("key")
            val myRef = Firebase.storage.reference.child(key + ".png")
            if(requestCode == 102){
                when(position){
                    1->{
                        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image1
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(1, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    2->{
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image2
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(2, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    3->{
                        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image3
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(3, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    4->{
                        Toast.makeText(context, "4", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image4
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(4, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    5->{
                        Toast.makeText(context, "5", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image5
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(5, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    6->{
                        Toast.makeText(context, "6", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image6
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(6, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    7->{
                        Toast.makeText(context, "7", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image7
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(7, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    8->{
                        Toast.makeText(context, "8", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image8
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(8, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    9->{
                        Toast.makeText(context, "9", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image9
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(9, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    10->{
                        Toast.makeText(context, "10", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image10
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(10, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                    11->{
                        Toast.makeText(context, "11", Toast.LENGTH_SHORT).show()
                        val imageView = binding.image11
                        myRef.downloadUrl.addOnCompleteListener({
                            if(it.isSuccessful){
                                Glide.with(this)
                                    .load(it.result)
                                    .into(imageView)
                            }
                        })
                        val mySquadEntity = StashEntity(11, 433, name!!,key!!)
                        sendEventListener.sendMessage(mySquadEntity)
                    }
                }
            }
        }
    }

}