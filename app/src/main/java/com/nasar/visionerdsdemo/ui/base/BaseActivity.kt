package com.nasar.visionerdsdemo.ui.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected open fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        fragmentManager.beginTransaction().replace(containerViewId, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()
    }

    protected open fun replaceFragmentWithoutAddingToBackStack(
        containerViewId: Int,
        fragment: Fragment
    ) {
        fragmentManager.beginTransaction().replace(containerViewId, fragment)
            .commit()
    }


}