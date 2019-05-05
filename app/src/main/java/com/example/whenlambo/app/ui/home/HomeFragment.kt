package com.example.whenlambo.app.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.whenlambo.R
import com.example.whenlambo.app.Injector
import android.support.v7.widget.DividerItemDecoration

class HomeFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context!!,
                DividerItemDecoration.VERTICAL
            )
        )

        val repository = Injector.provideCryptocurrencyRepository()

        repository.getLatestCryptocurrencies { cryptocurrencies ->
            activity?.runOnUiThread {

                recyclerView.adapter = CryptocurrencyAdapter(cryptocurrencies)
            }
        }
    }
}
