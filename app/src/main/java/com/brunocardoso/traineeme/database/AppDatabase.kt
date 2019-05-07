package com.brunocardoso.traineeme.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.brunocardoso.traineeme.dao.GenderDao
import com.brunocardoso.traineeme.models.Exercise
import com.brunocardoso.traineeme.models.Gender
import com.brunocardoso.traineeme.models.Routine
import com.brunocardoso.traineeme.models.Trainee
import com.brunocardoso.traineeme.utils.DateTypeConverter

@Database(entities = [Exercise::class, Gender::class, Routine::class, Trainee::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun genderDao(): GenderDao
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