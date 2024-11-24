package com.example.calculadorasalarioneto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultadosScreen(
    salarioBruto: String,
    salarioNeto: String,
    retencionIRPF: String,
    deducciones: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Resultados", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Salario Bruto: $salarioBruto €")
        Text(text = "Retención IRPF: $retencionIRPF €")
        Text(text = "Deducciones: $deducciones €")
        Text(text = "Salario Neto: $salarioNeto €")
    }
}


