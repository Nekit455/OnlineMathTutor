package com.example.onlinemathtutor.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class TaskItem(
    val tutor: String,
    val section: String
)

@Composable
fun TasksScreen(navController: NavController) {
    var role by remember { mutableStateOf("ученик") }
    val taskItems = listOf(
        TaskItem("Репетитор 1", "Тригонометрия"),
        TaskItem("Репетитор 1", "название"),
        TaskItem("Репетитор 2", "название")
    )

    val lightBlue = Color(0xFFD8ECF3)
    val green = Color(0xFF6AB04C)
    val cardGreen = Color(0xFFBFD989)
    val buttonBlue = Color(0xFF3742FA)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBlue)
            .padding(top = 50.dp, bottom = 30.dp, start = 8.dp, end = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(green)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Задания",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterStart)
                )

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = buttonBlue),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = "Назад",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }

            // Task items
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(taskItems) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = cardGreen),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            // Информация о задании
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = item.tutor,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Text(
                                    text = "Раздел \"${item.section}\"",
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                            }

                            // Кнопка "Скрыть" для репетитора
                            if (role == "репетитор") {
                                Button(
                                    onClick = { /* Обработка "Скрыть" */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .width(100.dp)
                                        .align(Alignment.BottomEnd) // Смещаем в правый нижний угол
                                ) {
                                    Text(
                                        text = "Скрыть",
                                        color = Color.Black,
                                        fontSize = 14.sp // Уменьшаем размер текста
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

