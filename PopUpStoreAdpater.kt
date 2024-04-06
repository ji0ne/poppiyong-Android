package com.example.ppy_popupstoredetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PopUpStoreAdpater (private val itemList: List<PopUpStoreModel>) : RecyclerView.Adapter<PopUpStoreAdpater.ViewHolder>(){
    // 뷰 홀더 클래스 정의
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val popupStoreImageView: ImageView = itemView.findViewById(R.id.popupDetailImg)
    }

    // onCreateViewHolder 메서드 오버라이드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_pop_up_detail_item, parent, false)
        return ViewHolder(view)
    }

    // onBindViewHolder 메서드 오버라이드
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.popupStoreImageView.setImageResource(item.getPopupDetailImg())
    }

    // getItemCount 메서드 오버라이드
    override fun getItemCount(): Int {
        return itemList.size
    }
}