package ir.goldenmind.wordbook.base

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ir.goldenmind.wordbook.base.di.ViewModelFactoryModule
import ir.goldenmind.wordbook.base.di.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {
    /**
     * Builder to bind application to modules
     */
    @Component.Builder
    interface Builder {

        /**
         * Gets application instance
         */
        @BindsInstance
        fun application(application: Application): Builder

        /**
         * Builds the component
         */
        fun build(): AppComponent
    }

}