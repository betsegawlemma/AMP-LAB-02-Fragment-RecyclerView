package et.edu.aait.listdetailfragmentappliction


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import et.edu.aait.listdetailapplication.Course
import kotlinx.android.synthetic.main.fragment_course_detail.view.*


class CourseDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_course_detail, container, false)

            val course = arguments?.getSerializable("course") as Course

            view.detail_code_tv.text = course.code
            view.detail_title_tv.text = course.title
            view.detail_ects_tv.text = course.ects.toString()
            view.detail_description_tv.text = course.description

        return view
    }

    companion object {

        fun newInstance(course: Course): CourseDetailFragment{

            val args = Bundle()

            args.putSerializable("course",course)

            val fragment = CourseDetailFragment()
            fragment.arguments = args
            return  fragment

        }

    }


}
