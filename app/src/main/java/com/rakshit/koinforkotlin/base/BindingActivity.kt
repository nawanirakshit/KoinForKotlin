package com.rakshit.koinforkotlin.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.rakshit.koinforkotlin.R

/**
 * Created By: Shivam Verma
 * Edited By : Rakshit Nawani
 * Date:  January 18 2020
 *
 * Binding Activity can be used as a base class for all the activity, it contains all the basic functions needed by the user, like
 * 1. Printing log
 * 2. Displaying Toast
 * 3. Show/Hide Loading
 * and many more according to needs.
 *
 * In an Activity extend it with BindingActivity<Data Binding Class of that class>
 * After extending Activity we need to override methods which is getLayoutResId, implement it like below
 *
 * @LayoutRes
 * override fun getLayoutResId() = R.layout.your_layout_name_here
 *
 *
 */
abstract class BindingActivity<T : ViewDataBinding> : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutResId(): Int

    protected lateinit var binding: T private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printLog(javaClass.simpleName)
        hideKeyboard()

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
    }

    private var toast: Toast? = null
    /**
     * showToast with message
     *  @view: for custom toast provide view perform inflater and other task at your end
     *  @gravity: provide gravity
     */
    fun showToast(
        message: String?,
        view: View? = null,
        duration: Int = Toast.LENGTH_LONG,
        gravity: Int = Gravity.BOTTOM or Gravity.CENTER_VERTICAL, @DimenRes x: Int = 0, @DimenRes y: Int = 0,
        cancelPrevious: Boolean = false
    ) {

        if (cancelPrevious) toast?.cancel()

        // set custom view
        when {
            view != null -> {
                toast = Toast(this)
                toast?.view = view
            }
            else -> toast = Toast.makeText(this, message, duration)
        }
        // set duration
        toast?.duration = duration
        // set position
        var marginY = 0
        var marginX = 0
        if (y != 0) marginY = resources.getDimensionPixelSize(y)
        if (x != 0) marginX = resources.getDimensionPixelSize(x)
        if (marginX > 0 || marginY > 0) toast?.setGravity(gravity, marginX, marginY)
        // show toast
        toast?.show()
    }

    /**
     * For Hiding the keyboard
     */
    open fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm =
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * function to check if internet connection is active or not.
     *
     * @return true if connected to internet else false
     */
    open fun isConnectedToInternet(): Boolean {
        val cm =
            (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null
    }

    open fun printLog(message: String) {
        Log.d(getString(R.string.app_name), message)
    }
}