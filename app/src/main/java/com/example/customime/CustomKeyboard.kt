package com.example.customime

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.KeyEvent
import android.view.View


class CustomKeyboard : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    private lateinit var keyboardView: KeyboardView
    private lateinit var keyboard: Keyboard

    override fun onCreateInputView(): View {
        val inflater = layoutInflater
        keyboardView = inflater.inflate(R.layout.keyboard_view, null) as KeyboardView
        keyboard = Keyboard(this, R.xml.keyboard_layout)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray) {
        val ic = currentInputConnection
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> ic.deleteSurroundingText(1, 0)
            Keyboard.KEYCODE_SHIFT -> handleShift()
            Keyboard.KEYCODE_DONE -> ic.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
            else -> {
                val char = primaryCode.toChar()
                ic.commitText(char.toString(), 1)
            }
        }
    }
    private fun handleShift() {
        TODO("Not yet implemented")
    }

    override fun onPress(primaryCode: Int) {
        // Called when a key is pressed down
        // You can change the key's appearance here
        // For example, change the key background to show it's pressed
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