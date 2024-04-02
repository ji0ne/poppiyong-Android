package com.example.poppiyong_android

// 홈 태그 팝업 모델 클래스
class HomeTagPopModel {
    // 팝업 스토어 태그 이미지 리소스 ID를 저장하는 변수
    private var popupStoreTagImg: Int = 0

    // 생성자: 주어진 이미지 리소스 ID를 사용하여 HomeTagPopModel 객체를 생성합니다.
    constructor(popupStoreTagImg: Int) {
        this.popupStoreTagImg = popupStoreTagImg
    }

    // 팝업 스토어 태그 이미지 리소스 ID를 반환하는 메서드
    fun getPopupStoreTagImg(): Int {
        return popupStoreTagImg
    }

    // 팝업 스토어 태그 이미지 리소스 ID를 설정하는 메서드
    fun setPopupStoreTagImg(popupStoreTagImg: Int) {
        this.popupStoreTagImg = popupStoreTagImg
    }
}
