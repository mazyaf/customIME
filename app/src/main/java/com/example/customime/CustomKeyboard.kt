package com.example.customime

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi


class CustomKeyboard : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    private lateinit var keyboardView: CustomKeyboardView
    private lateinit var keyboard: Keyboard

    private val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreateInputView(): View {
        val inflater = layoutInflater
        keyboardView = inflater.inflate(R.layout.keyboard_view, null) as CustomKeyboardView
        keyboard = Keyboard(this, R.xml.keyboard_layout)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    @Deprecated("Deprecated in Java")
    override fun onKey(primaryCode: Int, keyCodes: IntArray) {
        val ic = currentInputConnection

        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> ic.deleteSurroundingText(1, 0)
            Keyboard.KEYCODE_SHIFT -> handleShift()
            Keyboard.KEYCODE_DONE -> ic.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
            -100 -> showInputMethodPicker()
            else -> {
                val char = primaryCode.toChar()
                ic.commitText(char.toString(), 1)
            }
        }
    }


    private fun showInputMethodPicker() {
        val imeManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imeManager.showInputMethodPicker()
    }




    private fun handleShift() {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun onPress(primaryCode: Int) {
        // Called when a key is pressed down
        // You can change the key's appearance here
        // For example, change the key background to show it's pressed

        Log.d(TAG, "onPress: code $primaryCode ")
        if(primaryCode == 32 || primaryCode == -5) {
            keyboardView.setPreviewEnabled(false)
        } else {
            keyboardView.setPreviewEnabled(true)
        }

        keyboardView.invalidateKey(primaryCode)
    }

    override fun onRelease(primaryCode: Int) {
        // Called when a key is released
        // Revert the key's appearance back to its normal state
        keyboardView.invalidateKey(primaryCode)
    }

    override fun onText(text: CharSequence?) {
        TODO("Not yet implemented")
    }

    override fun swipeLeft() {
        TODO("Not yet implemented")
    }

    override fun swipeRight() {
        TODO("Not yet implemented")
    }

    override fun swipeDown() {
        TODO("Not yet implemented")
    }

    override fun swipeUp() {
        TODO("Not yet implemented")
    }


}