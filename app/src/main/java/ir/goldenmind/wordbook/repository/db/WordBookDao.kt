package ir.goldenmind.wordbook.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ir.goldenmind.wordbook.pojo.Word

@Dao
interface WordBookDao {

    @Insert
    fun insertWord(vararg word: Word): Completable

    @Query("SELECT * FROM word")
    fun getAll(): Observable<List<Word>>
}