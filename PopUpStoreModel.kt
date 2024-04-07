package com.example.ppy_popupstoredetail

class PopUpStoreModel {
    private var popupDetailImg: Int = 0

    constructor(popupDetailImg: Int) {
        this.popupDetailImg = popupDetailImg
    }

    fun getPopupDetailImg(): Int {
        return popupDetailImg
    }

    fun setPopupDetailImg(popupDetailImg: Int) {
        this.popupDetailImg = popupDetailImg
    }
}