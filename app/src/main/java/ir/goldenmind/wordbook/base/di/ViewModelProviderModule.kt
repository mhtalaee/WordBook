package ir.goldenmind.wordbook.base.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.goldenmind.wordbook.features.addnewword.NewWordViewModel
import ir.goldenmind.wordbook.features.wordslist.WordListViewModel

/**
 * Provides ViewModels to let Dagger inject them
 */
@Module
abstract class ViewModelProviderModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewWordViewModel::class)
    abstract fun bindViewModel(newWordViewModel: NewWordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WordListViewModel::class)
    abstract fun wordListViewModelProvider(wordListViewModel: WordListViewModel): ViewModel

}
