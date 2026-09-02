package com.example.demo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlField: EditText = findViewById(R.id.urlField)
        val fetchButton: Button = findViewById(R.id.fetchButton)
        val textView: TextView = findViewById(R.id.textView)

        val client = OkHttpClient()

        fetchButton.setOnClickListener {
            val url = urlField.text.toString().trim()
            textView.text = "Loading..."

            thread {
                try {
                    val request = Request.Builder().url(url).build()
                    client.newCall(request).execute().use { response ->
                        val body = response.body?.string() ?: ""
                        runOnUiThread {
                            textView.text = "Status: ${response.code}\n\n$body"
                        }
                    }
                } catch (e: Exception) {
                    runOnUiThread {
                        textView.text = "Error: ${e.message}"
                    }
                }
            }
        }
    }
}
