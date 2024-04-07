package com.example.poppiyong_android

// ToDo: recyclerView의 아이템 모델(업데이트 가능)
class HomeBestPopModel {
    private var popupStoreImg: Int = 0

    constructor(popupStoreImg: Int) {
        this.popupStoreImg = popupStoreImg
    }

    fun getPopupStoreImg(): Int {
        return popupStoreImg
    }

    fun setPopupStoreImg(popupStoreImg: Int) {
        this.popupStoreImg = popupStoreImg
    }
}


