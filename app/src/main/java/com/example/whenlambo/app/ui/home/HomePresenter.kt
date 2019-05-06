package com.example.whenlambo.app.ui.home

import com.example.whenlambo.app.Injector
import com.example.whenlambo.data.repository.CryptocurencyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference

class HomePresenter(private val cryptocurencyRepository: CryptocurencyRepository) : HomeContract.Presenter {

    lateinit var view : WeakReference<HomeContract.View>
    private var compositeDisposable = CompositeDisposable()

    override fun onViewCreated() {

        val repository = Injector.provideCryptocurrencyRepository()

        repository.getLatestCryptocurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                view.get()?.showCryptocurrencies(it)
            }
            .subscribe().addTo(compositeDisposable)
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
    }
}