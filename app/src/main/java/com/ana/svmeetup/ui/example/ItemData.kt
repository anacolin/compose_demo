package com.ana.svmeetup.ui.example

data class ItemDataList(
    val itemType: ItemType,
    val value: List<ItemData>
)

data class ItemData(
    val title: String,
    val urlImage: String?,
)

enum class ItemType {
    Contact,
    Pet,
    Music
}

fun getItemDataList() = listOf<ItemDataList>(
    ItemDataList(ItemType.Contact, getContactDataList()),
    ItemDataList(ItemType.Pet, getPetsDataList()),
    ItemDataList(ItemType.Music, getMusicDataList()),
    ItemDataList(ItemType.Contact, getContactDataList()),
    ItemDataList(ItemType.Pet, getPetsDataList()),
    ItemDataList(ItemType.Music, getMusicDataList())
)


fun getMusicDataList() = listOf<ItemData>(
    ItemData("Classical", "ic_baseline_music_video_24"),
    ItemData("Pop", "ic_baseline_music_video_24"),
    ItemData("Rock", "ic_baseline_music_video_24"),
    ItemData("Relaxing", "ic_baseline_music_video_24")
)

fun getContactDataList() = listOf<ItemData>(
    ItemData("María", "ic_baseline_person_girl"),
    ItemData("Eduardo", "ic_baseline_person_24"),
    ItemData("Raúl", "ic_baseline_person_24"),
    ItemData("Fernanda", "ic_baseline_person_girl"),
    ItemData("José", "ic_baseline_person_24"),
    ItemData("Lucía", "ic_baseline_person_girl")
)

fun getPetsDataList() = listOf<ItemData>(
    ItemData(
        "Dog",
        "https://keyassets.timeincuk.net/inspirewp/live/wp-content/uploads/sites/8/2021/02/GettyImages-997141470-e1614176377827.jpg"
    ),
    ItemData(
        "Cat",
        "https://c.ndtvimg.com/2020-08/h5mk7js_cat-generic_625x300_28_August_20.jpg"
    ),
    ItemData(
        "Shiba inu",
        "https://d3544la1u8djza.cloudfront.net/APHI/Blog/2020/05-14/How+Do+Dogs+Get+Hernias+_+ASPCA+Pet+Insurance+_+shiba+inu+with+an+orange+collar+resting+on+a+tan+chair-min.jpg"
    ),
    ItemData(
        "Pomerania",
        "https://ichef.bbci.co.uk/news/976/cpsprodpb/EB24/production/_112669106_66030514-b1c2-4533-9230-272b8368e25f.jpg"
    ),
    ItemData(
        "Cat",
        "https://cdn.mos.cms.futurecdn.net/VSy6kJDNq2pSXsCzb6cvYF.jpg"
    ),
    ItemData(
        "Cat",
        "https://post.healthline.com/wp-content/uploads/2020/09/4609-cat-732x549-thumbnail.jpg"
    )
)