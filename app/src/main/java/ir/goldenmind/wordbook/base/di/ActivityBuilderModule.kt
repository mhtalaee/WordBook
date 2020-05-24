package ir.goldenmind.wordbook.base.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.goldenmind.wordbook.MainActivity
import ir.goldenmind.wordbook.features.addnewword.NewWordActivity
import ir.goldenmind.wordbook.features.wordslist.WordsListActivity

//import ir.goldenmind.wordbook.features.addnewword.NewWordActivity

/**
 * Builds and injects needed activities by Dagger 2
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun mainActivityContributor(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun newWordActivityContributor(): NewWordActivity

    @ContributesAndroidInjector(modules = [ViewModelProviderModule::class])
    abstract fun wordListActivityContributor(): WordsListActivity

}
