package com.example.proyectodivisa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectodivisa.model.Divisa

@Dao
interface DivisasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(exchangeRates: List<Divisa>)

    @Query("SELECT * FROM Divisas WHERE date = :date")
    suspend fun getExchangeRatesByDate(date: Long): List<Divisa>
}