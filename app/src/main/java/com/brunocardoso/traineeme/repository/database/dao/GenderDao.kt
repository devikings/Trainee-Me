package com.brunocardoso.traineeme.repository.database.dao

import android.arch.persistence.room.*
import com.brunocardoso.traineeme.repository.data.Gender
import io.reactivex.Single

@Dao
interface GenderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGender(gender: Gender)

    @Update
    fun updateGender(gender: Gender)

    @Delete
    fun deleteGender(gender: Gender)

    @Query("SELECT * FROM Gender WHERE name == :name")
    fun getGenderByName(name: String): List<Gender>

    @Query("SELECT * FROM Gender")
    fun getGenders(): Single<List<Gender>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(genders: List<Gender>)

}