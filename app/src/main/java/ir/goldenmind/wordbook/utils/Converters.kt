package ir.goldenmind.wordbook.utils

import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

// This class is used to convert LocalDateTime to String because Room (Sqlite)
//doesn't know LocalDateTime (Then doesn't know any date type) and store it as String (or Long)
class Converters {

    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun toLocalDateTime(value: String?): LocalDateTime? {
        return value?.let {
            return formatter.parse(value, LocalDateTime::from)
        }
    }

    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }


}