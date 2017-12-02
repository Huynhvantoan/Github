package com.toanit.core.react

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

fun <T, R> LiveData<T>.map(f: (T) -> R): LiveData<R> = Transformations.map(this, f)

fun <T, R> LiveData<T>.flatMap(f: (T) -> LiveData<R>): LiveData<R> = Transformations.switchMap(this, f)


/*use*/
//val items: LiveData<List<FoodItem>> = Transformations.map(foodsLiveData){ foods -> foods.map { food -> FoodItem(food) }}
//val item: LiveData<FoodItem> = Transformations.map(foodLiveData){food -> FoodItem(food)}

