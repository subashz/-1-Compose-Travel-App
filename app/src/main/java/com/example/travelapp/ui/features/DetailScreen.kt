package com.example.travelapp.ui.features

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DetailScreen(navController: NavController) {

    LazyColumn() {

        item {
            DetailHeader(navController)
            TripInfoContent()
        }

        itemsIndexed(tripDays) { position, data ->
            TripDayContent(data)
        }

    }
}

@Composable
fun DetailHeader(navController: NavController) {

    val detailHeaderImageUrl =
        "https://images.unsplash.com/photo-1602002418816-5c0aeef426aa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=967&q=80"

    Box() {

        Image(
            painter = rememberCoilPainter(request = detailHeaderImageUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )


        Box(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
        ) {

            TopButton(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                navController.popBackStack()
            }

            TopButton(
                imageVector = Icons.Default.BookmarkBorder,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {

            }

        }


    }

}


@Composable
fun TripInfoContent() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row {

            LocationChip(text = "Thailand")
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(12.dp)
                    .align(CenterVertically),
                tint = Color(0xFFFBC110)
            )

            Text(
                text = "4.8 (2.5k reviews)",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "How to get around thailand on a cheap budget in 2021",
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = (-0.2).sp
        )

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TripDataItem(
                imageVector = Icons.Default.CalendarToday,
                title = "Duration",
                subtitle = "7 days"
            )

            TripDataItem(
                imageVector = Icons.Default.Person,
                title = "Package For",
                subtitle = "2 Person"
            )

            TripDataItem(
                imageVector = Icons.Default.AttachMoney,
                title = "Apprx Cost",
                subtitle = "800"
            )

        }

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

    }

}

data class TripDayData(val title: String, val detail: String)

var tripDays = listOf(
    TripDayData(
        title = "Day 1: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDayData(
        title = "Day 2: Kanchanaburi",
        detail = "From Bangkok, my next recommended destination is Kanchanaburi. Whilst the name of the town might not instantly ring any bells, the river it sits on probably will, it’s the River Kwai, famous for its bridge, the story of which was turned into a film."
    ),
    TripDayData(
        title = "Day 3: Ayutthaya",
        detail = "From Kanchanaburi I’d suggest heading to one of Thailand’s old capital cities. There are two main options to choose from, Ayutthaya and Sukhothai, and on a shorter trip like this, I think picking just one of these two will suffice."
    ),
    TripDayData(
        title = "Day 4: Khao Sok",
        detail = "Now it’s time to head south, to one of my favourite spots in Thailand – Khao Sok National Park. This place is, for some reason, not well visited, but it is truly unlike anywhere else I visited in the country."
    ),
)


@Composable
fun TripDayContent(day: TripDayData) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Text(
            text = day.title.uppercase(),
            fontSize = 14.sp,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.75.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = day.detail,
            fontSize = 14.sp,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.Light,
            lineHeight = 18.sp
        )

    }

}


@Composable
fun TripDataItem(imageVector: ImageVector, title: String, subtitle: String) {

    Row {

        Icon(
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F6FF))
                .size(32.dp)
                .padding(8.dp),

            imageVector = imageVector, contentDescription = ""
        )

        Column {

            Text(
                text = title,
                fontSize = 12.sp,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = subtitle,
                fontSize = 14.sp,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal
            )
        }

    }


}


@Composable
fun LocationChip(text: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFFBF110))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {

        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "",
            modifier = Modifier
                .padding(end = 4.dp)
                .size(12.dp)
                .align(CenterVertically)
        )

        Text(
            text = text,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.Black
        )
    }

}

@Composable
fun TopButton(imageVector: ImageVector, modifier: Modifier, clickListener: () -> Unit) {


    Button(
        onClick = { clickListener() },
        border = BorderStroke(2.dp, Color(0xFFEAFBFF)),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xDDF6F9FF),
            contentColor = Color(0xFF3562D7)
        ),
        modifier = modifier.size(48.dp)

    ) {

        Icon(imageVector = imageVector, contentDescription = "")
    }
}