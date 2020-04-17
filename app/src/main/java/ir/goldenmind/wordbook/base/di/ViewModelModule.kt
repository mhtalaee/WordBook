package ir.goldenmind.wordbook.base.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.goldenmind.wordbook.features.addnewword.NewWordViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewWordViewModel::class)
    abstract fun bindMyViewModel(newWordViewModel: NewWordViewModel): ViewModel

}