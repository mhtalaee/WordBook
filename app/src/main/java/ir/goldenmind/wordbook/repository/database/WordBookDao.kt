package ir.goldenmind.wordbook.repository.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ir.goldenmind.wordbook.pojo.Word

@Dao
interface WordBookDao {

    @Insert
    fun insertWord(vararg word: Word): Completable

    @Query("SELECT * FROM word")
    fun getAll(): Observable<List<Word>>

    @Query("SELECT count(*) FROM word")
    fun getCount(): Flowable<Int>

    @Query("SELECT * FROM word")
    fun getSavedWords(): Single<List<Word>>
}