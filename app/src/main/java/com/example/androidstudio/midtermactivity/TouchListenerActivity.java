package com.example.androidstudio.midtermactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TouchListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_listener);

            final ImageView image = (ImageView) findViewById(R.id.imageView2);
final TextView valXY = (TextView) findViewById(R.id.txtVal);
        final TextView diffXY = (TextView) findViewById(R.id.txtDif);
        final TextView motionXY = (TextView) findViewById(R.id.txtMotion);
        final TextView motionXY2 = (TextView) findViewById(R.id.txtMotion2);
        final TextView quadrantXY = (TextView) findViewById(R.id.txtQuad);

            image.setOnTouchListener(new View.OnTouchListener() {
                float iniX, finX, iniY, finY,difX,difY, quadiniX ,quadiniY,quadfinX,quadfinY ,quadDifX, quadDifY;
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    //int event = motionEvent.getAction();
                    switch (motionEvent.getAction()) {
                        // switch (event) {
                        case MotionEvent.ACTION_DOWN:
                            //Toast.makeText(context, text, duration);

                            iniX = motionEvent.getX();
                            iniY = motionEvent.getY();
                            quadfinX = motionEvent.getX();
                            quadfinY = motionEvent.getY();
                            valXY.setText("Value of X: " + iniX + "Value of Y: " + iniY);
                            //Toast.makeText(TouchListenerActivity.this, "Value of X: " + iniX + "Value of Y: " + iniY, Toast.LENGTH_SHORT).show();
                            break;
                        //return true;
                        case MotionEvent.ACTION_UP:
                            finX = motionEvent.getX();
                            finY = motionEvent.getY();

                            quadiniX = motionEvent.getX();
                            quadiniY = motionEvent.getY();

                            quadDifX = quadiniX - quadfinX;
                            quadDifY = quadiniY - quadfinY;

                           difX = finX - iniX;
                           difY = finY - iniX;

                            //Quadrant 4
                            if (quadDifX >= 0 && quadDifY < 0){
                                //Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 1", Toast.LENGTH_LONG).show();
                                quadDifX = finX - iniX;
                                quadDifY = iniY - finY;
                                diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                               // quadrantXY.setText("Quadrant 1");
                            }
                            //Quadrant 1
                            else if (quadDifX >= 0 && quadDifY >= 0){
                                //Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 4", Toast.LENGTH_LONG).show();
                                quadDifX = finX - iniX;
                                quadDifY = iniY - finY;
                                diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                                //quadrantXY.setText("Quadrant 4");
                            }

                            //Quadrant 3
                            if (quadDifX < 0 && quadDifY < 0){
                                //Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 2", Toast.LENGTH_LONG).show();
                                quadDifX = finX - iniX;
                                quadDifY = iniY - finY;
                                diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                                //quadrantXY.setText("Quadrant 2");
                            }
                            //Quadrant 2
                            else if (quadDifX < 0 && quadDifY >= 0){
                                //Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 3", Toast.LENGTH_LONG).show();
                                quadDifX = finX - iniX;
                                quadDifY = iniY - finY;
                                diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                                //quadrantXY.setText("Quadrant 3");
                            }


                           //Quadrant 4
                          if (difX >= 0 && difY < 0){
                             // Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 4", Toast.LENGTH_LONG).show();
                              //diffXY.setText("Difference of X: " + difX + " Y: " + difY);
                              diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                          }
                           //Quadrant 1
                          else if (difX >= 0 && difY >= 0){
                             // Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 1", Toast.LENGTH_LONG).show();
                             // diffXY.setText("Difference of X: " + difX + " Y: " + difY);
                              diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                           }

                           //Quadrant 3
                           if (difX < 0 && difY < 0){
                              // Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 3", Toast.LENGTH_LONG).show();
                              // diffXY.setText("Difference of X: " + difX + " Y: " + difY);
                               diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                           }
                            //Quadrant 2
                           else if (difX < 0 && difY >= 0){
                             // Toast.makeText(TouchListenerActivity.this, "Difference of X: " + difX + " Y: " + difY + " Quadrant 2", Toast.LENGTH_LONG).show();
                               //diffXY.setText("Difference of X: " + difX + " Y: " + difY);
                               diffXY.setText("Difference of X: " + quadDifX + " Y: " + quadDifY);
                            }




                            if(iniX > finX) {
                                //Toast.makeText(TouchListenerActivity.this, "Right to Left Swipe, X: " + finX + "Y: " + finY, Toast.LENGTH_LONG).show();
                                motionXY.setText("Right to Left Swipe, X: " + finX + " Y: " + finY);
                            }
                            if(iniX < finX) {
                                //Toast.makeText(TouchListenerActivity.this, "Left to Right Swipe, X: " + finX + "Y: " + finY, Toast.LENGTH_LONG).show();
                                motionXY.setText( "Left to Right Swipe, X: " + finX + " Y: " + finY);
                            }
                            if(iniY < finY){
                               // Toast.makeText(TouchListenerActivity.this, "Up to Down Swipe, X: " + finX + "Y: " + finY, Toast.LENGTH_SHORT).show();
                                motionXY2.setText("Up to Down Swipe, X: " + finX + " Y: " + finY);
                            }
                            if(iniY > finY){
                               // Toast.makeText(TouchListenerActivity.this, "Down to Up Swipe, X: " + finX + "Y: " + finY, Toast.LENGTH_SHORT).show();
                                motionXY2.setText("Down to Up Swipe, X: " + finX + " Y: " + finY);
                            }

                            if (iniX < finX && iniY < finY) {
                                quadrantXY.setText("Quadrant 4");
                            }
                            if (iniX < finX && iniY > finY){
                                quadrantXY.setText("Quadrant 1");
                            }
                            if (iniX > finX && iniY > finY) {
                                quadrantXY.setText("Quadrant 2");
                            }
                            if (iniX > finX && iniY < finY){
                                quadrantXY.setText("Quadrant 3");
                            }

                            break;
                        //return true;

                        //@Override
                        //public boolean onTouchEvent(MotionEvent event) {
                        //int x = (int)event.getX();
                        //int y = (int)event.getY();
                        //switch (event.getAction()) {
                        //case MotionEvent.ACTION_DOWN:
                        //  case MotionEvent.ACTION_MOVE:
                        //    case MotionEvent.ACTION_UP:
                        //  }
                        //    return false;
                        //  }
                    }
                    //return false;
                    return true;
                }
            });
        }
    }

