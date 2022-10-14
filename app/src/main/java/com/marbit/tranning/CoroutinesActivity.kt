package com.marbit.tranning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        button.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val success = withContext(Dispatchers.IO){ validateLogin()}
                Toast.makeText(applicationContext, success.toString(), Toast.LENGTH_SHORT).show()
            }

            Log.d("MARCE", "Log.d")
        }

    }

    private fun validateLogin(): Boolean {
        Thread.sleep(5000)
        return true
    }
}