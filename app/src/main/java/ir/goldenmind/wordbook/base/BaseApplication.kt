package ir.goldenmind.wordbook.base

import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.support.DaggerApplication
import ir.goldenmind.wordbook.base.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

    }

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()


}