package et.edu.aait.listdetailfragmentappliction


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import et.edu.aait.listdetailapplication.Course
import kotlinx.android.synthetic.main.fragment_course_list.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class CourseListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listener: OnCourseSelected

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnCourseSelected){
            listener = context
        } else{
            throw ClassCastException(context.toString()+" must implement OnCourseSelected")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_course_list, container, false)

        val activity = activity as Context
        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CourseAdapter(activity)
        recyclerView.setHasFixedSize(true)

        return view
    }
   inner class CourseAdapter(val context: Context):RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

        private val courses = listOf(

            Course("Software Engineering II", "ITSE-3212",7,"Software Engineering II description"),
            Course("Advanced Mobile Programming", "ITSE-3223",7,"Advanced Mobile Programming description"),
            Course("Operating System", "ITSE-3253",7,"Operating System description")
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

            val inflater = LayoutInflater.from(parent.context)
            val recyclerViewItem = inflater.inflate(R.layout.recycler_view_item, parent, false)

            return CourseViewHolder(recyclerViewItem)
        }

        override fun getItemCount(): Int {
            return courses.size
        }

        override fun onBindViewHolder(viewHolder: CourseViewHolder, position: Int) {
            val course = courses[position]

            viewHolder.itemView.list_title_textview.text = course.title
            viewHolder.itemView.list_code_textview.text = course.code

            viewHolder.itemView.setOnClickListener {
                listener.onCourseSelected(course)
            }

        }

        inner class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    }

    interface OnCourseSelected {
        fun onCourseSelected(course: Course)
    }
}


