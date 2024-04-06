package net.hananet.bns2.poppiyong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.hananet.bns2.poppiyong.databinding.FragmentHomeTodaypopupItemBinding


class Home_BestPopupAdapter : RecyclerView.Adapter<Home_BestPopupAdapter.ImageViewHolder>() {

    private var imageList: List<String> = listOf()

    fun submitList(newList: List<String>) {
        imageList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_best_item, parent, false)
        return ImageViewHolder(view) //dddd
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = imageList[position]
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
