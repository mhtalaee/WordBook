package ir.goldenmind.wordbook.base.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.goldenmind.wordbook.base.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, ViewModelFactoryProvider::class, RoomModule::class])
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