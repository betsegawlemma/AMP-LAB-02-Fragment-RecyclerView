package et.edu.aait.listdetailfragmentappliction

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import et.edu.aait.listdetailapplication.Course

class MainActivity : AppCompatActivity(),CourseListFragment.OnCourseSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_layout)
    }

    override fun onCourseSelected(course: Course) {


        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            val courseDetailIntent = Intent(this,CourseDetailActivity::class.java)
            courseDetailIntent.putExtra("course",course)
            startActivity(courseDetailIntent)

        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            val courseDetailFragment = CourseDetailFragment.newInstance(course)
            supportFragmentManager.beginTransaction()
            .replace(R.id.course_detail_frame,courseDetailFragment,"courseDetails")
            .addToBackStack(null)
            .commit()

        }

    }

}
