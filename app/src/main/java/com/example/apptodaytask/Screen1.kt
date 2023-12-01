package com.example.apptodaytask

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen1(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cadastro Aluno") },
                backgroundColor = Color(333)
            )
        }

    ) {
        // Screen content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()

        ) {


            val nome = remember { mutableStateOf("") }
            val email = remember { mutableStateOf("") }
            val senha = remember { mutableStateOf("") }

            Text(text = "Nome:")
            TextField(
                value = nome.value,
                onValueChange = { newName -> nome.value = newName },
                label = { Text("Digite seu nome") }
            )

            Text(text = "E-mail:")
            TextField(
                value = email.value,
                onValueChange = { newEmail -> email.value = newEmail },
                label = { Text("Digite seu e-mail") }
            )

            Text(text = "Senha:")
            TextField(
                value = senha.value,
                onValueChange = { newSenha -> senha.value = newSenha },
                label = { Text("Digite sua senha") },
                visualTransformation = PasswordVisualTransformation()
            )


            Text(text = "Clique para tela de cursos:")
            Button(onClick = {navController.navigate(Destination.ScreenSecond.route)}) {
                Text(text = "Next")
            }
            }


            }

        }


