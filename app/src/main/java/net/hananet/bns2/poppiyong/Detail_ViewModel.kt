package net.hananet.bns2.poppiyong

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Detail_ViewModel  : ViewModel()
{
    val storeDetail_storeImgs = MutableLiveData<List<String>>() //상단 팝업스토어 이미지 (스토어 상세설명은 이미지 하나로 해도 ok)
    //MutablieLiveData <List<String>> : 뷰 / 데이터 간 상호작용
    init{
        val storeDetailImgs = listOf(
            "https://cdn.pixabay.com/photo/2024/01/24/22/14/ai-generated-8530649_1280.png",
            "https://cdn.pixabay.com/photo/2024/01/24/22/05/ai-generated-8530628_1280.png",
            "https://cdn.pixabay.com/photo/2016/01/08/20/32/bookstore-1129183_1280.png"
        )
        storeDetail_storeImgs.value = storeDetailImgs
    }
}