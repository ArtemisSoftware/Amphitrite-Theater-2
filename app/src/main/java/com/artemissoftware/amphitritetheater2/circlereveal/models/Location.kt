package com.artemissoftware.amphitritetheater2.circlereveal.models

import com.artemissoftware.amphitritetheater2.R

data class Location(
    val image:Int,
    val title:String,
    val description:String
){
    companion object {
        val locations = listOf(
            Location(
                image = R.drawable.cdz_1,
                title = "Tabriz",
                description = "Tabriz is the capital city of East Azerbaijan Province, in northwestern Iran. Tabriz Bazaar, once a major Silk Road market, is a sprawling brick-vaulted complex selling carpets, spices and jewelry"
            ),
            Location(
                image = R.drawable.cdz_2,
                title = "Dubai",
                description = "Dubai is a city and emirate in the United Arab Emirates known for luxury shopping, ultramodern architecture and a lively nightlife scene. Burj Khalifa, an 830m-tall tower, dominates the skyscraper-filled skyline."
            ),
            Location(
                image = R.drawable.cdz_3,
                title = "Los Angeles",
                description = "Los Angeles is a sprawling Southern California city and the center of the nation’s film and television industry. Near its iconic Hollywood sign, studios such as Paramount Pictures, Universal and Warner Brothers offer behind-the-scenes tours."
            ),
            Location(
                image = R.drawable.cdz_4,
                title = "London",
                description = "London, the capital of England and the United Kingdom, is a 21st-century city with history stretching back to Roman times."
            ),
            Location(
                image = R.drawable.cdz_5,
                title = "Sweden",
                description = "Sweden is a Scandinavian nation with thousands of coastal islands and inland lakes, along with vast boreal forests and glaciated mountains."
            ),
            Location(
                image = R.drawable.cdz_6,
                title = "Kazan",
                description = "Kazan is a city in southwest Russia, on the banks of the Volga and Kazanka rivers. The capital of the Republic of Tatarstan"
            ),
        )
    }
}
