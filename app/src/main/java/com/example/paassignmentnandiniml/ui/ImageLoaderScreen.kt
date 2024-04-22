package com.example.paassignmentnandiniml.ui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.paassignmentnandiniml.R
import com.example.paassignmentnandiniml.repository.ImageViewModel

@Composable
fun ImageLoaderScreen(imgViewModel: ImageViewModel) {
    val lazyImageItems = imgViewModel.items.collectAsLazyPagingItems()


    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(lazyImageItems.itemCount) {

            Box(modifier = Modifier.padding(4.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier.padding(8.dp)
                ) {
                    val url: String? = lazyImageItems.get(it)?.let {
                        it.thumbnail.domain.plus("/").plus(it.thumbnail.basePath).plus("/10/")
                            .plus(it.thumbnail.key)
                    }

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(url)
                            .crossfade(true)
                            .placeholder(R.drawable.ic_loading_placeholder) // Your placeholder image
                            .error(R.drawable.ic_error_placeholder) // Your error image
                            .build(),
                        contentDescription = "Loaded image",
                        modifier = Modifier.fillMaxSize(60f)
                    )
                }
            }

        }
    }
}
