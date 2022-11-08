package com.firebaseb.chucknorris.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.firebaseb.chucknorris.Models.ResponseJokeRandom
import com.firebaseb.chucknorris.ViewModel.ViewModelChuckNorris

@Composable
fun JokeScreen(viewModel: ViewModelChuckNorris) {
    val jokeRandom = viewModel.joke
    Scaffold(
        topBar = {
            TopAppBarChuck()
        }
    ) {
        JokeContent(
            jokeRandom = jokeRandom
        )
    }
}

@Composable
fun JokeContent(
    jokeRandom: MutableList<ResponseJokeRandom>
) {
    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ){
        itemsIndexed(jokeRandom){index, item ->
            Card(modifier = Modifier.padding(5.dp)) {
                Column(modifier = Modifier.padding(15.dp)) {
                    item.categories.forEach{
                        Text(text = "categories:  "+it)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "created_at: "+item.createdAt.toString())
                    Text(text = "id: "+item.id.toString())
                    Text(text = "updated_at"+item.updatedAt.toString())
                    Text(text = "url: "+item.url.toString())
                    Image(
                        painter = rememberAsyncImagePainter(item.iconUrl),
                        contentDescription = null,
                        modifier = Modifier.size(128.dp)
                    )
                }
            }
        }
    }
}
