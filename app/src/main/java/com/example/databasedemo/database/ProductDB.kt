package com.example.databasedemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databasedemo.dao.ProductDao
import com.example.databasedemo.entity.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDB :RoomDatabase(){
    abstract val productDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: ProductDB? = null

        fun getInstance(context: Context): ProductDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductDB::class.java,
                        "Product_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
