package com.example.calculadorasalarioneto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculadorasalarioneto.ui.screens.PeticionDatosScreen
import com.example.calculadorasalarioneto.ui.screens.ResultadosScreen
import com.example.calculadorasalarioneto.ui.theme.CalculadoraSalarioNetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraSalarioNetoTheme {
                val navController = rememberNavController()
                Navegacion(navController = navController)
            }
        }
    }
}

@Composable
fun Navegacion(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "peticionDatos") {
        composable("peticionDatos") { PeticionDatosScreen(navController = navController) }
        composable("resultados/{salarioBruto}/{salarioNeto}/{retencionIRPF}/{deducciones}") { backStackEntry ->
            ResultadosScreen(
                salarioBruto = backStackEntry.arguments?.getString("salarioBruto") ?: "0",
                salarioNeto = backStackEntry.arguments?.getString("salarioNeto") ?: "0",
                retencionIRPF = backStackEntry.arguments?.getString("retencionIRPF") ?: "0",
                deducciones = backStackEntry.arguments?.getString("deducciones") ?: "0"
            )
        }
    }
}
