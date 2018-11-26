package com.appnroll.recruitment.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "country_currencies")
data class CurrencyDB(@PrimaryKey val id: String,
                      val name: String)
