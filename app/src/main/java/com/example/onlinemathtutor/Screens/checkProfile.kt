package com.example.onlinemathtutor.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle
import androidx.navigation.NavController

@Composable
fun CheckProfile(navController: NavController) {
    var role by remember { mutableStateOf("ученик") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8ECF3)),
        //.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderC(navController)
        Spacer(modifier = Modifier.height(16.dp))

        CheckSomeProfile(navController)

    }
}

@Composable
fun HeaderC(navController: NavController) {
    Spacer(modifier = Modifier.height(50.dp))
    Surface(
        modifier = Modifier.fillMaxWidth(), // Растягиваем на всю ширину
        color = Color(0xFF21A4DF) // Синий фон
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth() // Растягиваем на всю ширину
                .padding(horizontal = 16.dp, vertical = 8.dp), // Отступы внутри шапки
            verticalAlignment = Alignment.CenterVertically, // Выравнивание по вертикали
            horizontalArrangement = Arrangement.SpaceBetween // Распределение пространства между элементами
        ) {

            // Логотип "π"
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color(68, 45, 93))
                    .clickable { navController.navigate("mainScreen") }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "π",
                    fontSize = 26.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Кнопка "Назад"
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50)) // Скругление углов
                        .background(Color(34, 27, 120)) // Синий фон
                        .clickable { navController.popBackStack() } // Возврат на предыдущий экран
                        .padding(horizontal = 14.dp, vertical = 3.dp) // Внутренние отступы
                ) {
                    Text("Назад", fontSize = 14.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp)) // Отступ между кнопками

            }

        }
    }
}

@Composable
fun CheckSomeProfile(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            // Изображение профиля
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    tint = Color.Gray
                )
            }

            // Текст справа от изображения
            Column(
                modifier = Modifier
                    .padding(start = 16.dp) // Отступ слева от изображения
                    .align(Alignment.CenterVertically) // Выравнивание по центру вертикально
            ) {
                // Имя и фамилия
                Text(
                    text = "Иванов Петр",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
                // Отчество на новой строке
                Text(
                    text = "Алексеевич",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
            }
        }

        // Кнопка "Чат" в правом нижнем углу
        Button(
            onClick = { navController.navigate("chatScreen") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(153, 161, 155),
                contentColor = Color.Black),
            modifier = Modifier
                .align(Alignment.BottomEnd) // Выравниваем кнопку по нижнему правому углу
                .padding(bottom = 16.dp) // Отступ снизу, чтобы кнопка была над Divider
        ) {
            Text("Чат", color = Color.Black, fontSize = 16.sp)
        }


    }

    Spacer(modifier = Modifier.height(100.dp))

    Divider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 3.dp, bottom = 16.dp)
    )
    // Информация о профиле
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp) // Смещение текста вправо на 8 dp
    ) {
        CheckProfileDetails()
    }
}

@Composable
fun CheckProfileDetails() {
    Spacer(modifier = Modifier.height(27.dp))
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // ФИО
        Text(
            text = "ФИО: Иванов Петр Алексеевич",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(), // Занимает всю ширину
            maxLines = 1, // Ограничение в одну строку
        )

        Spacer(modifier = Modifier.height(8.dp)) // Отступ между ФИО и e-mail

        // E-mail
        Text(
            text = "e-mail: example@mail.ru",
            modifier = Modifier.fillMaxWidth() // Занимает всю ширину
        )


        Spacer(modifier = Modifier.height(8.dp)) // Отступ между e-mail и классами

        // Обучаемые классы
        Text(
            text = "Обучаемые классы: 10-11",
            modifier = Modifier.fillMaxWidth() // Занимает всю ширину
        )

    }
}