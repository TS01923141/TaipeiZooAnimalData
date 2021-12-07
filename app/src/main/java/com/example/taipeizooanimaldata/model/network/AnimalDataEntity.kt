package com.example.taipeizooanimaldata.model.network

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
//@Parcelize
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
) {
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
//        "A_Behavior": "1.獨居的動物，除了交配季節或雌性的育幼時期，牠們都是獨自居住的。\n  2.最活躍的時間在早晨和黃昏，但竹子所含熱量低，為減少能量的消耗，牠們每天的睡眠時間約10小時，剩餘時間則大多在覓食和進食。",
//        "A_Distribution": "目前僅存於中國四川、甘肅和陜西三省境內。",
//        "A_Voice03_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/ADB04074-6156-5C7C-1630-B4E88BAD5147/Panda_Voice03.mp3",
//        "A_POIGroup": "",
//        "A_Code": "Panda",
//        "A_Pic04_ALT": "大貓熊「團團」和「圓圓」",
//        "A_Voice03_ALT": "山豬老大ABC第13集Bears",
//        "A_Theme_URL": "http://newweb.zoo.gov.tw/panda/",
//        "A_Summary": "",
//        "A_Update": "########",
//        "A_Pic02_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic02.jpg",
//        "A_pdf01_ALT": "「遇見大貓熊」學習單(4.2MB)",
//        "﻿A_Name_Ch": "大貓熊",
//        "A_Theme_Name": "YA!大貓熊-臺北大貓熊保育網",
//        "A_pdf02_ALT": "「遇見大貓熊」解答(1.18MB)",
//        "A_Family": "熊科",
//        "A_Adopt": "",
//        "A_Voice01_ALT": "雌大貓熊咩叫聲",
//        "A_Pic02_ALT": "「圓仔」跟媽媽互動",
//        "A_Vedio_URL": "http://www.youtube.com/playlist?list=PLWYak5Af5-DvboTzxQYeg7aKYA9UHYwSf",
//        "A_Pic04_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic04.jpg",
//        "A_Order": "食肉目",
//        "A_pdf01_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_PDF01.pdf",
//        "A_Voice02_ALT": "雌雄大貓熊交配時的叫聲",
//        "A_Diet": "大貓熊以竹為主食(佔日糧中大約99%)",
//        "A_Name_Latin": "Ailuropoda melanoleuca",
//        "A_Feature": "1. 成熊身長約為120-180公分，體重約80-120公斤，幼熊出生時體長約10公分，體重約僅有150~200公克。\n 2. 具有強壯有力的四肢：後腳內八字撇，有利於在密林中走動時撥開竹子。\n 3. 腕骨特化成的偽拇指(不具備關節)，使得牠們能俐落地取食竹子。\n 4. 掌心覆有毛，使得大貓熊能夠在寒冷的雪地上行走。\n 5.大貓熊身體顏色主要為黑白兩色。耳朵、眼斑、鼻頭、肩背部和四肢為黑色，其餘部位為白色。相對比例較小的黑色耳朵有減少熱量散失的功能。",
//        "A_Habitat": "海拔2600-3,000公尺的高山中，會因季節的變化而改變其居住的海拔高度，一般在乾淨的活水源和竹林發育良好的地區活動。",
//        "A_Phylum": "脊索動物門",
//        "A_Class": "哺乳綱",
//        "A_Pic03_ALT": "大貓熊「圓仔」",
//        "A_AlsoKnown": "貓熊、熊貓",
//        "A_Voice02_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/3FAC21EE-A863-6E2C-BF12-4E6FEF67BDE/Panda_Voice02.mp3",
//        "A_Name_En": "Giant Panda",
//        "A_Pic03_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic03.jpg",
//        "A_Interpretation": "",
//        "A_Location": "大貓熊館",
//        "A_Voice01_URL": "http://mediasys.taipei.gov.tw/tcg/service/KMStorage/355/894E598B-8A9F-BAA8-206D-8DF52A8C5763/Panda_Voice01.mp3",
//        "A_pdf02_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_PDF02.pdf",
//        "A_CID": "1",
//        "A_Keywords": "",
//        "A_Pic01_URL": "http://www.zoo.gov.tw/iTAP/03_Animals/PandaHouse/Panda_Pic01.jpg",
//        "A_Conservation": "易危(VU)",
//        "A_Pic01_ALT": "大貓熊「團團」和「圓圓」",
//        "_id": 1,
//        "A_Geo": "MULTIPOINT ((121.5831587 24.9971109))",
//        "A_Crisis": "過去大貓熊棲息地裡的竹林竹種較為單一，1983年曾發生棲地內箭竹週期性大規模開花枯死而有大貓熊餓死的情形，竹林一旦開花，須再經多年後才能恢復舊觀。另外大貓熊棲息地的破碎化，使得牠們無法遷徙至其他有竹子的地方，加劇了這個原是林地自然演替的危害。也因棲地破碎化，部分種群因數量規模小，基因的窄化以及無法延續也成為另一嚴重問題。"
//    },