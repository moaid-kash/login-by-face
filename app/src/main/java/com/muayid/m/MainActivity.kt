package com.muayid.m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    var exc=ContextCompat.getMainExecutor(this)
        var biom=BiometricPrompt(this, exc, object : BiometricPrompt.AuthenticationCallback()
            {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    textView.text=" :خطأ"+errString
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()

                    textView.text="فشل"

                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                textView.text="تم بنجح "



                }
            })




        var pr=BiometricPrompt.PromptInfo.Builder()
            .setTitle("BiometricPrompt")
            .setSubtitle("login usig fingreprint or face")
            .setNegativeButtonText("Cancel")
            .build()

        button.setOnClickListener {
            biom.authenticate(pr)
        }
    }








}
