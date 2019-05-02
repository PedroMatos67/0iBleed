package com.example.ibleed.TELAS

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import com.example.ibleed.R
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger


class Main2Activity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun launchRegisterActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun launchMainActivity(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
