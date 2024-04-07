package net.hananet.bns2.poppiyongimport
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.hananet.bns2.poppiyong.databinding.StoreDetailItemBinding

class StoreDetail_StoreImgAdapter : RecyclerView.Adapter<StoreDetail_StoreImgAdapter.StoreDetailItemViewHolder>() {

    private var detailImageList: List<String> = listOf()

    fun submitList(newList: List<String>?) {
        detailImageList = newList ?: emptyList() // ?: 엘비스 연산자 | null이면 오른쪽 아니면 왼쪽
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreDetailItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StoreDetailItemBinding.inflate(inflater, parent, false)
        return StoreDetailItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreDetailItemViewHolder, position: Int) {
        val imageUrl = detailImageList[position]
        holder.bind(imageUrl)
    }

    override fun getItemCount(): Int {
        return detailImageList.size
    }

    inner class StoreDetailItemViewHolder(private val binding: StoreDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            Glide.with(binding.root.context)
                .load(imageUrl)
                .into(binding.ivStoreDetailItem)
        }
    }
}