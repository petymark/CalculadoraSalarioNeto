package com.example.calculadorasalarioneto.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Definimos los colores para el tema oscuro
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
)

// Definimos los colores para el tema claro
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
)

// Función que aplica el tema
@Composable
fun CalculadoraSalarioNetoTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    // Se elige el esquema de colores basado en el parámetro darkTheme
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    // Aplicamos el tema a la aplicación
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
