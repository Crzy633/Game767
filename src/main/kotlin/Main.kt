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
import androidx.compose.ui.window.*
import androidx.compose.ui.zIndex
import game.GameCanvas
import ui.Login
import ui.TitleBar
import ui.widget.Alert

@Composable
@Preview
fun App(window: FrameWindowScope) {
    MaterialTheme {
        Surface (color = Color(0xDDDDDDDD), shape = RoundedCornerShape(2.dp)) {
            Box (Modifier.fillMaxSize()) {
                TitleBar(window, Modifier.align(Alignment.TopEnd).zIndex(999f))
                Login(Modifier.align(Alignment.Center))
                GameCanvas()
            }
            Alert.Stub()
        }
    }
}

fun main() = application {
    Window(
        state = rememberWindowState(size = DpSize(800.dp, 640.dp), position = WindowPosition(Alignment.CenterStart)),
        undecorated = true,
        transparent = true,
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        App(this)
    }
}
