//package com.example.georem.data
//
//import androidx.room.*
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface ReminderDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertReminder(reminder: Reminder)
//
//    @Query("SELECT * FROM reminder WHERE id = :id")
//    suspend fun getReminderById(id: Int): Reminder?
//
//    @Query("SELECT * FROM reminders")
//    fun getAllReminders(): Flow<List<Reminder>>
//
//    @Delete
//    suspend fun delete(reminder: Reminder)
//
//    @Query("DELETE FROM reminders")
//    suspend fun deleteAll()
//}