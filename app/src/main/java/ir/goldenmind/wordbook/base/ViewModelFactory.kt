package ir.goldenmind.wordbook.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.jetbrains.annotations.NotNull
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(val viewModelsMap: Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @NotNull
    @Override
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val creator = viewModelsMap[modelClass]
        return creator!!.get() as T

    }

}