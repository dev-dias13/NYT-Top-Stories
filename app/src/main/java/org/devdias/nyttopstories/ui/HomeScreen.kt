package org.devdias.nyttopstories.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.devdias.nyttopstories.ui.theme.*
import org.devdias.nyttopstories.ui.utils.Feature
import org.devdias.nyttopstories.ui.utils.Screen
import org.devdias.nyttopstories.ui.utils.standardQuadFromTo

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column {
            Greeting()
            FeatureSection(
                coroutineScope = coroutineScope,
                features = listOf(
                    Feature(
                        title = "Arts",
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Technology",
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Movies",
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Fashion",
                        Beige1,
                        Beige2,
                        Beige3
                    )
                ),
                navController = navController
            )
        }
    }
}

@Composable
fun Greeting() {
    Box(modifier = Modifier.background(DeepBlue).fillMaxWidth()) {
        Text(
            text = "Top Stories from New York Times",
            color = TextWhite,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.TopCenter)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(
    features: List<Feature>,
    coroutineScope: CoroutineScope,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth().background(DeepBlue)) {
        Text(
            text = "Sections",
            color = TextWhite,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it],
                    coroutineScope, navController)
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature,
    coroutineScope: CoroutineScope,
    navController: NavController

) {
    BoxWithConstraints (
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
            .clickable {
                coroutineScope.launch {
                    when (feature.title) {
                        "Arts" -> {
                            navController.navigate(Screen.ArtsScreen.route)
                        }
                        "Technology" -> {
                            navController.navigate(Screen.TechScreen.route)
                        }
                        "Movies" -> {
                            navController.navigate(Screen.MoviesScreen.route)
                        }
                        "Fashion" -> {
                            navController.navigate(Screen.FashionScreen.route)
                        }
                    }
                }
            }
    ) {
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            // Medium colored path
            val mediumColoredPoint1 = Offset(0f, height * 0.3f)
            val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
            val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
            val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
            val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

            val mediumColoredPath = Path().apply {
                moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
                standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
                standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
                standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
                standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }

            // Light colored path
            val lightPoint1 = Offset(0f, height * 0.35f)
            val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
            val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
            val lightPoint4 = Offset(width * 0.65f, height.toFloat())
            val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

            val lightColoredPath = Path().apply {
                moveTo(lightPoint1.x, lightPoint1.y)
                standardQuadFromTo(lightPoint1, lightPoint2)
                standardQuadFromTo(lightPoint2, lightPoint3)
                standardQuadFromTo(lightPoint3, lightPoint4)
                standardQuadFromTo(lightPoint4, lightPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawPath(
                    path = mediumColoredPath,
                    color = feature.mediumColor
                )
                drawPath(
                    path = lightColoredPath,
                    color = feature.lightColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Text(
                    text = feature.title,
                    color = TextWhite,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 26.sp,
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }
    }
}