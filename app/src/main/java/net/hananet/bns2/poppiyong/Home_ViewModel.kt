package net.hananet.bns2.poppiyong

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Home_ViewModel : ViewModel() {
    val home_viewPagerImgList = MutableLiveData<List<String>>()

    init {
        // 이미지 목록 초기화
        val images = listOf(
            "https://cdn.pixabay.com/photo/2016/10/26/22/00/hamster-1772742_1280.jpg",
            "https://cdn.pixabay.com/photo/2016/07/20/16/41/hamster-1530675_1280.png",
            "https://cdn.pixabay.com/photo/2018/02/17/21/56/cute-3161014_1280.jpg"
        )
        home_viewPagerImgList.value = images
    }

    inner class CharacterViewModel : ViewModel() {
        val home_StoreTagList_character = MutableLiveData<List<String>>()

        init {
            val storeTagList_character_imges = listOf(
                "https://cdn.pixabay.com/photo/2018/01/10/23/53/rabbit-3075088_1280.png",
                "https://cdn.pixabay.com/photo/2021/01/29/08/09/doodles-5960094_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/09/04/20/09/cartoon-5544856_1280.jpg",
                "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_1280.jpg",
                "https://cdn.pixabay.com/photo/2018/08/31/02/27/cat-3643705_1280.jpg",
                "https://cdn.pixabay.com/photo/2017/10/14/15/50/banana-2850841_1280.png"
            )
            home_StoreTagList_character.value = storeTagList_character_imges
        }

    }

    inner class DessertViewModel : ViewModel() {
        val home_StoreTagList_dessert = MutableLiveData<List<String>>()

        init{
            val storeTagList_dessert_imges = listOf(
                "https://cdn.pixabay.com/photo/2017/11/09/18/02/ice-cream-2934210_1280.jpg",
                "https://cdn.pixabay.com/photo/2013/07/13/12/19/chocolate-159631_1280.png",
                "https://cdn.pixabay.com/photo/2013/07/12/19/20/popsicle-154587_1280.png",
                "https://cdn.pixabay.com/photo/2014/04/02/10/52/chocolate-chip-cookies-304801_1280.png",
                "https://cdn.pixabay.com/photo/2024/02/28/02/08/ai-generated-8601041_1280.jpg"
            )
            home_StoreTagList_dessert.value = storeTagList_dessert_imges
        }

    }


}
