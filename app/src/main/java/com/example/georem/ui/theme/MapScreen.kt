package com.example.georem.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState

@Composable
fun MapScreen(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // Set the height for the map
    ) {
        MapboxMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    zoom(10.0)
                    center(Point.fromLngLat(-98.0, 39.5))
                    pitch(0.0)
                    bearing(0.0)
                }
            }
        )
    }
}