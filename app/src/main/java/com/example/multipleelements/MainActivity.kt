package com.example.multipleelements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multipleelements.ui.theme.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrincipalScreen(Modifier.fillMaxWidth())
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PrincipalScreen(modifier: Modifier = Modifier) {

        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopDownBarContainer,
                        titleContentColor = contentTopDownBar
                    ),
                    title = { Text(text = "JetPack Compose") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = contentTopDownBar
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = contentTopDownBar
                            )
                        }
                    }
                )
            },
            bottomBar = { BottomAppBarComposable() }

        ) { innerPadding ->
            ListofItems(
                modifier = Modifier.padding(innerPadding),
                quantyItems = 100
            )
            FloatingButtons(modifier= Modifier.padding(innerPadding))
        }
    }


    @Composable
    fun BottomAppBarComposable(modifier: Modifier = Modifier) {
        BottomAppBar(
            containerColor = TopDownBarContainer,
            tonalElevation = 8.dp,
            modifier = modifier,
            actions = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = modifier.width(100.dp),
                        onClick = { /* do something */ }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Home",
                                tint = contentTopDownBar
                            )
                            Text(color = contentTopDownBar, text = "Home")
                        }
                    }
                    IconButton(
                        modifier = modifier.width(100.dp),
                        onClick = { /* do something */ }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Create",
                                tint = contentTopDownBar
                            )
                            Text(color = contentTopDownBar, text = "Create")
                        }
                    }
                    IconButton(
                        modifier = modifier.width(100.dp),
                        onClick = { /* do something */ }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Settings",
                                tint = contentTopDownBar
                            )
                            Text(color = contentTopDownBar, text = "Settings")
                        }
                    }
                }
            }
        )
    }


    @Composable
    fun ListofItems(modifier: Modifier = Modifier, quantyItems: Int = 10) {

        val itemList = List(quantyItems) { "Item List - $it" }

        LazyColumn(
            modifier = modifier,
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceAround

        ) {
            items(itemList){ item ->
                ItemList(modifier= Modifier.fillMaxWidth(),text = item)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }


    @Composable
    fun ItemList(modifier: Modifier = Modifier, text: String) {
        Text(
            modifier = modifier
                .height(40.dp)
                .background(itemListColor),
            textAlign = TextAlign.Center,
            text = text

        )

    }


    @Composable
    fun FloatingButtons(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FloatingActionButton(
                    onClick = {  },
                    containerColor = floatingButtonBackGround,
                    contentColor = contentTopDownBar
                ) {
                    Icon(
                        imageVector = Icons.Filled.MyLocation,
                        contentDescription = "My Location"
                    )
                }

                ExtendedFloatingActionButton(
                    onClick = {  },
                    containerColor = floatingButtonBackGround,
                    contentColor = contentTopDownBar,
                    icon = { Icon(imageVector = Icons.Filled.Navigation, contentDescription = "Navigate") },
                    text = { Text("Navigate") }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PrincipalScreenPreview() {

        PrincipalScreen(Modifier.fillMaxWidth())

    }
}
