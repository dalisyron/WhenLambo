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
import com.example.whenlambo.data.model.CryptocurrencyEntity
import java.lang.ref.WeakReference

class HomeFragment : Fragment(), HomeContract.View {
    private lateinit var recyclerView : RecyclerView

    private val presenter : HomeContract.Presenter by lazy {
        HomePresenter(Injector.provideCryptocurrencyRepository()).apply {
            this.view = WeakReference(this@HomeFragment)
        }
    }
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
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(
                DividerItemDecoration(
                    view.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        presenter.onViewCreated()
    }

    override fun showCryptocurrencies(items : List<CryptocurrencyEntity?>) {
        recyclerView.adapter = CryptocurrencyAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

}
