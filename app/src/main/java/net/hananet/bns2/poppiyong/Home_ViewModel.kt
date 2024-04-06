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
}
