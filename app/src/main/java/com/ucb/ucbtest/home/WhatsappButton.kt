package com.ucb.ucbtest.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ucb.ucbtest.R

@Composable
fun WhatsappButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val message = "Hola, UCB mobile, preciso su ayuda"
    val url = "https://wa.me/?text=${Uri.encode(message)}"

    Image(
        painter = painterResource(id = R.drawable.ic_whatsapp), // usa tu ícono real aquí
        contentDescription = "WhatsApp",
        modifier = modifier
            .size(64.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                }
                context.startActivity(intent)
            },
        colorFilter = ColorFilter.tint(Color(0xFF25D366))
    )
}
