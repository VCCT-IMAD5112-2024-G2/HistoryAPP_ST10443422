package com.example.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //List of Famous people and their age
    enum class HistoryAPP(val age: Int, val description: String){
        PERSON_1(20, "Xxxtentacion, who died at the age of 20. He was a rapper, singer and song writer."),
        PERSON_2(25, "John Keats, who died at the age of 25. She was a poet in the 19th century."),
        PERSON_3(30, "Sylvia Plath, who died at the age of 30. She was an American poet and novelist."),
        PERSON_4(35, "Andy Kaufman, who died at the age of 35. He was a comedian/entertainer and performer."),
        PERSON_5(40, "Paul Walker, who died at the age of 40. He was an actor."),
        PERSON_7(45, "Walter Payton, who died at the age of 45. He was a American footballer."),
        PERSON_8(50, "Michael Jackson, who died at the age of 50. He was a singer in America."),
        PERSON_9(55, "Henry VIII, who died at 55. He was the king of England from 1509-1547."),
        PERSON_10(60, "Theodore Roosevelt, who died at 60. He was the 26th American president."),
        PERSON_11(65, "Walt Disney, who died at the age of 65. He was an animator, voice actor."),
        PERSON_12(70, "Luis Vuitton, who died at the age of 70. He was fashion designer."),
        PERSON_13(75, "Tom Wilkinson, who died at the age of 75. He was a famous british actor."),
        PERSON_14(80, "Alex Trebek, who died at the age of 80. He was a game show host."),
        PERSON_15(85, "Daniel Boone, who died at the age of 85. He was an Explorer."),
        PERSON_16(90,"Enzo Ferrari, who died at the age of 90.He was an automobile manufacturer and racing-car driver."),
        PERSON_17(95,"Nelson Mandela, who died at the age of 95. He was the president of South Africa from 1994 to 1999."),
        PERSON_18(100,"Alf Landon, who died at the age of the 100. He was an American oilman and politician."),
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //Getting layout components
        val edtAgeOfPerson = findViewById<EditText>(R.id.edtAge)
        val btnResult = findViewById<Button>(R.id.btnGenerate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResult)


        //Programming the clear button
        btnClear.setOnClickListener {
            edtAgeOfPerson.text.clear()
            txtResult.text = ""

            //If the user presses the Generate Answer button
            btnResult?.setOnClickListener()
            {
                val birthYear = edtAgeOfPerson.text.toString().toInt()

                if (birthYear != null && birthYear in 20..100) {
                    //Grabbing the values of the age in the list of famous person
                    val personAge = HistoryAPP.values().map { it.age }

                    val famousPerson = when (birthYear) {
                        //This statement will be run if the age matches exactly the year of the famous person
                        in personAge -> {
                            val description = HistoryAPP.values().find { it.age == birthYear }
                            listOf(" Your age is $birthYear which is same as ${description?.description ?: "person"}")
                        }
                        //Map function will transform each enum constant into its corresponding age value
                        //This statement will be run if the age is one year before the age of famous person
                        in personAge.map { it - 1 } -> {
                            val description = HistoryAPP.values().find { it.age == birthYear + 1 }
                            listOf(
                                "Your age is one year before the famous person, " +
                                        "${description?.description ?: "person"}"
                            )
                        }
                        //This statement will be run if the age is one year after the age of famous person
                        in personAge.map { it + 1 } -> {
                            val description = HistoryAPP.values().find { it.age == birthYear - 1 }
                            listOf(
                                "Your age is one year after the famous person, " +
                                        "${description?.description ?: "person"}"
                            )
                        }
                        //This statement will run if the age is two years before the age of famous person
                        in personAge.map { it - 2 } -> {
                            val description = HistoryAPP.values().find { it.age == birthYear + 2 }
                            listOf(
                                "Your age is two years before the famous person, " +
                                        "${description?.description ?: "person"}"
                            )
                        }
                        //This statement will be run if the age is two years after the age of famous person
                        in personAge.map { it + 2 } -> {
                            val description = HistoryAPP.values().find { it.age == birthYear - 2 }
                            listOf(
                                "Your age is two years after the famous person, " +
                                        "${description?.description ?: "naaaah"}"
                            )
                        }
                        //This statement will run if the age is not the same or close to the year of famous person's age
                        else -> listOf("No famous person matches your $birthYear.")
                    }
                    txtResult.text = famousPerson.joinToString("\n")
                } else {
                    txtResult.text = "No famous person found at the age of $birthYear "


                }

            }
            }
        }
    }

