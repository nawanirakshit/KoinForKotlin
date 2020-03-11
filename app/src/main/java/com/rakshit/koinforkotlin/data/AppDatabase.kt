package com.rakshit.koinforkotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rakshit.koinforkotlin.model.DemoModelClass
import com.rakshit.koinforkotlin.data.AppDatabase.Companion.DB_VERSION

@Database(
    entities = [
        DemoModelClass::class
    //Comma Seprated other classes
    ],
    version = DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMedicineDao(): DemoDAO

    companion object {
        const val DB_VERSION = 13
        private const val DB_NAME = "MMH_DATABASE"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}