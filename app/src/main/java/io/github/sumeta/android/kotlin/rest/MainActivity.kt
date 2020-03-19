package io.github.sumeta.android.kotlin.rest

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        println("start app")

        val btnHttp:Button = findViewById(R.id.btnOKHttp)

        intent = Intent(this, OKHttpActivity::class.java)

        btnHttp.setOnClickListener {startActivity(intent)}

    }

}
