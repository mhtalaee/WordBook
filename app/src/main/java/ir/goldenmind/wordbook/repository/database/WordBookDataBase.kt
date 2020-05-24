package ir.goldenmind.wordbook.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.goldenmind.wordbook.pojo.Word

@Database(entities = [Word::class], version = 1)
abstract class WordBookDataBase : RoomDatabase() {

    abstract fun wordBookDao(): WordBookDao

}