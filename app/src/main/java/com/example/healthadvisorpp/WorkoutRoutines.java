package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRoutines extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routines);

        //routine spinnner
        Spinner rspinner = findViewById(R.id.spinner);
        List<String> routines = new ArrayList<>();
        routines.add(0, "Please select an exercise");   //
        routines.add("Burpees");                        // 10 calories per mintue
        routines.add("Dumbell rows");                   //  3 calories per minute
        routines.add("Overhead dumbbell presses");      //  6 calories per minute
        routines.add("Lunges");                         //  6 calories per minute
        routines.add("Pushups");                        // 11 calories per minute
        routines.add("Planks");                         // 2-5 calrioes per mintute. average: 3.5
        routines.add("Side planks");                    //  3 calroies per minute
        routines.add("Single-leg deadlifts");           //  4 calories per minute
        routines.add("Jumping Jacks");                  // 11 calroies per minute
        routines.add("Squats");                         //  8 calories per minute
        routines.add("Mountain Climbers");              // 11.25 calories per minute
        routines.add("Crunches");                       //  6 calories per minute
        routines.add("Sit-ups");                        //  3 calroies per minute
        routines.add("Glute Brigdes");                  //  2 calories per minute
        routines.add("Planks to Downward Dog");         //  2 calories per minute
        routines.add("Bicycles");                       //  4 calories per minute
        routines.add("Calf Raises");                    // 34 calories in 15 seconds
        routines.add("Skipping");                       // 17.5 calories per minute
        routines.add("Bench Dips");                     //  3 calories per mintue
        routines.add("Thrusters");                      // 10 calories per minute
        routines.add("Dumbbell floor press");           //  4 calories per mintue
        routines.add("Deadbug");                        // 9.2 calories per minute
        routines.add("Bicep curl");                     // 7.5 calories per minute
        routines.add("Jumping Lunges");                 //  6 calories per minute
        ArrayAdapter<String> routinespinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, routines);
        routinespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rspinner.setAdapter(routinespinner);
        rspinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        TextView routinedescription = findViewById(R.id.routinedescription);
        if(position != 0)
            routinedescription.setVisibility(View.VISIBLE);
        switch (position) {
            case 0:
                routinedescription.setVisibility(View.GONE);
                break;
            case 1:
                routinedescription.setText("" +
                        "1. Start in a squat position with your knees bent, back straight, and your feet about" +
                        "shoulder-width apert\n" +
                        "2. Lower your hands to the floor in front of you so they're just inside your feet\n" +
                        "3. With your weight on your hands, kick your feet back so you're on your hands and toes," +
                        " and in a pushup position.\n" +
                        "4. Keeping your body straight from head to heels, do one pushup. Remember not to let" +
                        "your back sag or to stick your butt in the air.\n" +
                        "5. Do a frog kick by jumping your feet back their starting position.\n" +
                        "6. Stand and reach your arms over your head.\n" +
                        "7. Jump quickly into the air so you land back where you started.\n" +
                        "8. As soon as you land with knees bent, get into a sqaut position and do another repetition\n");
                break;
            case 2:
                routinedescription.setText(""+
                        "1. Start by grabbing a pair of dumbbells, and stand with your feet hip-width apart.\n" +
                        "2. Evenly distribute your weight, and grip the floor with your feet to create a stable\n" +
                        " position.\n" +
                        "3. While maintaining a neutral spine, hinge your hips backward.\n" +
                        "4. Initiate the upward movement by squeezing your lats-the muscles located along the sides\n" +
                        " of your back.\n" +
                        "5. Your shoulder blades should retract as you oull the dumbbells toward the outside of your\n" +
                        " upper leg.\n" +
                        "6. While maintaining your rowing alignment, straighten your elbows, and allow the dumbbells \n" +
                        " to travel back to the starting position.\n");
                break;
            case 3:
                routinedescription.setText(""+
                        "1. Stand with your feet shoulder-width apart and hold a dumbbell in each hand.\n" +
                        "2. With your palms facing forward and your elbows under your wrists, position the dumbbells at\n " +
                        " your shoulders.\n" +
                        "3. Push the dumbbells up and fully extend your arms.\n" +
                        "4. Lower the dumbbells back down to your shoulders and repeat the movement until the set is \n " +
                        " complete.\n");
                break;
            case 4:
                routinedescription.setText(""+
                        "1. Stand with your feet hip-width apart, keep your back straight, your shouldders back, and your \n " +
                        " abs tight.\n" +
                        "2. Take a step forward and slowly bend both kneeesm until your back knee is just above the floor.\n" +
                        "3. Stand back up and repeat the movement.\n" +
                        "4. Alternate legs until the set is complete.\n");
                break;
            case 5:
                routinedescription.setText(""+
                        "1.Get down on all fours, plaicing your hands slightly wider than your shoulders.\n" +
                        "2. Straighted your arms and legs.\n" +
                        "3. Lower your body until your chest nearly touches the floor.\n" +
                        "4. Pause, then push yourself back up.\n" +
                        "5. Repeat\n");
                break;
            case 6:
                routinedescription.setText(""+
                        "1.Lay on your rigt side with feet together and forearm beneath your shoulder.\n" +
                        "2. Engage your core and raise your hips so your body is in a straight line from your feet to \n"+
                        "your head.\n" +
                        "3. Hold this position for as long as you can. If you can, aim 30 seconds.\n"
                );
                break;
            case 7:
                routinedescription.setText(""+
                        "1. Lie on your side with your body fully extended.\n" +
                        "2. Lift your body off the ground and balanace your wieght between the forarm and the side \n" +
                        " of the foot.\n" +
                        "3. Keep your body in a straight line and hild for as long as you can.\n" +
                        "4. Change sides and repeat.\n");
                break;
            case 8:
                routinedescription.setText("" +
                        "1. Begin standing with a dumbbell in your right hand with your knees slightly bent\n" +
                        "2. Hinging at the hips, begin to kick your left leg straight back behind you,\n" +
                        "lowering the dumbbell down towards the ground\n" +
                        "3. When you reach a comfortable height with your left leg, slowly return to the starting\n" +
                        "position in a controlled motion, squeezing your right glute. Ensure that your pelvis stays\n" +
                        "square to the ground during the movement\n" +
                        "4. Repeat 10 to 12 reps before moving the weight to your left hand and repeating the same\n" +
                        "steps on the left leg\n");
                break;
            case 9:
                routinedescription.setText("" +
                        "1. Stand upright with your legs together, arms at your sides.\n" +
                        "2. Bend your knees slightly, and jump into the air.\n" +
                        "3. As you jump, spread your legs to be about shoulder-width apart. Stretch you arms out \n" +
                        " and over your head\n" +
                        "4. Jump back to starting position.\n" +
                        "5. repeat\n");
            case 10:
                routinedescription.setText("" +
                        "1. Lie down on your back. Plant your feet on the floor, hip-width apart.\n" +
                        "Bend your knees and place your arms across your chest.\n" +
                        "Contract your abs and inhale.\n" +
                        "2. Exhale and lift your upper body, keeping your head and neck relaxed.\n" +
                        "3. Inhale and return to the starting position.\n");
                break;
            case 11:
                routinedescription.setText("" +
                        "1. Lie down on your back Bend your legs and place feet firmly on the ground to stabilise\n " +
                        " your lower body.\n" +
                        "Cross your hand to the opposite shoulders over your chest or place them behhind your ears,\n " +
                        " without pulling on your neck.\n" +
                        "2. Curl your upper body all the way up toward your knees. Exhale as you lift.\n" +
                        "3. Slowly, lower yourself down, returning to your starting point. Inhale as you lower.\n");
                break;
            case 12:
                routinedescription.setText("" +
                        "1. Start by lying on the floor with your knees bent, feet flat on the ground, and arms straight\n" +
                        " at your sides with your palms facing down.\n" +
                        "2. Pushing through your heels, raise your hips off the ground by squeezing your core, glutes,\n" +
                        " and hamstrings.\n" +
                        "Your upper back and shoulders should still be in contact with the ground, and your core down\n" +
                        " to your knee should form a straight line.\n" +
                        "3. Pause 1-2 seconds at the top and return to the starting position.\n" +
                        "4. Repeat. Complete 10-12 reps for 3 stes.\n");
                break;
            case 13:
                routinedescription.setText("" +
                        "1. Get into a high plank position, with your hands stacked underneath your shoulders and your\n" +
                        " feet close together.\n" +
                        "2. Keeping your core engaged and your hands and feet stationary, pike your hips up and back into\n " +
                        " the Downward Dog pose.\n" +
                        "Your body should form triangle with the ground.\n" +
                        "Keep your neck neutral. Your gaze should be dircted toward your feet.\n" +
                        "3. Hold here for a second, then return to the plank. Repeat.\n");
                break;
            case 14:
                routinedescription.setText("" +
                        "1. Lie on your back, feet in the air, knees bent.\n" +
                        "2. Place your hands behind your head.\n" +
                        "3. Begin pumping your legs in the classic bicycle motion, vigorously, for one minute.\n");
                break;
            case 15:
                routinedescription.setText("" +
                        "1.Face a wall and place your palms against it for balanace and support.\n" +
                        "2. Rise up onto your toes and back down.\n" +
                        "3. Repeat 20 times.\n");
                break;
            case 16:
                routinedescription.setText("" +
                        "1. Grab the rope at both ends.\n" +
                        "Use your wrists to flick it round your body, jumping to clear the rope as it hits the ground.\n");
                break;
            case 17:
                routinedescription.setText("" +
                        "1.Stand facing away from a bench, grab it with both hands at shoulder-width.\n" +
                        "2.Extend your legs out in front of you.\n" +
                        "3. Slowly lower your body by flexing at the elbows until your arm at forearm create a 90 degree\n " +
                        " angle.\n" +
                        "4. Using your triceps lift yourself back to the starting position.\n");
                break;
            case 18:
                routinedescription.setText("" +
                        "1. Hold two kettlebells or dumbbells by their handles but so the weight is resting on the back of\n " +
                        " your shoulder.\n" +
                        "2. Slightly bend your knees and squat down, keeping your legs in line with your shoulders.\n" +
                        "3. Drive through your legs and straighten them, extending your arms as you do so to raise the \n" +
                        " kettlebells above your head.\n" +
                        "4. Squat down and repeat.\n");
                break;
            case 19:
                routinedescription.setText("" +
                        "1. Lie down on the floor with a dumbbell in each hand\n" +
                        "2. Bend at the elbows and hold the weights above you.\n" +
                        "3. Press up and straighten your arms before pausing at the top of the rep and lowering slowly \n" +
                        " to the start position.\n");
                break;
            case 20:
                routinedescription.setText("" +
                        "1. Lie on your back with hands above you and feet up so your knees are at 90 degrees.\n" +
                        "2. Straighten your leg until your heel is an inch from the floor and then return to the start position.\n" +
                        "3. Repeat with the other leg.\n");
                break;
            case 21:
                routinedescription.setText("" +
                        "1. Stand with a dumbbell in each hand and, keeping your upper arms stationary, curl the weights\n " +
                        " until th dumbbells are at shoulder level.\n" +
                        "2. Focus on keeping your elbows still - only your lower arm should move.\n" +
                        "3. Squeeze your bicep at the top of the contraction then slowly and repeat.\n");
                break;
            case 22:
                routinedescription.setText("" +
                        "1. Lunge forward until your rear knee is almost touching the ground.\n" +
                        "2. Jump into the air, bringing your rear foot forward and the front foot back.\n" +
                        "3. Land in a lunge and repeat.\n" +
                        "4. Land on both feet simultaneously to cushion the impact on your joints.\n");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}