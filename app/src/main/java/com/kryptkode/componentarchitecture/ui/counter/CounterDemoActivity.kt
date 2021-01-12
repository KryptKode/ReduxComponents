package com.kryptkode.componentarchitecture.ui.counter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kryptkode.componentarchitecture.*
import com.kryptkode.componentarchitecture.components.CounterComponent
import com.kryptkode.componentarchitecture.components.CounterState
import com.kryptkode.recomponents.StoreImpl
import com.kryptkode.recomponents.UIComponentManager

val store = StoreImpl(
    AppState(),
    appReducer,
    listOf(loggerMiddleWare, multiplierMiddleware)
)



class CounterDemoActivity : AppCompatActivity() {

    private val uiComponentManager : UIComponentManager<AppState> by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return UIComponentManager(store) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_demo)
        initComponents(findViewById(R.id.root))
    }

    private fun initComponents(container: ViewGroup) {
        with(uiComponentManager){
            subscribe(CounterComponent(container)){
                CounterState(it.count.toString())
            }
        }
    }

    companion object {
        fun createIntent(context: Context):Intent{
            return Intent(context, CounterDemoActivity::class.java)
        }
    }
}