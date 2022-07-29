package io.trieulh.simplenotificationdemo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.trieulh.simplenotificationbar.SimpleNotificationArg
import io.trieulh.simplenotificationbar.SimpleNotificationBar
import io.trieulh.simplenotificationbar.SimpleNotificationConfig
import io.trieulh.simplenotificationbar.SimpleNotificationType
import java.util.*

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
                val intType = (1..3).random()
                SimpleNotificationBar.bind(this, config = SimpleNotificationConfig(maxCount = 2))
                    .makeText(
                        SimpleNotificationArg(
                            content = System.currentTimeMillis().toString(),
                            type = SimpleNotificationType.getTypeByInt(intType)
                        )
                    ).show()
            }
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