package com.artemissoftware.amphitritetheater2.circlereveal.util.extensions

import androidx.compose.foundation.pager.PagerState

fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction

fun PagerState.endOffsetForPage(page: Int) = offsetForPage(page).coerceAtMost(0f)

fun PagerState.startOffsetForPage(page: Int) = offsetForPage(page).coerceAtLeast(0f)