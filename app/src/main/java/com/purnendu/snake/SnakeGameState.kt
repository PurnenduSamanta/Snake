package com.purnendu.snake

import kotlin.random.Random

data class SnakeGameState(
    val xAxisGridSize: Int = myXAxisGridSize,
    val yAxisGridSize: Int = myYAxisGridSize,
    val direction: Direction =Direction.RIGHT,
    val snake:List<Coordinate> = listOf(Coordinate(x=5,y=5)),
    val food:Coordinate = generateRandomFoodCoordinates(),
    val isGameOver: Boolean = false,
    val gameState: GameState = GameState.IDLE
)
{
    companion object{
        fun generateRandomFoodCoordinates():Coordinate
        {
            return Coordinate(
                x= Random.nextInt(from = 1, until = 19),
                y= Random.nextInt(from = 1, until =29)
            )
        }
    }
}

enum class GameState
{
    IDLE,
    STARTED,
    PAUSED
}


enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

data class Coordinate(val x: Int, val y: Int)