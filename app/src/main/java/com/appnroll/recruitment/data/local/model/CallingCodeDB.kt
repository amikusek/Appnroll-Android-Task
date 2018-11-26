package com.appnroll.recruitment.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "country_calling_codes",
        foreignKeys =
        [ForeignKey(entity = CountryDB::class,
                parentColumns = ["id"],
                childColumns = ["countryId"],
                onDelete = CASCADE)])
data class CallingCodeDB(val code: String,
                         val countryId: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
