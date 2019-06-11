package com.rommansabbir.minichatapp.base.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.rommansabbir.minichatapp.base.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity<V : ViewDataBinding, VM : ViewModel> : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var binding: V

    protected lateinit var viewModel: VM
    lateinit var customView : View
    lateinit var customDialog : AlertDialog
    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        setupComponent(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        onCreated(savedInstanceState)

    }

    protected open fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

    /**
     * 04-13-2019 - Handle deeplinking for the application by checking intent data
     * in BaseActivity onResume() and calling abstract class processIntentData()
     */
    override fun onResume() {
        super.onResume()
        val data: Uri? = intent!!.data
        data?.let {
            processIntentData(data)
        }
    }

    fun showCustomLayout(id : Int){
        val mBuilder : AlertDialog.Builder = AlertDialog.Builder(this)
        val mView = layoutInflater.inflate(id, null)
        mBuilder.setView(mView)
        customView = mView
        val dialog : AlertDialog = mBuilder.create()
        dialog.show()
        customDialog = dialog
    }

    protected abstract fun onCreated(instance: Bundle?)

    protected abstract fun getViewModel(): Class<VM>

    protected abstract fun setupComponent(activity: Activity)

    protected abstract fun processIntentData(data: Uri)

    @SuppressLint("ObsoleteSdkInt")
    fun goToActivity(currentActivity: Activity, mClass: Class<*>, finishCurrentActivity: Boolean, @Nullable extras: HashMap<String, String>?) {
        val clearTask = Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN
        val intent = Intent(currentActivity, mClass)
        if(extras != null){
            for(extra in extras){
                intent.putExtra(extra.key.toString(), extra.value.toString())
            }
        }
        if (clearTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        currentActivity.startActivity(intent)
        if (finishCurrentActivity)
            currentActivity.finish()

    }

    fun goToFragment(fragment: Fragment, containerViewId: Int) {
        supportFragmentManager.beginTransaction()
            .add(containerViewId, fragment)
            .commit()
    }

    /**
     * This method responsible for showing selected activity
     */
    fun showFragment(id : Int,activity: AppCompatActivity, fragment: Fragment) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}