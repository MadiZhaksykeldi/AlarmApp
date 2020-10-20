package com.example.alarmapp.view_helpers;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyboardHelper {
    Context context;
    InputMethodManager inputMethodManager;

    public KeyboardHelper(Context context) {
        this.context = context;
        inputMethodManager = (InputMethodManager) this.context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public void showKeyboard(EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean isFocused) {
                if (isFocused) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                }
            }
        });
    }

    public void hideKeyboard(EditText editText) {
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void moveCursorToEnd(EditText editText) {
        editText.setSelection(editText.getText().length());
    }
}
