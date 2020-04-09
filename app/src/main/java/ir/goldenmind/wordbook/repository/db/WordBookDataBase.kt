package ir.goldenmind.wordbook.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.goldenmind.wordbook.pojo.Word
import ir.goldenmind.wordbook.utils.Converters

@Database(entities = [Word::class], version = 1)
@TypeConverters(Converters::class)
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