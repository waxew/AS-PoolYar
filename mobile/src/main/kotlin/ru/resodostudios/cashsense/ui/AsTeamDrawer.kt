package ru.resodostudios.cashsense.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.resodostudios.cashsense.R
import ru.resodostudios.cashsense.feature.category.list.api.CategoriesNavKey
import ru.resodostudios.cashsense.feature.home.api.HomeNavKey
import ru.resodostudios.cashsense.feature.settings.api.SettingsNavKey
import ru.resodostudios.cashsense.feature.subscription.list.api.SubscriptionsNavKey
import ru.resodostudios.core.navigation.Navigator

/**
 * میزبان منوی مشترک AS Team برای پول‌یار.
 *
 * Drawer عمداً با LayoutDirection.Rtl ساخته شده تا مستقل از زبان فعلی دستگاه از سمت راست باز شود.
 * جهت محتوای اصلی برنامه بلافاصله به مقدار قبلی برگردانده می‌شود تا صفحه‌های انگلیسی یا سایر زبان‌ها
 * ناخواسته RTL نشوند. اکشن‌های Share، Contact و Exit نیز در همین لایه قرار دارند تا در تمام صفحه‌ها
 * رفتار یکسانی داشته باشند.
 */
@Composable
fun AsTeamDrawer(
    navigator: Navigator,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val originalLayoutDirection = LocalLayoutDirection.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var showAboutDialog by remember { mutableStateOf(false) }
    var selectedProfileUri by remember { mutableStateOf<Uri?>(null) }

    val profilePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri ->
        selectedProfileUri = uri
    }

    fun closeAndNavigate(action: () -> Unit) {
        action()
        scope.launch { drawerState.close() }
    }

    fun shareApp() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, context.getString(R.string.as_share_text))
        }
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.as_drawer_share)))
    }

    fun contactSupport() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:AS.Developers.Support@Gmail.Com")
            putExtra(Intent.EXTRA_SUBJECT, "PoolYar Support")
        }
        runCatching { context.startActivity(intent) }
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = {
                ModalDrawerSheet {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        // در این فاز URI انتخاب‌شده در State نگهداری می‌شود؛ نمایش و Persist تصویر در فاز بعدی تکمیل می‌شود.
                        Box(
                            modifier = Modifier
                                .size(82.dp)
                                .clip(CircleShape)
                                .clickable { profilePicker.launch("image/*") },
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = if (selectedProfileUri == null) "AS" else "✓",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = stringResource(R.string.as_drawer_profile_name),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = stringResource(R.string.as_drawer_profile_hint),
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                        )
                    }

                    Divider()
                    Spacer(Modifier.height(8.dp))

                    DrawerItem("⌂", R.string.as_drawer_home) {
                        closeAndNavigate { navigator.navigate(HomeNavKey) }
                    }
                    DrawerItem("▦", R.string.as_drawer_categories) {
                        closeAndNavigate { navigator.navigate(CategoriesNavKey) }
                    }
                    DrawerItem("↻", R.string.as_drawer_subscriptions) {
                        closeAndNavigate { navigator.navigate(SubscriptionsNavKey) }
                    }
                    DrawerItem("⚙", R.string.as_drawer_settings) {
                        closeAndNavigate { navigator.navigate(SettingsNavKey) }
                    }

                    Spacer(Modifier.height(8.dp))
                    Divider()
                    Spacer(Modifier.height(8.dp))

                    DrawerItem("↗", R.string.as_drawer_share) {
                        shareApp()
                        scope.launch { drawerState.close() }
                    }
                    DrawerItem("i", R.string.as_drawer_about) {
                        showAboutDialog = true
                        scope.launch { drawerState.close() }
                    }
                    DrawerItem("@", R.string.as_drawer_contact) {
                        contactSupport()
                        scope.launch { drawerState.close() }
                    }
                    DrawerItem("×", R.string.as_drawer_exit) {
                        (context as? android.app.Activity)?.finishAffinity()
                    }
                }
            },
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides originalLayoutDirection) {
                Box(modifier = Modifier.fillMaxSize()) {
                    content()

                    // دکمه همبرگری در تمام Screenهای اصلی قابل دسترسی است و در گوشهٔ بالا-راست می‌ماند.
                    IconButton(
                        onClick = { scope.launch { drawerState.open() } },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 8.dp, end = 8.dp),
                    ) {
                        Text(
                            text = "☰",
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                }
            }
        }
    }

    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            title = { Text(stringResource(R.string.as_drawer_about)) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(stringResource(R.string.as_about_text))
                    Text("Develop by AS Team Group")
                    Text("Version 1.0.0")
                    Text("AS.Developers.Support@Gmail.Com")
                }
            },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text("OK")
                }
            },
        )
    }
}

/** آیتم ساده و یکسان Drawer؛ استفاده از متن نمادین وابستگی به مجموعه آیکون اضافی را حذف می‌کند. */
@Composable
private fun DrawerItem(
    symbol: String,
    labelRes: Int,
    onClick: () -> Unit,
) {
    NavigationDrawerItem(
        selected = false,
        onClick = onClick,
        icon = {
            Text(
                text = symbol,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(28.dp),
            )
        },
        label = { Text(stringResource(labelRes)) },
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
    )
}
