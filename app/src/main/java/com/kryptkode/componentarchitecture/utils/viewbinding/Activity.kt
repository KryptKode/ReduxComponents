package com.kryptkode.componentarchitecture.utils.viewbinding

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ComponentActivity
import androidx.viewbinding.ViewBinding

/**
 * Helper method to initialize view binding lazily in [AppCompatActivity] subclasses
 *
 * Below is a sample usage with a layout resource file named `sample_activity`
 * and the generated binding class of `SampleActivityBinding`.
 *
 * ```
 * class SampleActivity : AppCompatActivity() {
 *
 *    private val binding by viewBinding(SampleActivityBinding::inflate)
 *
 *    override fun onCreate(savedInstanceState: Bundle?) {
 *        super.onCreate(savedInstanceState)
 *        setContentView(binding.root)
 *
 *        binding.sampleButton.setOnClickListener {
 *              showToast("Hello view binding!")
 *        }
 *    }
 * ```
 * [Source][https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c]
 * */
inline fun <T : ViewBinding> ComponentActivity.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T) =
        lazy(LazyThreadSafetyMode.NONE) {
            bindingInflater.invoke(layoutInflater)
        }