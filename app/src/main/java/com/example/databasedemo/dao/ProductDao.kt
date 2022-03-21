package com.example.databasedemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.databasedemo.entity.Product

@Dao
interface ProductDao {
    @Insert
    fun addProduct(product: Product)

    @Query("Select * from ProductTable")
    fun getAll(): List<Product>

    @Query("Select * from ProductTable Where price <= :maxPrice")
    fun getPriceRange(maxPrice :Double): List<Product>
}