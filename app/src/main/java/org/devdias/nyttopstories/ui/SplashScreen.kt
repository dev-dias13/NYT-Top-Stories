package org.devdias.nyttopstories.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import org.devdias.nyttopstories.ui.theme.DeepBlue
import org.devdias.nyttopstories.ui.theme.TextWhite
import org.devdias.nyttopstories.ui.utils.Screen

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(durationMillis = 500, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay( 2000L)
        navController.navigate(Screen.HomeScreen.route)
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .background(DeepBlue)) {
        Text(
            text = "New York Times Top Stories" ,
            fontSize = 22.sp,
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    }
}
