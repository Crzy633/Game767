package ui

import AppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import kotlin.system.exitProcess

/**
 * @author Parva
 * @since 2022/01/25
 */
@OptIn(ExperimentalUnitApi::class)
@Composable
fun TitleBar(window: FrameWindowScope, modifier: Modifier) {
    window.WindowDraggableArea(modifier.padding(5.dp)) {
        Row (Modifier.wrapContentWidth().height(24.dp).background(Color(0xBB333333))) {
            Text(
                text = "Game767",
                fontSize = TextUnit(10f, TextUnitType.Sp),
                color = Color.LightGray,
                modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 5.dp)
            )
            WindowButton(AppTheme.icons.minimize) { window.window.isMinimized = true }
            WindowButton(AppTheme.icons.close) { exitProcess(0) }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun WindowButton(icon: ImageVector, onClick: () -> Unit) {
    var hover by remember { mutableStateOf(false) }
    Box (
        modifier = Modifier.width(30.dp).fillMaxHeight()
            .background(color = if(hover) Color.Red else Color.Transparent)
            .pointerMoveFilter(
                onEnter = {
                    hover = true
                    true
                }, onExit = {
                    hover = false
                    true
                }
            ).clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color.LightGray,
            modifier = Modifier.size(12.dp).align(Alignment.Center)
        )
    }
}
