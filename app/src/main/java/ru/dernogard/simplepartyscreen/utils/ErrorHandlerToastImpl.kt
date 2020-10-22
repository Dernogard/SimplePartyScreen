package ru.dernogard.simplepartyscreen.utils

import android.widget.Toast
import androidx.annotation.StringRes
import com.google.gson.stream.MalformedJsonException
import ru.dernogard.simplepartyscreen.App
import ru.dernogard.simplepartyscreen.R
import java.io.FileNotFoundException

/**
 * Simple realisation of the ErrorHandler is showing toast message
 */

internal class ErrorHandlerToastImpl: ErrorHandler {

    override fun handle(error: Throwable) {
        when (error) {
            is FileNotFoundException -> showToastMessage(R.string.error_file_not_found)
            is MalformedJsonException -> showToastMessage(R.string.error_wrong_file_format)
            else -> showToastMessage(R.string.error_unknown)
        }
    }

    private fun showToastMessage(@StringRes message: Int) {
        Toast.makeText(App.context, message, Toast.LENGTH_SHORT).show()
    }

}