package com.example.suitmedia_mobiletest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.suitmedia_mobiletest.domain.usecase.CheckPalindromeUseCase

class FirstViewModel(private val checkPalindromeUseCase: CheckPalindromeUseCase) : ViewModel() {

    private val _isPalindrome = MutableStateFlow(false)
    val isPalindrome: StateFlow<Boolean> = _isPalindrome

    fun checkPalindrome(sentence: String) {
        viewModelScope.launch {
            _isPalindrome.value = checkPalindromeUseCase.isPalindrome(sentence)
        }
    }
}