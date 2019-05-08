package com.brunocardoso.traineeme

import android.app.Application
import com.brunocardoso.traineeme.repository.database.dao.GenderDao
import com.brunocardoso.traineeme.repository.database.AppDatabase

class App: Application() {

    companion object {
        private lateinit var appDatabase: AppDatabase
        private lateinit var genderDao: GenderDao

        fun getGenderDAO() = genderDao
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = AppDatabase.getAppDataBase(applicationContext)!!
    }
}