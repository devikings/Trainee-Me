package com.brunocardoso.traineeme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.brunocardoso.traineeme.dao.GenderDao
import com.brunocardoso.traineeme.database.AppDatabase
import com.brunocardoso.traineeme.models.Gender
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var genderDao: GenderDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.fromCallable({
            db = AppDatabase.getAppDataBase(context = this)
            genderDao = db?.genderDao()

            var gender1 = Gender(name = "Male")
            var gender2 = Gender(name = "Female")

            with(genderDao){
                this?.insertGender(gender1)
                this?.insertGender(gender2)
            }
            db?.genderDao()?.getGenders()

        }).doOnNext({ list ->
            var finalString = ""
            list?.map { finalString+= it.name+" - " }
            tv_message.text = finalString

        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }
}
