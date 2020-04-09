package ir.goldenmind.wordbook.features.addnewword

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.goldenmind.wordbook.pojo.Word

class NewWordViewModel(application: Application) : AndroidViewModel(application) {

    val newWordSaved = MutableLiveData<Boolean>()
    val repository = NewWordModel(application)
    val composite = CompositeDisposable()

    fun saveNewWordClicked(word: Word) {
        composite.add(

            repository.saveNewWord(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { newWordSaved.value = true },
                    {}

                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        composite.clear()
    }

}