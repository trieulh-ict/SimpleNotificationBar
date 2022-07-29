package io.trieulh.simplenotificationbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.trieulh.simplenotificationbar.items.SimpleNotificationAdapter
import io.trieulh.simplenotificationbar.helper.SimpleSwipeHelperCallback

/**
 * How to use: Get the view from binding and call the chain functions:
 *      SimpleNotificationBar.bind(parentViewGroup).makeText(SimpleNotificationArg(...)).show()
 */
class SimpleNotificationBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    // Default argument, you will need to update this for displayed content using makeText() method
    private var barArg: SimpleNotificationArg = SimpleNotificationArg()
    private var barConfig: SimpleNotificationConfig = SimpleNotificationConfig()

    // Notification Adapter
    private var adapter: SimpleNotificationAdapter


    companion object {
        private const val TAG = "SimpleNotificationBar"

        fun bind(
            parent: ViewGroup,
            config: SimpleNotificationConfig = SimpleNotificationConfig()
        ): SimpleNotificationBar {
            return (parent.findViewWithTag(TAG) ?: SimpleNotificationBar(parent.context).apply {
                layoutParams = MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                elevation = parent.context.resources.getDimensionPixelOffset(R.dimen.spacing_72)
                    .toFloat()
                tag = TAG
                parent.addView(this)
            })
                .apply {
                    setConfig(config)
                }
        }
    }

    init {
        View.inflate(context, R.layout.view_simple_notification_bar, this)
        findViewById<RecyclerView>(R.id.list_notifications).apply {
            layoutManager = LinearLayoutManager(context)
            this@SimpleNotificationBar.adapter = SimpleNotificationAdapter(barConfig).also {
                ItemTouchHelper(SimpleSwipeHelperCallback(it)).attachToRecyclerView(this)
                adapter = it
            }
        }
    }

    private fun setConfig(config: SimpleNotificationConfig) {
        barConfig = config
    }

    /**
     * Main function used to display Toast with configuration
     */
    fun show() {
        adapter.submitList(adapter.currentList.toMutableList().apply {
            add(0, barArg.buildItem())
        }.take(barConfig.maxCount + 1).toList())
    }

    /**
     * Update text content before show
     *
     * @param arg SimpleNotificationArg
     * @return
     */
    fun makeText(arg: SimpleNotificationArg): SimpleNotificationBar = this.apply {
        barArg = arg
    }
}
