package com.example.broadcastsenderexample

import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context


class ExampleBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "EBR triggered", Toast.LENGTH_SHORT).show()
    }
}