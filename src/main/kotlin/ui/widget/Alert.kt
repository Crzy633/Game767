package ui.widget

import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 弹框
 *
 * @author Parva
 * @since 2021/12/31
 */
object Alert {

    private val msg = mutableStateOf<Pair<String, String>?>(null)
    private val error = mutableStateOf<Pair<String, String>?>(null)

    fun showMassage(massage: String, title: String = "信息") {
        msg.value = Pair(title, massage)
    }

    fun showError(massage: String, title: String = "错误") {
        error.value = Pair(title, massage)
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun Stub() {
        msg.value?.run { MassageAlertDialog() }
        error.value?.run { ErrorAlertDialog() }
    }

    @Composable
    @ExperimentalMaterialApi
    private fun MassageAlertDialog() {
        AlertDialog(
            modifier = Modifier.width(400.dp),
            title = { Text(msg.value?.first ?: "") },
            onDismissRequest = {},
            text = { Text(msg.value?.second ?: "") },
            confirmButton = {
                Button(onClick = { msg.value = null }) {
                    Text("确定")
                }
            }
        )
    }

    @Composable
    @ExperimentalMaterialApi
    private fun ErrorAlertDialog() {
        AlertDialog(
            modifier = Modifier.width(400.dp),
            title = { Text(error.value?.second ?: "") },
            onDismissRequest = {},
            text = { Text(error.value?.first ?: "") },
            confirmButton = {
                Button(onClick = { error.value = null }) {
                    Text("确定")
                }
            }
        )
    }

}