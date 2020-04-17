package ir.goldenmind.wordbook.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

}