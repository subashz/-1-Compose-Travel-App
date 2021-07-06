package com.example.travelapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.example.travelapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
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

val OverPassFontFamily = FontFamily(
    Font(R.font.overpass_black, FontWeight.Black),
    Font(R.font.overpass_bold, FontWeight.Bold),
    Font(R.font.overpass_extra_bold, FontWeight.ExtraBold),
    Font(R.font.overpass_extra_light, FontWeight.ExtraLight),
    Font(R.font.overpass_light, FontWeight.Light),
    Font(R.font.overpass_regular, FontWeight.Normal),
    Font(R.font.overpass_semi_bold, FontWeight.SemiBold),
    Font(R.font.overpass_thin, FontWeight.Thin),
)