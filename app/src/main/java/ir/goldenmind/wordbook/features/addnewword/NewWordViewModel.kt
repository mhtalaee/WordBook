package ir.goldenmind.wordbook.features.addnewword

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.goldenmind.wordbook.pojo.Word
import ir.goldenmind.wordbook.repository.DataRepository
import javax.inject.Inject

class NewWordViewModel @Inject constructor(val repository : DataRepository) : ViewModel() {

    val newWordSaved = MutableLiveData<Boolean>()
//    val repository = NewWordModel(application)
    val composite = CompositeDisposable()

    fun saveNewWordClicked(word: Word) {
        composite.add(

            repository.saveNewWord(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        newWordSaved.value = true
                    },
                    {
                        Log.d("WordBookError: ", it.message)
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        composite.clear()
    }

    fun show() {

        Log.d("ViewModel", "Tetststts")
    }

    fun getCount() = 3

}