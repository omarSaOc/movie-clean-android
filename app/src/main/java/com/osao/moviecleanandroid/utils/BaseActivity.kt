package com.osao.moviecleanandroid.utils

import androidx.appcompat.app.AppCompatActivity

/**
 * Clase base para las actividades de la aplicación en la que se definen métodos comunes
 */
open class BaseActivity: AppCompatActivity()  {

    fun showLoading() {
        val loadingDialogFragment = LoadingDialogFragment.newInstance()
        loadingDialogFragment.show(supportFragmentManager, LoadingDialogFragment.TAG)
    }

    fun dismissLoading() {
        supportFragmentManager.fragments.filterIsInstance<LoadingDialogFragment>().forEach {
            it.dismissAllowingStateLoss()
        }
    }
}