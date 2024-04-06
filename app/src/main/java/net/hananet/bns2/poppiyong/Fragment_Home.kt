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


class Fragment_Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: Home_ViewModel by viewModels()

    private val todayPopupAdapter = Home_TodayPopupAdapter()

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

        // 사용자의 스와이프 동작 처리
        binding.fragmentHomeViewPager.isUserInputEnabled = true

        return view
    }

    private fun setupViewPager() { //뷰페이저2 설정 메서드
        binding.fragmentHomeViewPager.adapter = todayPopupAdapter
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

