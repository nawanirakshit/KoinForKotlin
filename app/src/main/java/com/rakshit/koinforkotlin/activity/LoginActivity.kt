package com.rakshit.koinforkotlin.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.rakshit.koinforkotlin.R
import com.rakshit.koinforkotlin.base.BindingActivity
import com.rakshit.koinforkotlin.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BindingActivity<ActivityLoginBinding>() {

    lateinit var viewModel: LoginViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        observeViews()
    }

    private fun observeViews() {
        viewModel.getErrorValue().observe(this, Observer { showError ->
            showToast(message = showError)
        })

        viewModel.showLoading().observe(this, Observer {

            if (it) {

                //Show Loading when data is requested using Retrofit

            } else {
                // Hide Loading
            }
        })

        viewModel.getResponseValue().observe(this, Observer {
            //Do something with response
        })

    }
}
