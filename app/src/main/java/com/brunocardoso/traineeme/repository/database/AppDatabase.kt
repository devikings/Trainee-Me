package com.brunocardoso.traineeme.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.brunocardoso.traineeme.repository.data.*
import com.brunocardoso.traineeme.repository.database.dao.GenderDao
import com.brunocardoso.traineeme.repository.database.dao.UserDao
import com.brunocardoso.traineeme.utils.DateTypeConverter

@Database(entities = [User::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun UserDao(): UserDao
//    abstract fun genderDao(): GenderDao
//    abstract fun exerciseDao(): ExerciseDao
//    abstract fun routineDao(): RoutineDao
//    abstract fun traineeDao(): TraineeDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase?{
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "MyDB").build()
                }
            }

            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}