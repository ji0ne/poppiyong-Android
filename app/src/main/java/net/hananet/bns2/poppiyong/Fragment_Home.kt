package net.hananet.bns2.poppiyong

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import net.hananet.bns2.poppiyong.Home_BestPopupAdapter
import net.hananet.bns2.poppiyong.Home_TodayPopupAdapter
import net.hananet.bns2.poppiyong.Home_ViewModel
import net.hananet.bns2.poppiyong.databinding.FragmentHomeBinding

import android.widget.Button
import android.widget.GridLayout


class Fragment_Home : Fragment() { //kkkkkkkkkkk

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: Home_ViewModel by viewModels()

    private val todayPopupAdapter = Home_TodayPopupAdapter()
    private val bestPopupAdapter = Home_BestPopupAdapter()

    private val handler = Handler(Looper.getMainLooper()) //자동 스크롤 핸들러

    private val autoScrollRunnable = object : Runnable { //자동 스크롤 위한 Runnable객체 정의
        override fun run() {
            // 다음 페이지로 이동 (다음에 표시될 아이템의 인덱스를 계산)
            //다음 아이템을 전체 아이템 개수로 나눠서 현재 아이템에 할당
            binding.fragmentHomeViewPager.currentItem =
                (binding.fragmentHomeViewPager.currentItem + 1) % todayPopupAdapter.itemCount
            // 5초마다 실행
            handler.postDelayed(this, 5000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setupViewPager() // 뷰페이저2 / 리사이클러뷰 어댑터 설정

        //캐릭터 / 디저트 태그 클릭 리스너
        //setupCharacterTagClickListener()
        //setupDessertTagClickListener()

        // 사용자의 스와이프 동작 처리
        binding.fragmentHomeViewPager.isUserInputEnabled = true

        return view
    }

    private fun setupViewPager() { //뷰페이저2 설정 메서드
        binding.fragmentHomeViewPager.adapter = todayPopupAdapter

        //viewModel.home_viewPagerImgList.observe(viewLifecycleOwner) { imageList ->
          //  bestPopupAdapter.submitList(imageList)


        viewModel.home_viewPagerImgList.observe(viewLifecycleOwner) { images ->
            todayPopupAdapter.submitList(images) //어댑터에 이미지목록 제출 (갱신)
        }


            // ViewPager2의 첫 번째 페이지로 셋
            binding.fragmentHomeViewPager.post {
                binding.fragmentHomeViewPager.currentItem = 0
            }
            // 자동 스크롤 시작
            handler.postDelayed(autoScrollRunnable, 5000)
        }

    }

   /** private fun setupCharacterTagClickListener() { //캐릭터 태그 클릭 리스너
        binding.btnHomeStoreTagCharacter.setOnClickListener {
            characterTagClicked()
        }
    }

    private fun setupDessertTagClickListener() { //디저트 태그 클릭 리스너
        binding.btnHomeStoreTagDessert.setOnClickListener {
            dessertTagClicked()
        }
    }

    private fun characterTagClicked() { //캐릭터 태그 클릭 시 동작
        val itemList = viewModel.CharacterViewModel().home_StoreTagList_character.value
        itemList?.let { displayTagItems(it) } // 가져온 리스트가 null이 아니면 태그 아이템을 표시하는 함수를 호출
    }

    private fun dessertTagClicked() { //디저트 태그 클릭 시 동작
        val itemList = viewModel.DessertViewModel().home_StoreTagList_dessert.value
        itemList?.let { displayTagItems(it) }
    }

    private fun displayTagItems(itemList: List<String>) { //태그 아이템 표시
        val gridLayout: androidx.gridlayout.widget.GridLayout = binding.gridHomeStoreTag // 그리드 레이아웃
        gridLayout.removeAllViews() // 그리드 레이아웃의 모든 자식 뷰를 제거 (기존 추가된 뷰 다 밀어야함)
        itemList.forEach { item -> // 아이템 리스트를 순회하며 각 아이템에 대해 처리
            val button = Button(requireContext())
            button.text = item // 버튼의 텍스트를 아이템으로 설정
            val params = GridLayout.LayoutParams()  // 그리드 레이아웃 변수 params
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            button.layoutParams = params
            gridLayout.addView(button)  // 버튼을 그리드 레이아웃에 추가
        }
    }
}
    */