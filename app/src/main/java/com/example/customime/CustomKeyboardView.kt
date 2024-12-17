package com.example.customime

import android.content.ContentValues.TAG
import android.content.Context
import android.inputmethodservice.KeyboardView
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager

class CustomKeyboardView(context: Context, attrs: AttributeSet) : KeyboardView(context, attrs) {
//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_SPACE) {
//            // Intercept space key and suppress preview
//            val inputConnection: InputConnection = getCurrentInputConnection()
//            inputConnection.commitText(" ", 1) // Insert space without showing preview
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    private fun getCurrentInputConnection(): InputConnection {
//        // Obtain the current InputConnection from the InputMethodService
//        return (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).currentInputConnection
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d(TAG, "onKeyDown: ")
        return super.onKeyDown(keyCode, event)
    }
}

