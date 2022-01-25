package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import manager.UserManager
import java.awt.Cursor

/**
 * @author Parva
 * @since 2022/01/25
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Login(modifier: Modifier) {
    if (UserManager.login.value < 2) {
        Column(
            modifier = Modifier.width(200.dp)
                .background(Color(0x66FFFFFF), RoundedCornerShape(4.dp))
                .then(modifier)
                .padding(bottom = 5.dp, start = 30.dp, end = 30.dp)
        ) {
            Text("请输入一个昵称", Modifier.padding(vertical = 10.dp).align(Alignment.CenterHorizontally))
            BasicTextField(
                value = UserManager.name.value,
                onValueChange = { UserManager.setName(it) },
                singleLine = true,
                textStyle = LocalTextStyle.current,
                modifier = Modifier.fillMaxWidth()
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(2.dp))
                    .padding(8.dp)
                    .pointerHoverIcon(PointerIcon(Cursor.getDefaultCursor()), true)
            )
            Button(
                onClick = { UserManager.doLogin() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = UserManager.login.value == 0
            ) {
                Text(if(UserManager.login.value == 0) "登录" else "登录中")
            }
        }
    }
}
