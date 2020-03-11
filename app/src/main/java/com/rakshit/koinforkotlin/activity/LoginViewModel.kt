package com.rakshit.koinforkotlin.activity

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.rakshit.koinforkotlin.R
import com.rakshit.koinforkotlin.base.BaseViewModel
import com.rakshit.koinforkotlin.io.RequestAPIs
import com.rakshit.koinforkotlin.utils.with

class LoginViewModel(
    private val api: RequestAPIs,
    private val context: Context
) : BaseViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var showLoading = MutableLiveData<Boolean>()
    private var response = MutableLiveData<String>()
    private var showError = MutableLiveData<String>()


    fun getErrorValue(): MutableLiveData<String> {
        return showError
    }

    fun getResponseValue(): MutableLiveData<String> {
        return response
    }

    fun showLoading(): MutableLiveData<Boolean> {
        return showLoading
    }

    fun login() {

        //   val e = email.value
        //   val p = password.value

        //Check Validations here

        sendData()

    }

    private fun sendData() {

        val params = mutableMapOf<String, String>().apply {
            this["email"] = email.value.toString()
            this["password"] = password.value.toString()
        }

        if (isConnectedToInternet(context)) {
            addToDisposable(api.login(params).with()
                .doOnSubscribe { showLoading.value = true }
                .doOnSuccess { showLoading.value = false }
                .doOnError { showLoading.value = false }
                .subscribe({

                    //Do something with response

//                    if (it.status == 1) {
//                        response.value = it
//                    } else {
//
//                        showError.value = it.msg
//                    }

                }, {
                    // handle errors
                    showError.value = it.message
                })
            )
        } else {
            showError.value = context.getString(R.string.no_internet)
        }
    }


}