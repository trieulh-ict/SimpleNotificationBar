package io.trieulh.simplenotificationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView
import io.trieulh.simplenotificationbar.SimpleNotificationArg
import io.trieulh.simplenotificationbar.SimpleNotificationBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_first, SampleFragment.newInstance("First Fragment"))
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_second, SampleFragment.newInstance("Second Fragment"))
            .commit()
    }

}