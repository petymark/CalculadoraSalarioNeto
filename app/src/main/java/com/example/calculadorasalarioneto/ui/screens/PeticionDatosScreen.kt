package com.example.calculadorasalarioneto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PeticionDatosScreen(navController: NavHostController) {
    var salario by remember { mutableStateOf("") }
    var pagas by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var grupoProfesional by remember { mutableStateOf("") }
    var discapacidad by remember { mutableStateOf(false) }
    var estadoCivil by remember { mutableStateOf("Soltero") }
    var hijos by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = salario,
            onValueChange = { salario = it },
            label = { Text("Salario Bruto Anual") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = pagas,
            onValueChange = { pagas = it },
            label = { Text("Número de Pagas") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grupoProfesional,
            onValueChange = { grupoProfesional = it },
            label = { Text("Grupo Profesional") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = discapacidad, onCheckedChange = { discapacidad = it })
            Text(text = "Grado de Discapacidad")
        }
        OutlinedTextField(
            value = hijos,
            onValueChange = { hijos = it },
            label = { Text("Número de Hijos") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Cálculos simulados
                val salarioBruto = salario.toDoubleOrNull() ?: 0.0
                val retencionIRPF = salarioBruto * 0.15 // Retención simulada: 15%
                val deducciones = 500.0 // Deducciones simuladas
                val salarioNeto = salarioBruto - retencionIRPF - deducciones

                navController.navigate(
                    "resultados/$salarioBruto/$salarioNeto/$retencionIRPF/$deducciones"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular y Ver Resultados")
        }
    }
}


