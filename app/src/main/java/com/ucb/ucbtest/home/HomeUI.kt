package com.ucb.ucbtest.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeUI(viewModel: HomeViewModel = hiltViewModel()) {
    val currentPlan by viewModel.currentPlan.collectAsState()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nuestros planes móviles", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = androidx.compose.ui.graphics.Color(0xFFE64848))
            Text("La mejor cobertura, increíbles beneficios\ny un compromiso con el planeta.", fontSize = 14.sp, color = androidx.compose.ui.graphics.Color.Gray, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(16.dp))

            PlanCard(
                plan = currentPlan,
                onNext = { viewModel.nextPlan() },
                onPrev = { viewModel.prevPlan() },
                onWhatsapp = { openWhatsapp(context) }
            )
        }

        WhatsappButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

fun openWhatsapp(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("https://wa.me/?text=Hola,%20UCB%20mobile,%20preciso%20su%20ayuda")
    }
    context.startActivity(intent)
}
