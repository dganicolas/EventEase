package com.example.eventease.navegacion.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.eventease.R
import com.example.eventease.componentes.image
import com.example.eventease.componentes.spacer
import com.example.eventease.componentes.texto
import com.example.eventease.ui.theme.cabecera
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(function: (String) -> Job, function1: () -> Job) {
    TopAppBar(
        title = { Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //imagen y nombre de la app
            image(R.drawable.logo, "logo de la app", 45.dp, colorFilter = ColorFilter.tint(Color.White))
            Text(text = "Eventeease", fontSize = 16.sp)
        } },
        navigationIcon = {
            IconButton(onClick = { function1() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "menu"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = cabecera,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Clear"
                )
            }
        }

    )
}

@Composable
fun MyBottomBar(modifier: Modifier = Modifier) {
    var index by remember { mutableIntStateOf(0) }

    NavigationBar(containerColor = cabecera) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            },
            label = {
                Text(text = "home")
            }
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Red,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "fav"
                )
            },
            label = {
                Text(text = "fav")
            }
        )
    }
}

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val ruta:String,
    val badgeCount: Int? = null
)

@Composable
fun ScaffoldExample(modifier: Modifier, navControlador: NavHostController, escena: @Composable () -> Unit) {


    val snackbarHostState = remember { SnackbarHostState() }
    val corutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Box(modifier){
        ModalNavigationDrawer(
            drawerContent =
            {
                ModalDrawerSheet {
                    spacer(16.dp)
                    val items = listOf(
                        NavigationItem(
                            title = "mi perfil",
                            selectedIcon = Icons.Filled.AccountCircle,
                            unselectedIcon = Icons.Filled.AccountCircle,
                            ruta = "mi perfil"
                        ),
                        NavigationItem(
                            title = "mis locales",
                            selectedIcon = Icons.Filled.Home,
                            unselectedIcon = Icons.Filled.Home,
                            ruta = "mis locales"
                        ),
                        NavigationItem(
                            title = "mis reservas",
                            selectedIcon = Icons.Filled.DateRange,
                            unselectedIcon = Icons.Filled.DateRange,
                            ruta = "mis reservas"
                        ),
                        NavigationItem(
                            title = "salir",
                            selectedIcon = Icons.Filled.Clear,
                            unselectedIcon = Icons.Filled.Clear,
                            ruta = "login"
                        )
                    )

                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                corutineScope.launch {
                                    drawerState.close()
                                    navControlador.navigate(item.ruta)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title

                                )
                            },
                            badge = {
                                item.badgeCount?.let {
                                    texto(item.badgeCount.toString())
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = drawerState

        ) {
            Scaffold(
                topBar = {
                    MyTopAppBar(
                        { corutineScope.launch { snackbarHostState.showSnackbar("has pulsado $it") } },
                        {
                            corutineScope.launch {
                                drawerState.open()
                            }
                        }
                    )
                },
                bottomBar = { MyBottomBar(Modifier) },
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        snackbar = {
                            Snackbar(
                                snackbarData = it,
                                containerColor = Color.Gray,
                                contentColor = Color.Blue
                            )
                        }
                    )
                }
            )
            {
                Column(
                    modifier = Modifier.padding(it)
                ) {
                    escena()
                }
            }
        }
    }
}























