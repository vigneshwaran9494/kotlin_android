package obs.com.kotlinbaseapp.views.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import obs.com.kotlinbaseapp.BaseApp
import obs.com.kotlinbaseapp.R
import obs.com.kotlinbaseapp.views.fragments.TextViewFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inject app component
        BaseApp.app.inject(this);
        //init views
        initViews()
    }

    fun initViews() {

        val componentList = findViewById(R.id.lv_item_list) as ListView
        //can access view without define variable

        //define list view
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.components))
        componentList.adapter = adapter;

        //set list item clicklistener
        componentList.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            //when is replaced for switch case
            when (position) {
                0 -> {
                    addFragment(TextViewFragment(), R.id.fragment_container)
                }
            }
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }


}
