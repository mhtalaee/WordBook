package ir.goldenmind.wordbook.features.addnewword

import android.app.Application
import io.reactivex.Completable
import ir.goldenmind.wordbook.pojo.Word
import ir.goldenmind.wordbook.repository.db.WordBookDataBase

class NewWordModel(application : Application) {

    val db = WordBookDataBase.getDatabase(application)

    fun saveNewWord(word: Word): Completable {
        return db.wordBookDao().insertWord(word)
    }

}