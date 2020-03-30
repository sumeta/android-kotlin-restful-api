package io.github.sumeta.android.kotlin.rest

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.github.sumeta.android.kotlin.rest.retrofit.Retrofit2Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        println("start app")

        val btnHttp:Button = findViewById(R.id.btnOKHttp)
        val btnFavorites:Button = findViewById(R.id.btnFavorites)
        var intent = Intent(this, OKHttpActivity::class.java)
        var intentFavorites = Intent(this, Retrofit2Activity::class.java)

        btnHttp.setOnClickListener {startActivity(intent)}

        btnFavorites.setOnClickListener {startActivity(intentFavorites)}

    }

}
