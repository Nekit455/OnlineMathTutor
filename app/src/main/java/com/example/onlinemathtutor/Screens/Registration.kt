package com.example.onlinemathtutor.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Registration(navController: NavController) {
    // Состояние для переключения между регистрацией и авторизацией
    var isRegistering by remember { mutableStateOf(true) }

    // var role by remember { mutableStateOf("ученик") }
    var fullName by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD6EAF8)) // Светло-голубой фон
            .padding(start = 16.dp, top = 90.dp, end = 16.dp, bottom = 0.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF03A9F4), RoundedCornerShape(8.dp)) // Заголовок с синим фоном
                .padding(vertical = 20.dp)
        ) {
            Text(
                text = if (isRegistering) "Регистрация" else "Вход",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Если мы на экране регистрации, добавляем поле для ФИО
        if (isRegistering) {
            Text(text = "роль:", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(3.dp))
            DropdownMenuBox(selectedRole = "ученик", onRoleSelected = { })
            Spacer(modifier = Modifier.height(13.dp))
            InputField(label = "ФИО:", value = fullName, onValueChange = { fullName = it })
            Spacer(modifier = Modifier.height(5.dp))
        }
        if (!isRegistering) {
            Spacer(modifier = Modifier.height(48.dp))
        }

        InputField(label = "e-mail:", value = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(5.dp))

        InputField(label = "пароль:", value = password, onValueChange = { password = it }, isPassword = true)
        Spacer(modifier = Modifier.height(5.dp))

        Spacer(modifier = Modifier.height(45.dp))

        // Кнопка регистрации
        Button(
            onClick = { navController.navigate("mainScreen")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF)), // Темно-синий цвет
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = if (isRegistering) "Зарегистрироваться" else "Войти", color = Color.White)
        }

        Spacer(modifier = Modifier.height(65.dp))

        // Текст "Уже есть аккаунт?"
        Text(
            text = if (isRegistering) "Уже есть аккаунт?" else "Нет аккаунта?",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Кнопка входа
        Button(
            onClick = { isRegistering = !isRegistering },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF)), // Темно-синий цвет
            modifier = Modifier
                .width(140.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = if (isRegistering) "Вход" else "Регистрация", color = Color.White)
        }
    }
}

// Компонент для текстового поля
@Composable
fun InputField(label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit, isPassword: Boolean = false) {
    Column {
        Text(text = label, fontSize = 16.sp)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
    }
}

// Компонент для выбора роли
@Composable
fun DropdownMenuBox(selectedRole: String, onRoleSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { expanded = true },
            modifier = Modifier
                .width(250.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = selectedRole, color = Color.Black)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("ученик") },
                onClick = {
                    onRoleSelected("ученик")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("репетитор") },
                onClick = {
                    onRoleSelected("репетитор")
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    val navController = rememberNavController()
    Registration(navController = navController)
}


