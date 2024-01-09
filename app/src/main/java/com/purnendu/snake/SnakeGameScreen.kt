package com.purnendu.snake

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.purnendu.snake.ui.theme.Custard
import com.purnendu.snake.ui.theme.RoyalBlue

@Composable
fun SnakeGameScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = "Score: 5",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
        ) {

            drawGameBoard(
                cellSize = size.width / 20,
                cellColor = Custard,
                borderCellColor = RoyalBlue,
                gridWidth = 20,
                gridHeight = 30
            )


        }

    }


}


private fun DrawScope.drawGameBoard(
    cellSize: Float,
    cellColor: androidx.compose.ui.graphics.Color,
    borderCellColor: androidx.compose.ui.graphics.Color,
    gridWidth: Int,
    gridHeight: Int
) {

    for (i in 0 until gridWidth) {
        for (j in 0 until gridHeight) {
            val isBorderCell= i==0 || j==0 || i== gridWidth -1 || j==gridHeight-1
            drawRect(
                color = if(isBorderCell) borderCellColor else if((i+j)%2==0) cellColor else cellColor.copy(alpha = 0.5f),
                topLeft = Offset(x=i*cellSize,y=j*cellSize),
                size = Size(width = cellSize, height = cellSize)
            )
        }
    }

}