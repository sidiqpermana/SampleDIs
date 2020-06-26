package com.nbs.sampledidip.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.nbs.sampledidip.R.layout
import com.nbs.sampledidip.domain.model.PersonParam
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        mainViewModel.save(PersonParam("sidiq","sidiq@nbs.co.id"))
        mainViewModel.save(PersonParam("topan", "taufan@nbs.co.id"))
        mainViewModel.save(PersonParam("dimas", "dimas@nbs.co.id"))
        mainViewModel.save(PersonParam("ghiyats", "ghiyats@nbs.co.id"))
        mainViewModel.save(PersonParam("saggaf", "saggaf@nbs.co.id"))

        mainViewModel.personResults.observe(this, Observer {
            it.forEach {
               Log.d("Test", it.name)
            }
        })

        mainViewModel.getPersons()
    }
}