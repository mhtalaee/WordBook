package ir.goldenmind.wordbook.base.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.goldenmind.wordbook.base.ViewModelFactory

/**
 * Provides ViewModelFactory
 */
@Module
abstract class ViewModelFactoryProvider {

    @Binds
    abstract fun viewModelFactoryProvider(factory: ViewModelFactory): ViewModelProvider.Factory
}
