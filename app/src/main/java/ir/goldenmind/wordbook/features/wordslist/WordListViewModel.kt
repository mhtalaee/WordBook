package ir.goldenmind.wordbook.features.wordslist

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.goldenmind.wordbook.pojo.Word
import ir.goldenmind.wordbook.repository.DataRepository
import java.util.logging.Logger
import javax.inject.Inject

class WordListViewModel @Inject constructor(val repository: DataRepository) : ViewModel() {

    val composite = CompositeDisposable()
    val wordCount = MutableLiveData<Int>()
    val wordList = MutableLiveData<List<Word>>()

    fun getCount() {

        composite.add(
            repository.getCount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        wordCount.value = it
                    },
                    {
                        Log.d("WordBookError: ", it.message)
                    })
        )
    }

    fun getWordsList() {
        composite.add(
            repository.getSavedWords()
                .subscribe(
                    {
                        wordList.value = it
                    },
                    {
                        Log.d("WordBookAppError:", it.message)
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        composite.clear()
    }

}