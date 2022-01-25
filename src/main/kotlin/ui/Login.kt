package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import manager.UserManager

/**
 * @author Parva
 * @since 2022/01/25
 */
@Composable
fun Login(modifier: Modifier) {
    if (UserManager.login.value < 2) {
        Column(
            modifier = Modifier.width(200.dp)
                .background(Color(0x66FFFFFF), RoundedCornerShape(4.dp))
                .then(modifier)
        ) {
            Text("请输入一个昵称", Modifier.align(Alignment.CenterHorizontally))
            TextField(
                value = UserManager.name.value,
                onValueChange = { UserManager.setName(it) }
            )
            Button(
                onClick = { UserManager.doLogin() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = UserManager.login.value == 0
            ) {
                Text(if(UserManager.login.value == 0) "登录" else "登陆中")
            }
        }
    }
}
