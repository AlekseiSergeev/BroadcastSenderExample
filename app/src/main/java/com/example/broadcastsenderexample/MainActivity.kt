package com.example.broadcastsenderexample

import android.Manifest
import android.content.*
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

        intentExample.setPackage("com.example.broadcastreceiverexample")

        val extras = Bundle()
        extras.putString("keyString", "Start")

        sendOrderedBroadcast(intentExample, Manifest.permission.WAKE_LOCK, SenderReceiver(),
                      null, 0, "Start", extras)
    }

}