package ir.goldenmind.wordbook.base

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import ir.goldenmind.wordbook.R

open class BaseActivity : DaggerAppCompatActivity() {

    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    fun initActionBar(activityName : String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title =
            "${supportActionBar?.title.toString()} ${getString(R.string.hrchy_sign)} ${activityName}"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}