package com.example.islamyapp.ui.fragments.quran

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentQuranBinding
import com.example.islamyapp.ui.quran_content_Activity.quran_activity

class QuranFragment : Fragment() {
    lateinit var rvAdapter: QuranRecyclerViewAdapter
    lateinit var binding: FragmentQuranBinding
   val chapters : List<String> = listOf("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
       ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
       ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
       ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
       ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
       ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
       ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
       ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
       ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
       "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

    }

    private fun initViews(view : View) {

        rvAdapter = QuranRecyclerViewAdapter(chapters)
        rvAdapter.onItemClick = QuranRecyclerViewAdapter.OnClick { position, tittle ->

            startQuranContentActivity(tittle,position)
        }
        binding.quranRv.adapter=rvAdapter

    }

    private fun startQuranContentActivity(title:String , position: Int) {
val  intent = Intent(activity,quran_activity::class.java)
        intent.putExtra(quran_activity.TITTLE ,title)
        intent.putExtra(quran_activity.POSITION,position)
        startActivity(intent)
    }
}