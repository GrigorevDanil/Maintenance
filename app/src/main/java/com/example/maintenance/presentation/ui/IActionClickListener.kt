package com.example.maintenance.presentation.ui


interface IActionClickListener<T> {
    fun delete(item: T)
    fun update(item: T)
}