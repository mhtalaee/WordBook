package ir.goldenmind.wordbook.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

}