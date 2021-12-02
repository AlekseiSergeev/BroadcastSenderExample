package com.example.broadcastsenderexample

import android.Manifest
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var localBroadcastManager: LocalBroadcastManager
    private lateinit var exampleBroadcastReceiver: ExampleBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)

        exampleBroadcastReceiver = ExampleBroadcastReceiver()

        localBroadcastManager = LocalBroadcastManager.getInstance(this)
    }

    fun sendLocalBroadcast(view: View) {
        val intent = Intent("com.example.EXAMPLE_ACTION")
        localBroadcastManager.sendBroadcast(intent)
    }

    fun sendBroadcast(view: android.view.View) {
        val intentExample = Intent("com.example.EXAMPLE_ACTION")

        intentExample.setPackage("com.example.broadcastreceiverexample")

        val extras = Bundle()
        extras.putString("keyString", "Start")

        sendOrderedBroadcast(intentExample, Manifest.permission.WAKE_LOCK, SenderReceiver(),
                      null, 0, "Start", extras)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.example.EXAMPLE_ACTION")
        localBroadcastManager.registerReceiver(exampleBroadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        localBroadcastManager.unregisterReceiver(exampleBroadcastReceiver)
    }
}