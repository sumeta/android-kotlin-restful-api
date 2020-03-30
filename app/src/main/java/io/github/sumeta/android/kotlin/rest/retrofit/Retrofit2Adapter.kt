package io.github.sumeta.android.kotlin.rest.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import io.github.sumeta.android.kotlin.rest.R
import java.util.*

class Retrofit2Adapter(
    var mContext: Context,
    var data: ArrayList<Retrofit2ViewModel>
) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Int {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, v: View?, parent: ViewGroup): View {
        var view = v
        val mInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (view == null) view = mInflater.inflate(R.layout.listview_retrofit2, parent, false)
        val textViewSymbol = view?.findViewById<TextView>(R.id.textViewName)
        textViewSymbol!!.text = data[position].login
        val textViewName = view?.findViewById<TextView>(R.id.textViewNumber)
        textViewName!!.text = "" + data[position].contributions
        return view!!
    }

}