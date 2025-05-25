package com.ucb.ucbtest.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ucb.ucbtest.R
import com.ucb.ucbtest.home.model.Plan
import com.ucb.ucbtest.navigation.Screen

@Composable
fun PlanCard(
    plan: Plan,
    onNext: () -> Unit,
    onPrev: () -> Unit,
    onWhatsapp: () -> Unit,
    navController: NavHostController

) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp)
                .border(1.dp, Color(0xFFEC7767).copy(alpha = 0.2f), RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título (sin cambios en contenido)
            Text(
                plan.nombre,
                fontSize = 22.sp,
                color = Color(0xFFEC7767),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Precio anterior (mejorado visualmente)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Antes ", fontSize = 14.sp, color = Color.Gray)
                Text(
                    plan.precioAntes,
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Gray
                    ),
                    fontSize = 14.sp
                )
                Text("/mes", fontSize = 14.sp, color = Color.Gray)
            }

            // Precio actual (mejor contraste)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Ahora ", fontSize = 16.sp, color = Color(0xFFEC7767))
                Text(
                    plan.precioAhora,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEC7767)
                )
                Text("/mes", fontSize = 14.sp, color = Color(0xFFEC7767))
            }

            // Datos (más destacado)
            Text(
                plan.datos,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Spacer(Modifier.width(14.dp))
            // Beneficios (mejor espaciado)
            Column(modifier = Modifier.fillMaxWidth()) {
                plan.beneficios.forEach {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 6.dp)
                    ) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = null,
                            tint = Color(0xFF000000),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(it, fontSize = 14.sp)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Iconos (mejor presentación)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                val icons = listOf(
                    R.drawable.ic_facebook,
                    R.drawable.ic_instagram,
                    R.drawable.ic_messenger,
                    R.drawable.ic_snapchat,
                    R.drawable.ic_telegram,
                    R.drawable.ic_whatsapp,
                    R.drawable.ic_x,
                )

                icons.forEach { icon ->
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Botón (más atractivo)
            Button(
                onClick = {
                    navController.navigate(Screen.PlanFormScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEC7767),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Quiero este plan")
            }
        }

        // Flechas de navegación (más visibles)
        IconButton(
            onClick = onPrev,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .background(Color(0xFFEC7767), CircleShape)
                .size(25.dp)
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Anterior",
                tint = Color(0xFFFFFFFF)
            )
        }

        IconButton(
            onClick = onNext,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .background(Color(0xFFEC7767), CircleShape)
                .size(25.dp)
        ) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Siguiente",
                tint = Color(0xFFFFFFFF)
            )

        }
    }
}