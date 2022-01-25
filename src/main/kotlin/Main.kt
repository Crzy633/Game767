// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.zIndex
import ui.TitleBar

@Composable
@Preview
fun App(window: FrameWindowScope) {
    MaterialTheme {
        Surface (color = Color(0x80ffffff), shape = RoundedCornerShape(2.dp)) {
            Box (Modifier.fillMaxSize()) {
                TitleBar(window, Modifier.align(Alignment.TopEnd).zIndex(999f))
            }
        }
    }
}

fun main() = application {
    Window(
        state = rememberWindowState(size = DpSize(800.dp, 640.dp)),
        undecorated = true,
        transparent = true,
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        App(this)
    }
}
