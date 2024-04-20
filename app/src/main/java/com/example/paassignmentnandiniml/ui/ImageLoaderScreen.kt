package com.example.paassignmentnandiniml.ui


import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.paassignmentnandiniml.R
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.entities.Util
import com.example.paassignmentnandiniml.repository.ImageViewModel
import io.ktor.http.ContentType

@Composable
fun ImageLoaderScreen(imgViewModel: ImageViewModel, context: Context) {
    val lazyImageItems= imgViewModel.items.collectAsLazyPagingItems()


    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(lazyImageItems.itemCount){

            Box(modifier = Modifier.padding(4.dp)){
                Surface(
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier.padding(8.dp)
                ){
                    val url : String?= lazyImageItems.get(it)?.let {
                        it.thumbnail.domain.plus("/").plus(it.thumbnail.basePath).plus("/40/").plus(it.thumbnail.key)
                    }
                    AsyncImage(
                        model = url,
                        contentDescription ="Load Img"
                    )
                }
            }

        }
    }
}
