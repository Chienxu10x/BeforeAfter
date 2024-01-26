package com.example.test4.demo

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.test5.R
import com.smarttoolfactory.beforeafter.*

@Composable
fun BeforeAfterLayoutDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        val imageBefore2 = ImageBitmap.imageResource(
            LocalContext.current.resources, R.drawable.landscape5_before
        )

        val imageAfter2 = ImageBitmap.imageResource(
            LocalContext.current.resources, R.drawable.landscape5
        )

        BeforeAfterLayout(
            modifier = Modifier
                .shadow(1.dp, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .aspectRatio(4 / 3f),
            beforeContent = {
                DemoImage(imageBitmap = imageBefore2)
            },
            afterContent = {
                DemoImage(imageBitmap = imageAfter2)
            },
            contentOrder = ContentOrder.AfterBefore
        )

        Spacer(modifier = Modifier.height(100.dp))

    }
}
@Composable
private fun DemoImage(imageBitmap: ImageBitmap) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4 / 3f),
        bitmap = imageBitmap,
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

