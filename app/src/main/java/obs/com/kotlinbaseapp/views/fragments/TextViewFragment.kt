package obs.com.kotlinbaseapp.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import obs.com.kotlinbaseapp.R

/**
 * Created by vigneshwaran.n on 01-02-2018.
 */
class TextViewFragment : android.support.v4.app.Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_textview, container, false)

        return view
    }

}