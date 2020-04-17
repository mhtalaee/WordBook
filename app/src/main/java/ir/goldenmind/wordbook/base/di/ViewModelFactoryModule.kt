package ir.goldenmind.wordbook.base.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.goldenmind.wordbook.base.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}