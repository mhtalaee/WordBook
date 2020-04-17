package ir.goldenmind.wordbook.base

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

    }

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()


}