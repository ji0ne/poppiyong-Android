package net.hananet.bns2.poppiyong

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.hananet.bns2.poppiyong.databinding.FragmentHomeTodaypopupItemBinding

class Home_TodayPopupAdapter : RecyclerView.Adapter<Home_TodayPopupAdapter.ImageViewHolder>() {
    private var images: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = FragmentHomeTodaypopupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        //현 위치 해당 이미지URL 가져옴
        val imageUrl = images[position]
        //가져와서 ImageView item에 표시
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.binding.imageView)

        // 아이템 클릭 시 토스트 메시지 표시
        holder.itemView.setOnClickListener {
            val message = "$position 의 Fragment로 이동"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return images.size //아이템 개수반환
    }

    //이미지 목록 업뎃 / 리사이클러뷰 갱신
    fun submitList(images: List<String>) {
        this.images = images
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(val binding: FragmentHomeTodaypopupItemBinding) : RecyclerView.ViewHolder(binding.root)
}
