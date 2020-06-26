package com.nbs.sampledidip.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nbs.sampledidip.domain.PersonUseCase
import com.nbs.sampledidip.domain.model.Person
import com.nbs.sampledidip.domain.model.PersonParam
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel @ViewModelInject constructor(
    private val personUseCase: PersonUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    private val _personResults = MutableLiveData<List<Person>>()

    val personResults: LiveData<List<Person>> get() = _personResults

    fun getPersons() {
        personUseCase.getAll().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _personResults.value = it
                }, {
                    it.printStackTrace()
                }
            ).addTo(compositeDisposable)
    }

    fun save(personParam: PersonParam) {
        personUseCase.save(personParam).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Test", "Success")
            }, {
                it.printStackTrace()
            }).addTo(disposable = compositeDisposable)
    }

    private fun Disposable.addTo(disposable: CompositeDisposable) {
        disposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}