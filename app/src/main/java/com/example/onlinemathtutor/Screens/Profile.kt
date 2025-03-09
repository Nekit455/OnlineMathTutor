package com.example.onlinemathtutor.Screens

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun ProfileScreen(navController: NavController) {
    var role by remember { mutableStateOf("ученик")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8ECF3)),
            //.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(navController)
        Spacer(modifier = Modifier.height(16.dp))
        if (role == "репетитор") {
            TutorProfile(navController) // Профиль репетитора
        } else {
            StudentProfile(navController) // Профиль ученика
        }
    }
}

@Composable
fun Header(navController: NavController) {
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

                // Кнопка "Выйти"
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50)) // Скругление углов
                        .background(Color(34, 27, 120)) // Синий фон
                        .clickable { navController.navigate("registrationScreen")} // Обработка нажатия на "Выйти"
                        .padding(horizontal = 14.dp, vertical = 3.dp) // Внутренние отступы
                ) {
                    Text("Выйти", fontSize = 14.sp, color = Color.White)
                }
            }

        }
    }
}

@Composable
fun StudentProfile(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.Top // Выравнивание по верхнему краю
    ) {
        // Изображение профиля и информация
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Изображение профиля в квадрате с белым фоном и черным бордюром
            Box(
                modifier = Modifier
                    .size(100.dp) // Размер квадрата
                    .background(Color.White, RoundedCornerShape(8.dp)) // Белый фон и скругленные углы
                    .border( // Черный бордюр
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp), // Внутренние отступы
                contentAlignment = Alignment.Center // Центрирование содержимого
            ) {
                Icon(
                    imageVector = Icons.Default.Person, // Используем стандартную иконку
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(80.dp) // Размер иконки
                        .clip(CircleShape), // Круглая форма иконки
                    tint = Color.Gray // Цвет иконки
                )
            }

            Spacer(modifier = Modifier.height(16.dp)) // Отступ между изображением и информацией

            // Информация о профиле
            ProfileDetails()
        }

        // Кнопка "Задания"
        Button(
            onClick = { navController.navigate("tasksScreen") }, // Переход на экран заданий
            colors = ButtonDefaults.buttonColors(containerColor = Color(68, 178, 91)), // Зеленый фон
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp) // Отступ слева от кнопки
        ) {
            Text("Задания", color = Color.White, fontSize = 20.sp)
        }


    }
    Spacer(modifier = Modifier.height(16.dp))

    Divider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 3.dp, bottom = 16.dp)
    )

    Box(
        modifier = Modifier.fillMaxSize(), // Занимает весь доступный размер
        contentAlignment = Alignment.TopStart // Контент выравнивается в левый верхний угол
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart) // Выравнивание Column влево
        ) {
            Text("Записи к репетиторам:", color = Color.Black, fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.height(16.dp))

            TutorCard1("Иванов Петр Алексеевич", "700 р/час",
                onClick = {
                    // Переход на экран профиля репетитора
                    navController.navigate("checkProfile")
                })
            TutorCard1("Силин Александр Николаевич", "750 р/час",
                onClick = {
                    // Переход на экран профиля репетитора
                    navController.navigate("checkProfile")
                })
        }
    }
}

@Composable
fun TutorProfile(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.Top // Выравнивание по верхнему краю
    ) {
        // Изображение профиля и информация
        Column(
            modifier = Modifier.weight(1f) // Занимает оставшееся пространство
        ) {
            // Изображение профиля в квадрате с белым фоном и черным бордюром
            Box(
                modifier = Modifier
                    .size(100.dp) // Размер квадрата
                    .background(Color.White, RoundedCornerShape(8.dp)) // Белый фон и скругленные углы
                    .border( // Черный бордюр
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp), // Внутренние отступы
                contentAlignment = Alignment.Center // Центрирование содержимого
            ) {
                Icon(
                    imageVector = Icons.Default.Person, // Используем стандартную иконку
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(80.dp) // Размер иконки
                        .clip(CircleShape), // Круглая форма иконки
                    tint = Color.Gray // Цвет иконки
                )
            }

            Spacer(modifier = Modifier.height(16.dp)) // Отступ между изображением и информацией

            // Информация о профиле
            ProfileDetails()
        }

        // Кнопка "Задания"
        Button(
            onClick = { navController.navigate("tasksScreen") }, // Переход на экран заданий
            colors = ButtonDefaults.buttonColors(containerColor = Color(68, 178, 91)), // Зеленый фон
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp) // Отступ слева от кнопки
        ) {
            Text("Задания", color = Color.White, fontSize = 20.sp)
        }


    }
    Spacer(modifier = Modifier.height(16.dp))

    Divider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 3.dp, bottom = 1.dp)
    )

    // Список учеников и заявки учеников
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Список учеников
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally // Центрирование карточек
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Список учеников",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            StudentCard("Сидоров Алексей", "10 класс")
            StudentCard("Петрова Мария", "11 класс")
        }

        // Вертикальный разделитель
        VerticalDivider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 1.dp, bottom = 25.dp)
        )

        // Заявки
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally // Центрирование карточек
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Заявки",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ApplicationCard("Иванов Иван", "9 класс")
            ApplicationCard("Смирнова Анна", "10 класс")
        }
    }
}

@Composable
fun ProfileDetails() {
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

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .padding(start = 38.dp, top = 4.dp, bottom = 4.dp) // Отступы вокруг полоски
        )

        Spacer(modifier = Modifier.height(8.dp)) // Отступ между ФИО и e-mail

        // E-mail
        Text(
            text = "e-mail: example@mail.ru",
            modifier = Modifier.fillMaxWidth() // Занимает всю ширину
        )

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .padding(start = 44.dp, top = 4.dp, bottom = 4.dp) // Отступы вокруг полоски
        )

        Spacer(modifier = Modifier.height(8.dp)) // Отступ между e-mail и классами

        // Обучаемые классы
        Text(
            text = "Обучаемые классы: 10-11",
            modifier = Modifier.fillMaxWidth() // Занимает всю ширину
        )
        Spacer(modifier = Modifier.height(16.dp)) // Отступ перед кнопкой

        // Кнопка "Редактировать"
        Button(
            onClick = { /* Действие при нажатии на кнопку */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(68, 59, 134)), // Фиолетовый фон
            modifier = Modifier
                .padding(start = 8.dp, top = 1.dp, bottom = 1.dp) // Отступ слева
        ) {
            Text("Редактировать", color = Color.White)
        }
    }
}

@Composable
fun TutorCard1(name: String, details: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .height(110.dp) // Фиксированная высота карточки
            .padding(8.dp)
            .border( // Добавляем границу
                width = 2.dp,
                color = Color.Black,
                //shape = RoundedCornerShape(8.dp) // Форма границы
            )
            .clickable { onClick() },
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

            }
        }
    }
}

@Composable
fun StudentCard(name: String, grade: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp) // Фиксированная высота карточки
            .padding(vertical = 8.dp)
            .border( // Добавляем границу
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(1.dp) // Форма границы
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(69, 240, 146)
        ), // Цвет фона карточки
        shape = RoundedCornerShape(1.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = grade,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ApplicationCard(name: String, grade: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp) // Фиксированная высота карточки
            .padding(vertical = 8.dp)
            .border( // Добавляем границу
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(1.dp) // Форма границы
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(255, 193, 7) // Желтый цвет фона карточки
        ),
        shape = RoundedCornerShape(1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = grade,
                fontSize = 14.sp
            )
        }
    }
}