package com.brunocardoso.traineeme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.brunocardoso.traineeme.repository.database.dao.GenderDao
import com.brunocardoso.traineeme.repository.database.AppDatabase
import com.brunocardoso.traineeme.view.GenderFragment

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var genderDao: GenderDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, GenderFragment()).commit()

    }
}
