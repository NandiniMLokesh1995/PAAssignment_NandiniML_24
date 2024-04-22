package com.example.paassignmentnandiniml

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.paassignmentnandiniml.network.ApiService
import com.example.paassignmentnandiniml.network.AppDatabase
import com.example.paassignmentnandiniml.repository.ImageRepository
import com.example.paassignmentnandiniml.repository.ImageViewModel
import com.example.paassignmentnandiniml.repository.ImageViewModelFactory
import com.example.paassignmentnandiniml.ui.ImageLoaderScreen
import com.example.paassignmentnandiniml.ui.theme.PAAssignmentNandiniMLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : ImageViewModel by viewModels{
                ImageViewModelFactory(ImageRepository(ApiService,AppDatabase.getDatabase(this)))
            }
            PAAssignmentNandiniMLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ImageLoaderScreen(viewModel)
                }
            }
        }
    }
}

