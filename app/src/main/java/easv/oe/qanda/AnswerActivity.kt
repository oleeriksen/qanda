package easv.oe.qanda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val q = intent.extras?.getString("question")
        tvQuestion.text = "$q?"
    }

    fun onClickAnswer(view: View) {
      val intent = Intent()
        intent.putExtra("answer", etAnswer.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    fun onClickCancel(view: View) {
        setResult(RESULT_CANCELED)
        finish()
    }
}