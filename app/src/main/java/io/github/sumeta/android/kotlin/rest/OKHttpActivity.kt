package io.github.sumeta.android.kotlin.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import okhttp3.*
import java.io.IOException

class OKHttpActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        println("start app")

        run("https://api.github.com/users/sumeta/repos")
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) { println("Error!! " +e.message)}
            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.string())
            }
        })
    }

}
