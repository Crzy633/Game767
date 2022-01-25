package manager

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import common.Url
import okhttp3.*
import ui.widget.Alert
import java.io.IOException

/**
 * @author Parva
 * @since 2022/01/25
 */
object UserManager {

    private val mName by lazy { mutableStateOf("") }
    private val mLogin by lazy { mutableStateOf(0) }

    val name: State<String> by lazy { mName }
    val login: State<Int> by lazy { mLogin }

    fun setName(name: String) { mName.value = name }

    fun doLogin() {
        mLogin.value = 1
        val request = Request.Builder().get().url(Url.login).build()
        val call = OkHttpClient().newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                mLogin.value = 0
                Alert.showError("登录失败")
            }
            override fun onResponse(call: Call, response: Response) {
                mLogin.value = 2
                Alert.showMassage("${response.body?.string()}")
            }
        })

    }

}