package com.ana.svmeetup.ui.example

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ana.svmeetup.R
import com.ana.svmeetup.ui.theme.Gray100
import com.ana.svmeetup.ui.theme.Gray200
import com.ana.svmeetup.ui.theme.Gray400
import com.ana.svmeetup.ui.theme.Purple700
import com.ana.svmeetup.ui.theme.SVMeetupTheme
import com.ana.svmeetup.ui.theme.Shapes
import com.skydoves.landscapist.coil.CoilImage

@Composable
internal fun ListExample(itemsList: List<ItemDataList>, context: Context) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "LazyColumn & LazRow",
            color = Purple700,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 20.dp
                )
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        /*   Vertical List   */
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .background(Gray200),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            items(
                items = itemsList,
                itemContent = { item ->
                    when (item.itemType) {
                        ItemType.Pet -> BoxContent { PetList(itemList = item.value) }
                        ItemType.Contact -> BoxContent {
                            ContactList(
                                itemList = item.value,
                                context = context
                            )
                        }
                        ItemType.Music -> BoxContent { MusicList(itemList = item.value) }
                    }
                }
            )
        }
    }
}

@Composable
internal fun BoxContent(content: @Composable() () -> Unit) {
    Box(
        modifier = Modifier
            .clip(Shapes.small)
            .height(170.dp)
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .background(Gray100)
            .padding(8.dp)
    ) {
        content()
    }
}

@Composable
internal fun MusicList(itemList: List<ItemData>) {
    /*   Horizontal List   */
    LazyRow(modifier = Modifier.fillMaxHeight()) {
        items(
            items = itemList,
            itemContent = { item ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Box(
                        modifier = Modifier.size(140.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_crop_square_24),
                            contentDescription = null,
                            modifier = Modifier
                                .matchParentSize()
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_music_note_24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(92.dp)
                                .padding(top = 28.dp, start = 42.dp),
                        )
                        Text(
                            text = item.title,
                            modifier = Modifier
                                .padding(top = 80.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            color = Gray400,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        )
    }
}

@Composable
internal fun ContactList(itemList: List<ItemData>, context: Context) {
    /*   Horizontal List   */
    LazyRow(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = itemList,
            itemContent = { item ->
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White)

                ) {
                        item.urlImage?.let {
                            LocalImage(iconUrl = it, context)
                        }
                        Text(text = item.title,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                                .padding(top = 70.dp))
                }
            }
        )
    }
}

@Composable
internal fun PetList(itemList: List<ItemData>) {
    /*   Horizontal List   */
    LazyRow(modifier = Modifier.fillMaxHeight()
        .padding(top = 10.dp),
    horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(
            items = itemList,
            itemContent = {
                when (it.title) {
                    "Cat" -> PetItem(item = it)
                    else -> PetItem(item = it, Modifier.clip(Shapes.medium))
                }
            }
        )
    }
}

@Composable
internal fun PetItem(item: ItemData, modifier: Modifier? = Modifier) {
    Box(
        modifier = modifier?.let {it.size(120.dp) } ?: Modifier.size(120.dp)
    ) {
        item.urlImage?.let {
            LoadImage(imageUrl = it)
        }
    }
}

@Composable
internal fun LocalImage(iconUrl: String, context: Context) {
    val iconResourceId = context.resources.getIdentifier(
        iconUrl,
        "drawable",
        context.packageName
    )
    iconResourceId?.let {
        Image(
            painter = painterResource(id = iconResourceId),
            modifier = Modifier.fillMaxWidth()
                .size(80.dp),
            contentDescription = null,
        )
    }
}

@Composable
internal fun LoadImage(imageUrl: String) {
    CoilImage(
        modifier = Modifier.fillMaxWidth(),
        imageModel = imageUrl
    )
}

@Preview(showBackground = true)
@Composable
fun MusicListPreview() {
    SVMeetupTheme {
        MusicList(itemList = getMusicDataList())
    }
}