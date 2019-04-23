package et.edu.aait.listdetailfragmentappliction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null) {
            val detailFragment = CourseDetailFragment()
            detailFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content,detailFragment) // android.R.id.content gives you the root view of your activity
                .commit()
        }
    }
}
