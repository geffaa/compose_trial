package com.example.suitmedia_mobiletest.domain.usecase

class CheckPalindromeUseCase {
    fun isPalindrome(sentence: String): Boolean {
        val cleanedSentence = sentence.toLowerCase()
        return cleanedSentence == cleanedSentence.reversed()
    }
}