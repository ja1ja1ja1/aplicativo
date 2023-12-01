package com.example.apptodaytask


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen2(navController:NavHostController) {


    val cursosDisponiveis = listOf("Administração", "Informática", "Gastronomia")

    val cursosSelecionados = remember { mutableStateListOf<String>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nossos Cursos") },
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

            Text(text = "Cursos Disponíveis:")
            cursosDisponiveis.forEach { curso ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Checkbox(
                        checked = cursosSelecionados.contains(curso),
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                cursosSelecionados.add(curso)
                            } else {
                                cursosSelecionados.remove(curso)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = curso)
                }
            }




            Button(onClick = {navController.popBackStack()}) {
                Text(text = "Voltar para cadastro")
            }

        }
    }
}