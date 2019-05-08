package com.brunocardoso.traineeme.repository

import android.util.Log
import com.brunocardoso.traineeme.App
import com.brunocardoso.traineeme.repository.database.dao.GenderDao
import com.brunocardoso.traineeme.repository.data.Gender
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

data class GenderRepository(var isCached: Boolean = false) {

    private lateinit var genderDao: GenderDao
    private lateinit var userAi

    init {
        genderDao = App.getGenderDAO()
    }
    companion object {
        private var instance: GenderRepository? = null

        fun getInstance(): GenderRepository? {
            if ( instance == null ){
                instance = GenderRepository()
            }
            return instance
        }
    }

    fun listAll(): List<Gender> {

//        if ( isCached ) return getGendersFromDb().

        return listOf()

    }

    fun getGendersFromDb(): Observable<List<Gender>> {

        return genderDao
                .getGenders()
                .filter { it.isNotEmpty() }
                .toObservable()
                .doOnNext {
                    Log.d("LOG","Dispatching ${it.size} users from DB...")
                }
    }

    fun getGendersFromApi(): Observable<List<Gender>> {
        return
    }

    fun storeGendersInDb(genders: List<Gender>) {
        Observable
            .fromCallable { genderDao.insertAll(genders) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.d("Log","Inserted ${genders.size} users from API in DB...")
            }
    }

}