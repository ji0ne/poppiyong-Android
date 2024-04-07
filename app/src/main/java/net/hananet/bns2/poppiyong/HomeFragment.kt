package com.example.poppiyong_android

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import androidx.recyclerview.widget.PagerSnapHelper

// 홈 화면 Fragment 클래스
/*class HomeFragment : Fragment() {
    private var adapter: HomeBestPopAdapter? = null // Best 팝업 어댑터
    private var adapter2: HomeTagPopAdapter? = null // 태그별 팝업 어댑터
    private lateinit var viewFlipper: ViewFlipper // 이미지 뷰 플리퍼
    private val handler = Handler(Looper.getMainLooper()) // 핸들러
    private var timer: Timer? = null // 타이머

    // Fragment가 레이아웃을 초기화할 때 호출됩니다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_home 레이아웃을 인플레이트하여 View 객체를 생성합니다.
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // RecyclerView를 초기화합니다.
        val recyclerViewBest = view.findViewById<RecyclerView>(R.id.recyclerViewBest)
        recyclerViewBest.layoutManager = LinearLayoutManager(requireContext())

        // RecyclerView를 초기화합니다.
        val recyclerViewTag = view.findViewById<RecyclerView>(R.id.recyclerViewTag)
        recyclerViewTag.layoutManager = LinearLayoutManager(requireContext())

        viewFlipper = view.findViewById<ViewFlipper>(R.id.viewFlipper)

        // Fragment의 View를 반환합니다.
        return view
    }

    // View가 생성되고 Fragment가 사용자에게 표시될 때 호출됩니다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView에 표시할 데이터 모델 생성 - Best별
        val itemList: MutableList<HomeBestPopModel> = ArrayList()
        itemList.add(HomeBestPopModel(R.drawable.doguri)) // 여기서 다른 이미지를 사용하려면 해당 이미지의 리소스 ID를 사용해야 합니다.
        itemList.add(HomeBestPopModel(R.drawable.hellokitti))
        itemList.add(HomeBestPopModel(R.drawable.molteez))
        itemList.add(HomeBestPopModel(R.drawable.shinjjang))
        itemList.add(HomeBestPopModel(R.drawable.bellygom))

        // RecyclerView에 표시할 데이터 모델 생성 - 태그별
        val itemList2: MutableList<HomeTagPopModel> = ArrayList()
        itemList2.add(HomeTagPopModel(R.drawable.cat)) // 여기서 다른 이미지를 사용하려면 해당 이미지의 리소스 ID를 사용해야 합니다.
        itemList2.add(HomeTagPopModel(R.drawable.hedgehog))
        itemList2.add(HomeTagPopModel(R.drawable.dog))


        // RecyclerView를 찾아서 어댑터를 설정합니다.
        val recyclerViewBest = view.findViewById<RecyclerView>(R.id.recyclerViewBest)
        // 가로횡 스크롤 가능하게끔 하는 코드
        recyclerViewBest.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = HomeBestPopAdapter(itemList)
        recyclerViewBest.adapter = adapter

        val recyclerViewTag = view.findViewById<RecyclerView>(R.id.recyclerViewTag)
        // 가로횡 스크롤 가능하게끔 하는 코드
        recyclerViewTag.layoutManager = GridLayoutManager(requireContext(), 3)
        adapter2 = HomeTagPopAdapter(itemList2)
        recyclerViewTag.adapter = adapter2
        recyclerViewTag.setHasFixedSize(true) // RecyclerView 크기 고정

        // PagerSnapHelper를 추가하여 한 번에 하나의 항목만 보이도록 설정합니다.
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerViewBest)

        // btnPrevious와 btnNext 버튼을 찾습니다.
        val btnPrevious = view.findViewById<ImageButton>(R.id.btnPrevious)
        val btnNext = view.findViewById<ImageButton>(R.id.btnNext)

        // btnPrevious의 클릭 리스너를 설정합니다.
        btnPrevious.setOnClickListener {
            // viewFlipper에서 이전 이미지를 표시합니다.
            viewFlipper.showPrevious()
        }

        // btnNext의 클릭 리스너를 설정합니다.
        btnNext.setOnClickListener {
            // viewFlipper에서 다음 이미지를 표시합니다.
            viewFlipper.showNext()
        }

        // 5초마다 다음 이미지로 전환하는 타이머를 시작합니다.
        startTimer()

        // 각 태그 텍스트뷰에 대한 클릭 리스너 설정
        val characterText = view.findViewById<TextView>(R.id.characterText)
        val foodText = view.findViewById<TextView>(R.id.foodText)
        val idolText = view.findViewById<TextView>(R.id.idolText)
        val brandText = view.findViewById<TextView>(R.id.brandText)
        val luxuryText = view.findViewById<TextView>(R.id.luxuryText)
        val electronicText = view.findViewById<TextView>(R.id.electronicText)

        // 캐릭터 태그 선택 시 처리
        characterText.setOnClickListener{
            Toast.makeText(requireContext(), "캐릭터 태그 선택", Toast.LENGTH_SHORT).show()
            itemList2.clear() // 이전에 추가된 항목들을 모두 제거합니다.
            itemList2.add(HomeTagPopModel(R.drawable.lostark))
            itemList2.add(HomeTagPopModel(R.drawable.maple))
            itemList2.add(HomeTagPopModel(R.drawable.koongya))
            itemList2.add(HomeTagPopModel(R.drawable.pinkpong))
            itemList2.add(HomeTagPopModel(R.drawable.bellygom))

            // 어댑터에 데이터 변경을 알립니다.
            adapter2?.notifyDataSetChanged()
        }

        // 푸드 태그 선택 시 처리
        foodText.setOnClickListener{
            Toast.makeText(requireContext(), "푸드 태그 선택", Toast.LENGTH_SHORT).show()
            itemList2.clear() // 이전에 추가된 항목들을 모두 제거합니다.
            itemList2.add(HomeTagPopModel(R.drawable.hedgehog))
            itemList2.add(HomeTagPopModel(R.drawable.dog))
            itemList2.add(HomeTagPopModel(R.drawable.cat))

            // 어댑터에 데이터 변경을 알립니다.
            adapter2?.notifyDataSetChanged()
        }

        // 아이돌 태그 선택 시 처리
        idolText.setOnClickListener{
            Toast.makeText(requireContext(), "아이돌 태그 선택", Toast.LENGTH_SHORT).show()
        }

        // 브랜드 태그 선택 시 처리
        brandText.setOnClickListener{
            Toast.makeText(requireContext(), "브랜드 태그 선택", Toast.LENGTH_SHORT).show()
        }

        // 럭셔리 태그 선택 시 처리
        luxuryText.setOnClickListener{
            Toast.makeText(requireContext(), "럭셔리 태그 선택", Toast.LENGTH_SHORT).show()
        }

        // 전자기기 태그 선택 시 처리
        electronicText.setOnClickListener{
            Toast.makeText(requireContext(), "전자기기 태그 선택", Toast.LENGTH_SHORT).show()
        }

        // ToDo: 24.04.01 각 배너 클릭시 팝업스토어 상세 Fragment로 전환
        // ToDo: 24.04.01 현재처럼 이미지가 아닌 리사이클러 조합 필요
    }

    // 타이머 시작 메서드
    private fun startTimer() {
        // TimerTask를 생성하여 5초마다 실행되는 작업을 정의합니다.
        val task = object : TimerTask() {
            override fun run() {
                // 메인 스레드에서 UI 업데이트 작업을 수행합니다.
                handler.post {
                    // viewFlipper에서 다음 이미지를 표시합니다.
                    viewFlipper.showNext()
                }
            }
        }

        // Timer를 생성하고 타이머를 시작합니다.
        timer = Timer()
        timer?.schedule(task, 5000, 5000) // 5초 후에 시작하고, 이후에는 5초마다 반복 실행됩니다.
    }

    // Fragment가 파괴되면 호출됩니다.
    override fun onDestroyView() {
        super.onDestroyView()
        // 타이머를 중지합니다.
        timer?.cancel()
    }
} */
