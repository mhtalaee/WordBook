package ir.goldenmind.wordbook.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.goldenmind.wordbook.pojo.Word

@Database(entities = [Word::class], version = 1)
abstract class WordBookDataBase : RoomDatabase() {

    companion object {

        lateinit var instance: WordBookDataBase
        fun getDatabase(context: Context): WordBookDataBase {
            instance =
                Room.databaseBuilder(context, WordBookDataBase::class.java, "wordBookDB").build()
            return instance
        }
    }

    abstract fun wordBookDao(): WordBookDao

}