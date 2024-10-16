package com.example.gestion_rrhh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenuRecursosHumanos()
        }
    }
}

@Composable
fun MenuRecursosHumanos() {
    // Lista de tablas como opciones de menú
    val tablas = listOf(
        "Registro del Personal",
        "Datos del Contrato",
        "Beneficios",
        "Desempeño por Empleado",
        "Control de Asistencias",
        "Tareas"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Menú de Recursos Humanos", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // Iterar sobre las tablas para crear botones
        for (tabla in tablas) {
            OpcionMenu(tabla) {
                // Aquí puedes gestionar la acción cuando una tabla es seleccionada
                println("Se seleccionó: $tabla")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre los botones
        }
    }
}

@Composable
fun OpcionMenu(tabla: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(text = tabla, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuRecursosHumanos() {
    MenuRecursosHumanos()
}