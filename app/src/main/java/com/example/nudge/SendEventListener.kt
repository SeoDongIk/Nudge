package com.example.nudge

import com.example.nudge.Entity.SquadEntity

interface SendEventListener {
    fun sendMessage(message : SquadEntity)
}