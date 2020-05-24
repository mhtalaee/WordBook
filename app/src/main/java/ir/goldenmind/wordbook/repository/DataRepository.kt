package ir.goldenmind.wordbook.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.goldenmind.wordbook.pojo.Word
import ir.goldenmind.wordbook.repository.database.WordBookDao
import javax.inject.Inject

class DataRepository @Inject constructor(val dao: WordBookDao) {

    fun saveNewWord(word: Word): Completable {
        return dao.insertWord(word)
    }

    fun getCount() : Flowable<Int> {
        return dao.getCount()
    }

    fun getSavedWords() : Single<List<Word>> {
        return dao.getSavedWords()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}