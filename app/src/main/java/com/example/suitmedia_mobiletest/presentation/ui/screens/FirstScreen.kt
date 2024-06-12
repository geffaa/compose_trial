package com.example.suitmedia_mobiletest.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.suitmedia_mobiletest.R
import com.example.suitmedia_mobiletest.presentation.components.showDialog
import com.example.suitmedia_mobiletest.presentation.viewmodel.FirstViewModel
import com.example.suitmedia_mobiletest.presentation.viewmodel.FirstViewModelFactory
import com.example.suitmedia_mobiletest.domain.usecase.CheckPalindromeUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navigateToSecondScreen: () -> Unit,
    checkPalindromeUseCase: CheckPalindromeUseCase
) {
    val viewModel: FirstViewModel = viewModel(
        factory = FirstViewModelFactory(checkPalindromeUseCase)
    )
    var name by remember { mutableStateOf("") }
    var sentence by remember { mutableStateOf("") }
    val isPalindrome by viewModel.isPalindrome.collectAsState()

    var dialogVisible by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = "Icon",
            modifier = Modifier
                .size(120.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = sentence,
            onValueChange = { newSentence ->
                sentence = newSentence
                viewModel.checkPalindrome(newSentence)
            },
            label = { Text("Sentence") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                dialogMessage = if (isPalindrome) "isPalindrome" else "not palindrome"
                dialogVisible = true
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B637B)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B637B)),
            onClick = navigateToSecondScreen,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }

        showDialog(
            isVisible = dialogVisible ?: false,
            message = dialogMessage,
            onDismiss = { dialogVisible = false }
        )
    }
}
