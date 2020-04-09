package ir.goldenmind.wordbook.base

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}