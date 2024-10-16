package com.example.gestion_rrhh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuRecursosHumanos()
        }
    }
}

@Composable
fun MenuRecursosHumanos() {
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

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                items(tablas.size) { index ->
                    OpcionMenu(tablas[index]) {
                        println("Se seleccionó: ${tablas[index]}")
                    }
                }
            }
        }
    }
}

@Composable
fun OpcionMenu(tabla: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F934A)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = tabla, fontSize = 18.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuRecursosHumanos() {
    MenuRecursosHumanos()
}
