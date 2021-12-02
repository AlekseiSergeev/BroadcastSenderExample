package com.example.broadcastsenderexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
    }

    fun sendBroadcast(view: android.view.View) {
        val intentExample = Intent("com.example.EXAMPLE_ACTION")
        intentExample.putExtra("com.example.EXTRA_TEXT", "Broadcast received")
        sendBroadcast(intentExample)

        val intent = Intent(this, ExampleBroadcastReceiver2::class.java)
        sendBroadcast(intent)
    }

    private val broadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val receivedText = intent?.getStringExtra("com.example.EXTRA_TEXT")
            textView.text = receivedText ?: "empty message!"
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.example.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}