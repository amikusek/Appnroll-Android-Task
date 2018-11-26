package com.appnroll.recruitment.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryDB(@PrimaryKey val id: String,
                     val name: String,
                     val flagUrl: String)