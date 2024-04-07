package net.hananet.bns2.poppiyong

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.hananet.bns2.poppiyong.databinding.FragmentDetailPageBinding
import net.hananet.bns2.poppiyongimport.StoreDetail_StoreImgAdapter

class Fragment_DetailPage : Fragment() {

    private lateinit var binding: FragmentDetailPageBinding
    private val viewModel: Detail_ViewModel by viewModels()
    private val storeDetailApter = StoreDetail_StoreImgAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(inflater, container, false)
        val view = binding.root


        viewModel.storeDetail_storeImgs.observe(viewLifecycleOwner) { storeDetailImgs ->
            storeDetailApter.submitList(storeDetailImgs)
        }
        binding.recyclerViewFragmentDetailStores.adapter = storeDetailApter
        binding.recyclerViewFragmentDetailStores.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        return view
    }

}