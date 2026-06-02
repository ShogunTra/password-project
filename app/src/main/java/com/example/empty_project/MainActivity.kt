package com.example.empty_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.empty_project.ui.theme.EmptyprojectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            EmptyprojectTheme {
                PasswordGeneratorScreen()
            }
        }
    }
}

@Composable
fun PasswordGeneratorScreen() {

    var length by remember { mutableStateOf("12") }

    var digits by remember { mutableStateOf(true) }

    var symbols by remember { mutableStateOf(true) }

    var uppercase by remember { mutableStateOf(true) }

    var password by remember { mutableStateOf("") }

    val generator = PasswordGenerator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedTextField(
            value = length,
            onValueChange = { length = it },
            label = { Text("Длина пароля") }
        )

        Row {
            Checkbox(
                checked = digits,
                onCheckedChange = { digits = it }
            )
            Text("Цифры")
        }

        Row {
            Checkbox(
                checked = symbols,
                onCheckedChange = { symbols = it }
            )
            Text("Спецсимволы")
        }

        Row {
            Checkbox(
                checked = uppercase,
                onCheckedChange = { uppercase = it }
            )
            Text("Заглавные буквы")
        }

        Button(
            onClick = {

                val len = length.toIntOrNull() ?: 12

                password = generator.generate(
                    len,
                    digits,
                    symbols,
                    uppercase
                )
            }
        ) {
            Text("Сгенерировать")
        }

        Text(
            text = password,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}