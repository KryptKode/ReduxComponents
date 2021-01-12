package com.kryptkode.componentarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kryptkode.componentarchitecture.databinding.ActivityMainBinding
import com.kryptkode.componentarchitecture.ui.counter.CounterDemoActivity
import com.kryptkode.componentarchitecture.ui.swahpee.SwahPeeActivity
import com.kryptkode.componentarchitecture.utils.viewbinding.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.counter.setOnClickListener {
            startActivity(CounterDemoActivity.createIntent(this))
        }

        binding.swahPee.setOnClickListener {
            startActivity(SwahPeeActivity.createIntent(this))
        }

    }
}