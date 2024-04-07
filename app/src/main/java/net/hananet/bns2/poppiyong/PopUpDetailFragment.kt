package com.example.ppy_popupstoredetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PopUpDetailFragment : Fragment() {
 //   private var adapter: PopUpStoreAdpater? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // val view = inflater.inflate(R.layout.fragment_pop_up_detail, container, false)

        // RecyclerView를 초기화합니다.
      //  val recyclerViewDetail = view.findViewById<RecyclerView>(R.id.recyclerViewDetail)
      //  recyclerViewDetail.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList: MutableList<PopUpStoreModel> = ArrayList()
      //  itemList.add(PopUpStoreModel(R.drawable.doguri)) // 여기서 다른 이미지를 사용하려면 해당 이미지의 리소스 ID를 사용해야 합니다.
     ///   itemList.add(PopUpStoreModel(R.drawable.doguri2))
     //   itemList.add(PopUpStoreModel(R.drawable.doguri3))
     //   itemList.add(PopUpStoreModel(R.drawable.doguri4))
      //  itemList.add(PopUpStoreModel(R.drawable.doguri5))
     ///   itemList.add(PopUpStoreModel(R.drawable.doguri6))

        // RecyclerView를 찾아서 어댑터를 설정합니다.
      //  val recyclerViewDetail = view.findViewById<RecyclerView>(R.id.recyclerViewDetail)
        // 가로횡 스크롤 가능하게끔 하는 코드
    //    recyclerViewDetail.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
      //  adapter = PopUpStoreAdpater(itemList)
    //    recyclerViewDetail.adapter = adapter

        // PagerSnapHelper를 추가하여 한 번에 하나의 항목만 보이도록 설정합니다.
        val pagerSnapHelper = PagerSnapHelper()
    //    pagerSnapHelper.attachToRecyclerView(recyclerViewDetail)
    }
}