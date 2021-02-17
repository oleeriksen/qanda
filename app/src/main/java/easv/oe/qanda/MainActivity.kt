package easv.oe.qanda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ANSWER = 12
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Q & A"
    }

    fun onClickAsk(view: View) {
        val i = Intent(this, AnswerActivity::class.java)
        i.putExtra("question", etQuestion.text.toString())
        startActivityForResult(i, REQUEST_CODE_ANSWER)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ANSWER) {
            if (resultCode == RESULT_CANCELED)
                tvAnswer.text = "no answer"
            else
                tvAnswer.text = data?.extras?.getString("answer")
        }
    }
}