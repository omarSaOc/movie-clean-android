package com.osao.moviecleanandroid.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.osao.moviecleanandroid.R

class LoadingDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_loading_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        // Configurar el tamaño del diálogo y el estilo
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false) // Prevenir que el diálogo se cierre al tocar fuera
    }

    companion object {
        const val TAG = "LoadingDialogFragment"

        fun newInstance(): LoadingDialogFragment {
            return LoadingDialogFragment()
        }
    }



}
