package com.example.poppiyong_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

// 태그별 팝업 어댑터 클래스
/* class HomeTagPopAdapter(private val itemList: List<HomeTagPopModel>) : RecyclerView.Adapter<HomeTagPopAdapter.ViewHolder>() {

    // 뷰 홀더 클래스 정의
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val popupStoreTagImageView: ImageView = itemView.findViewById(R.id.homeTagPopImg)
    }

    // onCreateViewHolder 메서드 오버라이드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 레이아웃을 인플레이트하여 뷰 홀더 객체 생성
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_home_tag_item, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder 메서드 오버라이드
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 현재 위치에 해당하는 데이터를 가져와서 뷰에 설정
        val item = itemList[position]
        holder.popupStoreTagImageView.setImageResource(item.getPopupStoreTagImg())
    }

    // getItemCount 메서드 오버라이드
    override fun getItemCount(): Int {
        // 아이템 리스트의 크기 반환
        return itemList.size
    }
}
*/