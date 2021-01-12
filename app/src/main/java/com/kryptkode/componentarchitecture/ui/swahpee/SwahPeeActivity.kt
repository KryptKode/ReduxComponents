package com.kryptkode.componentarchitecture.ui.swahpee

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kryptkode.componentarchitecture.databinding.RootConstraintBinding
import com.kryptkode.componentarchitecture.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SwahPeeActivity : AppCompatActivity(){
    private val binding by viewBinding(RootConstraintBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SwahPeeActivity::class.java)
        }
    }
}