package com.example.suitmedia_mobiletest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.suitmedia_mobiletest.domain.usecase.CheckPalindromeUseCase

class FirstViewModelFactory(private val checkPalindromeUseCase: CheckPalindromeUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FirstViewModel(checkPalindromeUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
