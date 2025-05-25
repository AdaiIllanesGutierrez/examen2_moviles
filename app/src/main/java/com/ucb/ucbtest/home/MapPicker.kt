package com.ucb.ucbtest.home

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.*
import com.google.android.gms.maps.model.LatLng
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun MapPicker(
    lat: Double?,
    lng: Double?,
    onLocationPicked: (Double, Double) -> Unit
) {
    val initialPosition = LatLng(lat ?: -17.39, lng ?: -66.15)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialPosition, 12f)
    }
    val markerState = rememberMarkerState(position = initialPosition)

    GoogleMap(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        cameraPositionState = cameraPositionState,
        onMapClick = { latLng ->
            markerState.position = latLng
            onLocationPicked(latLng.latitude, latLng.longitude)
            // Mover la cámara al nuevo punto
            cameraPositionState.move(
                CameraUpdateFactory.newLatLng(latLng)
            )
        }
    ) {
        Marker(state = markerState)

    }
}
