package io.trieulh.simplenotificationdemo

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import io.trieulh.simplenotificationbar.CustomSimpleNotificationArg
import io.trieulh.simplenotificationbar.SimpleNotificationArg
import io.trieulh.simplenotificationbar.SimpleNotificationBar
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import java.util.Random

private const val ARG_NAME = "name"

class SampleFragment : Fragment() {
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.txt_name).apply {
            text = name
        }
        view.findViewById<ViewGroup>(R.id.container).apply {
            val rnd = Random()
            val color = Color.argb(100, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            setBackgroundColor(color)

            setOnClickListener {
                SimpleNotificationBar.bind(this, config = SimpleNotificationConfig(maxCount = 2))
                    .makeText(generateRandomNotificationArg()).show()
            }
        }
    }

    private fun generateRandomNotificationArg(): SimpleNotificationArg {
        return when ((0..3).random()) {
            0 -> SimpleNotificationArg.Custom(
                content = "Custom: ${System.currentTimeMillis()}",
                additionalArg = CustomSimpleNotificationArg(
                    iconDrawable = ContextCompat.getDrawable(
                        requireContext(),
                        io.trieulh.simplenotificationbar.R.drawable.ic_error_24
                    ),
                    backgroundDrawable = ContextCompat.getDrawable(
                        requireContext(),
                        io.trieulh.simplenotificationbar.R.drawable.bg_success
                    )
                )
            )
            1 -> SimpleNotificationArg.Success(content = System.currentTimeMillis().toString())
            2 -> SimpleNotificationArg.Error(content = System.currentTimeMillis().toString())
            else -> SimpleNotificationArg.Warning(content = System.currentTimeMillis().toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                }
            }
    }
}