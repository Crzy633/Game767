import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppTheme {
    val colors: Colors = Colors()
    val icons: Icons = Icons()

    class Colors(
        val backgroundDark: Color = Color(0xFF2B2B2B),
        val backgroundMedium: Color = Color(0xFF3C3F41),
        val backgroundLight: Color = Color(0xFF4E5254),
        val primary: Color = Color(0x8f59c8ff),

        val material: androidx.compose.material.Colors = darkColors(
            background = backgroundMedium,
            surface = backgroundLight,
            primary = primary,
            primaryVariant = backgroundDark,
            onPrimary = Color.White,
            onSecondary = Color.White,
        )
    )

    class Icons(
        val capture: ImageVector = androidx.compose.material.icons.Icons.Default.PhotoCamera,
        val fileOpen: ImageVector = androidx.compose.material.icons.Icons.Default.FolderOpen,
        val fileSave: ImageVector = androidx.compose.material.icons.Icons.Default.Save,
        val clickable: ImageVector = androidx.compose.material.icons.Icons.Default.Flare,
        val treeCollapsed: ImageVector = androidx.compose.material.icons.Icons.Default.ChevronRight,
        val treeExpanded: ImageVector = androidx.compose.material.icons.Icons.Default.ExpandMore,
        val running: ImageVector = androidx.compose.material.icons.Icons.Default.Bolt,
        val error: ImageVector = androidx.compose.material.icons.Icons.Default.Warning,
        val success: ImageVector = androidx.compose.material.icons.Icons.Default.Done,
        val tip: ImageVector = androidx.compose.material.icons.Icons.Default.Info,
        val edit: ImageVector = androidx.compose.material.icons.Icons.Default.Create,
        val voice: ImageVector = androidx.compose.material.icons.Icons.Default.RecordVoiceOver,
        val copy: ImageVector = androidx.compose.material.icons.Icons.Default.ContentCopy,
        val wait: ImageVector = androidx.compose.material.icons.Icons.Default.QueryBuilder,
        val playing: ImageVector = androidx.compose.material.icons.Icons.Default.RecordVoiceOver,
        val finish: ImageVector = androidx.compose.material.icons.Icons.Default.Done,
        val minimize: ImageVector = androidx.compose.material.icons.Icons.Default.Minimize,
        val dragIndicator: ImageVector = androidx.compose.material.icons.Icons.Default.DragIndicator,
        val close: ImageVector = androidx.compose.material.icons.Icons.Default.Close,

    )

    object Styles {
        @Composable
        fun HorizontalSplitLine(width: Dp = 1.dp, color: Color = colors.backgroundDark) = Box(
            modifier = Modifier.width(width).fillMaxHeight().background(color)
        )

        @Composable
        fun VerticalSplitLine(height: Dp = 1.dp, color: Color = colors.backgroundDark) = Box(
            modifier = Modifier.height(height).fillMaxWidth().background(color)
        )

        @Composable
        fun Tooltip(tip: String, icon: ImageVector = icons.tip) = Surface(elevation = 5.dp) {
            Row(modifier = Modifier.background(colors.backgroundMedium).padding(3.dp)) {
                Icon(
                    icon,
                    "",
                    tint = Color.LightGray,
                    modifier = Modifier.size(12.dp).align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(text = tip, fontSize = 12.sp)
            }
        }
    }
}