package ir.goldenmind.wordbook.base.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.goldenmind.wordbook.repository.database.WordBookDao
import ir.goldenmind.wordbook.repository.database.WordBookDataBase
import javax.inject.Singleton

/**
 * A module to provide all dependencies for room
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun database(application: Application): WordBookDataBase {
        return Room.databaseBuilder(application.applicationContext, WordBookDataBase::class.java, "Albums.db").build()
    }

    @Singleton
    @Provides
    fun provideAlbumsDAO(appDatabase: WordBookDataBase): WordBookDao {
        return appDatabase.wordBookDao()
    }
}
