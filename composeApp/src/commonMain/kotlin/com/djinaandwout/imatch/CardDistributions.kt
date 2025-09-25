package com.djinaandwout.imatch

import imatch.composeapp.generated.resources.Res
import imatch.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

private val cardDistributions = listOf(
    listOf(1, 2 , 3 , 4 , 5 , 6 , 7 , 8 ),
    listOf(1, 9 , 10, 11, 12, 13, 14, 15),
    listOf(1, 16, 17, 18, 19, 20, 21, 22),
    listOf(1, 23, 24, 25, 26, 27, 28, 29),
    listOf(1, 30, 31, 32, 33, 34, 35, 36),
    listOf(1, 37, 38, 39, 40, 41, 42, 43),
    listOf(1, 44, 46, 46, 47, 48, 49, 50),
    listOf(1, 51, 52, 53, 54, 55, 56, 57),
    listOf(2, 9 , 16, 23, 30, 37, 44, 51),
    listOf(2, 10, 17, 24, 31, 38, 46, 52),
    listOf(2, 11, 18, 25, 32, 39, 46, 53),
    listOf(2, 12, 19, 26, 33, 40, 47, 54),
    listOf(2, 13, 20, 27, 34, 41, 48, 55),
    listOf(2, 14, 21, 28, 35, 42, 49, 56),
    listOf(2, 15, 22, 29, 36, 43, 50, 57),
    listOf(3, 9 , 17, 25, 33, 41, 49, 57),
    listOf(3, 10, 18, 26, 34, 42, 50, 51),
    listOf(3, 11, 19, 27, 35, 43, 44, 52),
    listOf(3, 12, 20, 28, 36, 37, 46, 53),
    listOf(3, 13, 21, 29, 30, 38, 46, 54),
    listOf(3, 14, 22, 23, 31, 39, 47, 55),
    listOf(3, 15, 16, 24, 32, 40, 48, 56),
    listOf(4, 9 , 18, 27, 36, 38, 47, 56),
    listOf(4, 10, 19, 28, 30, 39, 48, 57),
    listOf(4, 11, 20, 29, 31, 40, 49, 51),
    listOf(4, 12, 21, 23, 32, 41, 50, 52),
    listOf(4, 13, 22, 24, 33, 42, 44, 53),
    listOf(4, 14, 16, 25, 34, 43, 46, 54),
    listOf(4, 15, 17, 26, 35, 37, 46, 55),
    listOf(5, 9 , 19, 29, 32, 42, 46, 55),
    listOf(5, 10, 20, 23, 33, 43, 46, 56),
    listOf(5, 11, 21, 24, 34, 37, 47, 57),
    listOf(5, 12, 22, 25, 35, 38, 48, 51),
    listOf(5, 13, 16, 26, 36, 39, 49, 52),
    listOf(5, 14, 17, 27, 30, 40, 50, 53),
    listOf(5, 15, 18, 28, 31, 41, 44, 54),
    listOf(6, 9 , 20, 24, 35, 39, 50, 54),
    listOf(6, 10, 21, 25, 36, 40, 44, 55),
    listOf(6, 11, 22, 26, 30, 41, 46, 56),
    listOf(6, 12, 16, 27, 31, 42, 46, 57),
    listOf(6, 13, 17, 28, 32, 43, 47, 51),
    listOf(6, 14, 18, 29, 33, 37, 48, 52),
    listOf(6, 15, 19, 23, 34, 38, 49, 53),
    listOf(7, 9 , 21, 26, 31, 43, 48, 53),
    listOf(7, 10, 22, 27, 32, 37, 49, 54),
    listOf(7, 11, 16, 28, 33, 38, 50, 55),
    listOf(7, 12, 17, 29, 34, 39, 44, 56),
    listOf(7, 13, 18, 23, 35, 40, 46, 57),
    listOf(7, 14, 19, 24, 36, 41, 46, 51),
    listOf(7, 15, 20, 25, 30, 42, 47, 52),
    listOf(8, 9 , 22, 28, 34, 40, 46, 52),
    listOf(8, 10, 16, 29, 35, 41, 47, 53),
    listOf(8, 11, 17, 23, 36, 42, 48, 54),
    listOf(8, 12, 18, 24, 30, 43, 49, 55),
    listOf(8, 13, 19, 25, 31, 37, 50, 56),
    listOf(8, 14, 20, 26, 32, 38, 44, 57),
    listOf(8, 15, 21, 27, 33, 39, 46, 51),
)

