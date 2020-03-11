package com.rakshit.koinforkotlin.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rakshit.koinforkotlin.model.DemoModelClass

@Dao
interface DemoDAO {

    @Insert
    fun insertDetails(data: DemoModelClass)

    @Query("SELECT * FROM TABLE_Demo")
    fun allRelations(): List<DemoModelClass>

    @Query("DELETE FROM TABLE_Demo WHERE id = :id")
    fun deleteContact(id: Int)

    @Query("DELETE FROM TABLE_Demo")
    fun nukeTable()

}