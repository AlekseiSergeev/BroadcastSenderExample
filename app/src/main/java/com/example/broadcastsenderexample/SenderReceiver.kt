package com.example.broadcastsenderexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SenderReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("keyString")

        resultCode++
        stringExtra += "-> SenderReceiver"

        val toastText =
            "SenderReceiver\n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "SenderReceiver"
        resultExtras.putString("keyString", stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}