package com.rakshit.koinforkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TABLE_Demo")

data class DemoModelClass(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: String,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    val status: String? = null
)