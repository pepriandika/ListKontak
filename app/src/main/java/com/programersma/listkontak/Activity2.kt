package com.programersma.listkontak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView


class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val kontak = intent.getParcelableExtra<Kontak>("kontak")
        val ivDataReceived = findViewById<ImageView>(R.id.imageView)
        val tvDataReceived1: TextView = findViewById(R.id.textView)
        val tvDataReceived2: TextView = findViewById(R.id.textView2)

        ivDataReceived.setImageResource(kontak?.foto!!)
        tvDataReceived1.text = kontak.nama
        tvDataReceived2.text = kontak.detail
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}