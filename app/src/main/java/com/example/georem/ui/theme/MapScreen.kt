package com.example.georem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState

@Composable
fun MapScreen() {
    // TODO: Implement UI for map screen
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()
        .background(Color.Black)) {

        Spacer(modifier = Modifier.weight(1f))

        MapboxMap(
            Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .padding(10.dp),

            mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    zoom(2.0)
                    center(Point.fromLngLat(-98.0, 39.5))
                    pitch(0.0)
                    bearing(0.0)
                }
            },
        )
    }
}
