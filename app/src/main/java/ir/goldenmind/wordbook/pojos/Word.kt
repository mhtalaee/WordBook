package ir.goldenmind.wordbook.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime

@Entity
data class Word(
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "translation") val translation: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}