private fun getImageFor(number: Int): DrawableResource = when (number) {
    1 -> Res.drawable._1_apple
    2 -> Res.drawable._2_banana
    3 -> Res.drawable._3_watermelon
    4 -> Res.drawable._4_strawberry
    5 -> Res.drawable._5_lemon
    6 -> Res.drawable._6_pineapple
    7 -> Res.drawable._7_cherry
    8 -> Res.drawable._8_grapes
    9 -> Res.drawable._9_carrot
    10 -> Res.drawable._10_pepper
    11 -> Res.drawable._11_broccoli
    12 -> Res.drawable._12_tomato
    13 -> Res.drawable._13_cucumber
    14 -> Res.drawable._14_pencil
    15 -> Res.drawable._15_pen
    16 -> Res.drawable._16_notebook
    17 -> Res.drawable._17_file
    18 -> Res.drawable._18_folder
    19 -> Res.drawable._19_lamp
    20 -> Res.drawable._20_calendar
    21 -> Res.drawable._21_highlighter
    22 -> Res.drawable._22_paperclip
    23 -> Res.drawable._23_cup
    24 -> Res.drawable._24_fork
    25 -> Res.drawable._25_spoon
    26 -> Res.drawable._26_microvawe
    27 -> Res.drawable._27_bag
    28 -> Res.drawable._28_star
    29 -> Res.drawable._29_sunglasses
    30 -> Res.drawable._30_ballon
    31 -> Res.drawable._31_basketball
    32 -> Res.drawable._32_heart
    33 -> Res.drawable._33_teapot
    34 -> Res.drawable._34_umbrella
    35 -> Res.drawable._35_flower
    36 -> Res.drawable._36_laptop
    37 -> Res.drawable._37_keyboard
    38 -> Res.drawable._38_mouse
    39 -> Res.drawable._39_usbflash
    40 -> Res.drawable._40_display
    41 -> Res.drawable._41_phone
    42 -> Res.drawable._42_harddisk
    43 -> Res.drawable._43_headset
    44 -> Res.drawable._44_wifi
    45 -> Res.drawable._45_cloud
    46 -> Res.drawable._46_lock
    47 -> Res.drawable._47_tshirt
    48 -> Res.drawable._48_peach
    49 -> Res.drawable._49_leaf
    50 -> Res.drawable._50_lightning
    51 -> Res.drawable._51_bow
    52 -> Res.drawable._52_chair
    53 -> Res.drawable._53_perfume
    54 -> Res.drawable._54_necklace
    55 -> Res.drawable._55_necklace
    56 -> Res.drawable._56_skirt
    57 -> Res.drawable._57_shoe
    else -> error("AAAAAAH")
}

private val widthHeightOfSquareInsideUnityCircle = sin(PI / 4.0)

// TODO: Make more random
fun getDistributions(): List<Card> = cardDistributions.map { distribution ->
    Card(
        (0..6)
            .map { PI * it * 2.0 / 7.0 }
            .let { angles ->
                val randomAdditionalRotation = Random.nextDouble(-PI, PI)
                angles.map { it + randomAdditionalRotation }
            }
            .map { angle -> Pair(cos(angle) * 2.0 / 3.0, sin(angle) * 2.0 / 3.0) }
            .plus(Pair(0.0, 0.0))
            .zip(distribution) { (x, y), imageNumber ->
                ImatchImage(
                    xCenter = x,
                    yCenter = y,
                    Random.nextDouble(0.0, PI * 2),
                    maxWidthAndHeight = widthHeightOfSquareInsideUnityCircle / 3,
                    getImageFor(imageNumber)
                )
            }
    )
}






