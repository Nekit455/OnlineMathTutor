package com.example.onlinemathtutor.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.border
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    var searchCategory by remember { mutableStateOf("ФИО") }
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFD8ECF3))) {
        Spacer(modifier = Modifier.height(50.dp))
        // Верхний бар
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF21A4DF))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color(68, 45, 93))
                    .clickable { navController.navigate("mainScreen")}
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("π", fontSize = 26.sp, color = Color.White,
                    fontWeight = FontWeight.Bold)
            }
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier
                    .clickable {navController.navigate("profileScreen") },
                tint = Color.Black
            )
        }

        Text(
            "Онлайн-репетиторство по математике",
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(70.dp))
        Divider(color = Color.Black, thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 8.dp))

        // Поиск репетитора
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), // Отступы для всей строки
            verticalAlignment = Alignment.CenterVertically, // Выравнивание по вертикали
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Расстояние между элементами
        ) {
            // Текст "Поиск по:"
            Text(
                text = "Поиск по:",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp) // Отступ справа от текста
            )

            // Выпадающий список для выбора варианта поиска
            DropdownMenuDemo(
                selectedOption = searchCategory,
                onOptionSelected = { searchCategory = it },
                //modifier = Modifier.width(150.dp) // Задаем ширину вручную
            )
        }
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Поиск...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),

        )

        Spacer(modifier = Modifier.height(10.dp))

        // Список репетиторов
        Text("Доступные репетиторы:", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
        TutorCard("Иванов Петр Алексеевич", "700 р/час, 10-11 классы")
        TutorCard("Силин Александр Николаевич", "750 р/час, 5-6 классы")
        TutorCard("Махов Владимир Сергеевич", "750 р/час, 8-9 классы")
    }
}

@Composable
fun DropdownMenuDemo(selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("ФИО", "Цена", "Класс обучения")

    Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 255, 255), // Цвет фона кнопки
                contentColor = Color.Black // Цвет текста на кнопке
            )

        ) {
            Text(selectedOption)
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) }, // Передаем текст через лямбду
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    interactionSource = remember { MutableInteractionSource() }
                )
            }
        }
    }
}

@Composable
fun TutorCard(name: String, details: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(130.dp) // Фиксированная высота карточки
            .padding(8.dp)
            .border( // Добавляем границу
                width = 2.dp,
                color = Color.Black,
                //shape = RoundedCornerShape(8.dp) // Форма границы
            ),
            //.background(Color(69, 240, 146)),
        colors = CardDefaults.cardColors(
            containerColor = Color(69, 240, 146) // Цвет фона карточки
        ),
        //shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween // Распределяет пространство между элементами
        ) {
            // Имя репетитора
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )

            // Описание и кнопка
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween, // Распределяет пространство по горизонтали
                verticalAlignment = Alignment.CenterVertically // Выравнивает элементы по вертикали
            ) {
                Text(
                    text = details,
                    fontSize = 14.sp
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(38, 124, 78), // Цвет фона кнопки
                        contentColor = Color.White // Цвет текста на кнопке
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp) // Отступ слева от кнопки
                ) {
                    Text("Записаться")
                }
            }
        }
    }
}

