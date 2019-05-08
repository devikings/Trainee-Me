package com.brunocardoso.traineeme.repository.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.brunocardoso.traineeme.repository.data.User
import io.reactivex.Observable
import java.util.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserAll(users: List<User>)

    @Query("SELECT * FROM users")
    fun getUsers(): Observable<List<User>>

}