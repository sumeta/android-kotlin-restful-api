package io.github.sumeta.android.kotlin.rest.retrofit

import android.os.Bundle
import android.os.StrictMode
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.sumeta.android.kotlin.rest.R
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException
import java.util.*

class Retrofit2Activity : AppCompatActivity() {

    //private var listview: ListView? = null
    private val dataList: ArrayList<Retrofit2ViewModel> = ArrayList<Retrofit2ViewModel>()
    var a2Adapter: Retrofit2Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        title = "Favorites"

        var listview:ListView = findViewById(R.id.listView)
        a2Adapter = Retrofit2Adapter(this, dataList)
        listview.adapter = a2Adapter

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)


        val call =
            service.contributor("sumeta", "android-restful-api")
        var contributors: List<Contributor?>? = null
        try {
            contributors = call!!.execute().body()
            dataList.clear()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        for (c in contributors!!) {
            println(c!!.login + " (" + c!!.contributions + ")")
            val model = Retrofit2ViewModel()
            model.login = c!!.login
            model.contributions = c!!.contributions
            dataList.add(model)
        }

        a2Adapter!!.notifyDataSetChanged()

    }

    interface GitHubService {
        @GET("/repos/{owner}/{repo}/contributors")
        fun contributor(
            @Path("owner") owner: String?,
            @Path("repo") repo: String?
        ): Call<List<Contributor?>?>?
    }

    class Contributor(val login: String, val contributions: Int)
}
