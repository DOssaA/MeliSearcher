package com.darioossa.melitest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.DarkGray,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.DarkGray,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 18.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Light,
        color = Color.DarkGray,
        fontSize = 12.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)