package com.example.nudge

import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.StashEntity

interface SendEventListener {
    fun sendMessage(message : StashEntity)
}