package com.example.taipeizooanimaldata.model.network

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class AnimalDataResponse(
    val result: Result
) {
    companion object {
        val empty = AnimalDataResponse(Result.empty)
    }
}

@JsonClass(generateAdapter = true)
data class Result(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<AnimalDataEntity>
) {
    companion object {
        val empty = Result(
            -1,
            0,
            0,
            "",
            arrayListOf()
        )
    }
}

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class AnimalDataEntity(
    val A_Behavior: String,
    val A_Distribution: String,
    val A_Voice03_URL: String,
    val A_POIGroup: String,
    val A_Code: String,
    val A_Pic04_ALT: String,
    val A_Voice03_ALT: String,
    val A_Theme_URL: String,
    val A_Summary: String,
    val A_Update: String,
    val A_Pic02_URL: String,
    val A_pdf01_ALT: String,
    @Json(name = "\uFEFFA_Name_Ch") val A_Name_Ch: String,
    val A_Theme_Name: String,
    val A_pdf02_ALT: String,
    val A_Family: String,
    val A_Adopt: String,
    val A_Voice01_ALT: String,
    val A_Pic02_ALT: String,
    val A_Vedio_URL: String,
    val A_Pic04_URL: String,
    val A_Order: String,
    val A_pdf01_URL: String,
    val A_Voice02_ALT: String,
    val A_Diet: String,
    val A_Name_Latin: String,
    val A_Feature: String,
    val A_Habitat: String,
    val A_Phylum: String,
    val A_Class: String,
    val A_Pic03_ALT: String,
    val A_AlsoKnown: String,
    val A_Voice02_URL: String,
    val A_Name_En: String,
    val A_Pic03_URL: String,
    val A_Interpretation: String,
    val A_Location: String,
    val A_Voice01_URL: String,
    val A_pdf02_URL: String,
    val A_CID: String,
    val A_Keywords: String,
    val A_Pic01_URL: String,
    val A_Conservation: String,
    val A_Pic01_ALT: String,
    @PrimaryKey val _id: String,
    val A_Geo: String,
    val A_Crisis: String
) : Parcelable {
    companion object {
        val empty = AnimalDataEntity(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "-1",
            "",
            ""
        )
    }
}

//"result": {
//    "limit": 1000,
//    "offset": 0,
//    "count": 273,
//    "sort": "",
//    "results": [
//    {
//        "A_Behavior": "1.?????????????????????????????????????????????????????????????????????????????????????????????\n  2.???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????10???????????????????????????????????????????????????",
//        "A_Distribution": "????????????????????????????????????????????????????????????",
//        "A_Voice03_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/ADB04074-6156-5C7C-1630-B4E88BAD5147/Panda_Voice03.mp3",
//        "A_POIGroup": "",
//        "A_Code": "Panda",
//        "A_Pic04_ALT": "????????????????????????????????????",
//        "A_Voice03_ALT": "????????????ABC???13???Bears",
//        "A_Theme_URL": "http://newweb.zoo.gov.tw/panda/",
//        "A_Summary": "",
//        "A_Update": "########",
//        "A_Pic02_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic02.jpg",
//        "A_pdf01_ALT": "??????????????????????????????(4.2MB)",
//        "???A_Name_Ch": "?????????",
//        "A_Theme_Name": "YA!?????????-????????????????????????",
//        "A_pdf02_ALT": "???????????????????????????(1.18MB)",
//        "A_Family": "??????",
//        "A_Adopt": "",
//        "A_Voice01_ALT": "?????????????????????",
//        "A_Pic02_ALT": "???????????????????????????",
//        "A_Vedio_URL": "http://www.youtube.com/playlist?list=PLWYak5Af5-DvboTzxQYeg7aKYA9UHYwSf",
//        "A_Pic04_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic04.jpg",
//        "A_Order": "?????????",
//        "A_pdf01_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_PDF01.pdf",
//        "A_Voice02_ALT": "?????????????????????????????????",
//        "A_Diet": "????????????????????????(??????????????????99%)",
//        "A_Name_Latin": "Ailuropoda melanoleuca",
//        "A_Feature": "1. ??????????????????120-180??????????????????80-120?????????????????????????????????10????????????????????????150~200?????????\n 2. ????????????????????????????????????????????????????????????????????????????????????????????????\n 3. ???????????????????????????(???????????????)??????????????????????????????????????????\n 4. ?????????????????????????????????????????????????????????????????????\n 5.????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
//        "A_Habitat": "??????2600-3,000????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
//        "A_Phylum": "???????????????",
//        "A_Class": "?????????",
//        "A_Pic03_ALT": "?????????????????????",
//        "A_AlsoKnown": "???????????????",
//        "A_Voice02_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/3FAC21EE-A863-6E2C-BF12-4E6FEF67BDE/Panda_Voice02.mp3",
//        "A_Name_En": "Giant Panda",
//        "A_Pic03_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic03.jpg",
//        "A_Interpretation": "",
//        "A_Location": "????????????",
//        "A_Voice01_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/894E598B-8A9F-BAA8-206D-8DF52A8C5763/Panda_Voice01.mp3",
//        "A_pdf02_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_PDF02.pdf",
//        "A_CID": "1",
//        "A_Keywords": "",
//        "A_Pic01_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic01.jpg",
//        "A_Conservation": "??????(VU)",
//        "A_Pic01_ALT": "????????????????????????????????????",
//        "_id": 1,
//        "A_Geo": "MULTIPOINT ((121.5831587 24.9971109))",
//        "A_Crisis": "?????????????????????????????????????????????????????????1983??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????"
//    },