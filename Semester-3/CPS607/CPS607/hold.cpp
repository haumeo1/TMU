void ApplicationFunctionSet::ApplicationFunctionSet_Obstacle(void)
{
 static boolean first_is = true;
 if (Application_SmartRobotCarxxx0.Functional_Mode == ObstacleAvoidance_mode)
 {
   uint8_t switc_ctrl = 0;
   uint16_t get_Distance;
   if (Car_LeaveTheGround == false)
   {
     ApplicationFunctionSet_SmartRobotCarMotionControl(stop_it, 0);
     return;
   }
   if (first_is == true) //Enter the mode for the first time, and modulate the steering gear to 90 degrees
   {
     AppServo.DeviceDriverSet_Servo_control(90 /*Position_angle*/);
     first_is = false;
   }

   AppULTRASONIC.DeviceDriverSet_ULTRASONIC_Get(&get_Distance /*out*/);
   if (function_xxx(get_Distance, 0, 20))
   {
     ApplicationFunctionSet_SmartRobotCarMotionControl(stop_it, 0);

     for (int angle = 0; angle <=180 ; angle+=30) //1、3、5 Omnidirectional detection of obstacle avoidance status
     {
       AppServo.DeviceDriverSet_Servo_control(angle /*Position_angle*/);
       delay_xxx(1);
       AppULTRASONIC.DeviceDriverSet_ULTRASONIC_Get(&get_Distance /*out*/);
        if (angle == 180)
         {
           ApplicationFunctionSet_SmartRobotCarMotionControl(Backward, 30);
           delay_xxx(500);
            if (Car_LeaveTheGround == false)
              {
                 ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 10);
            }
           ApplicationFunctionSet_SmartRobotCarMotionControl(Right, 30);
           delay_xxx(50);
           first_is = true;
           break;
         }
       }
       else if (angle == 0) 
                {
                    // Obstacle detected at 0° (leftmost), reverse and turn left
                    ApplicationFunctionSet_SmartRobotCarMotionControl(Backward, 30);
                    delay_xxx(500);
                    if (Car_LeaveTheGround == false)
                                {
                                    ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 10);
                                }
                    delay_xxx(50);
                    ApplicationFunctionSet_SmartRobotCarMotionControl(Left, 30);
                    delay_xxx(50);
                } 
       else
       {
         // Perform different actions depending on the angle
                    switch (angle) 
                    {
                        case 30:
                            ApplicationFunctionSet_SmartRobotCarMotionControl(Left, 30); // Turn left slowly
                            break;
                        case 60:
                            ApplicationFunctionSet_SmartRobotCarMotionControl(Left, 10); // Turn slightly left
                            break;
                        case 90:
                            ApplicationFunctionSet_SmartRobotCarMotionControl(Backward, 30); // Move backward
                            delay_xxx(50);
                            if (Car_LeaveTheGround == false)
                                {
                                    ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 10);
                                    return;
                                }
                            break;
                        case 120:
                            ApplicationFunctionSet_SmartRobotCarMotionControl(Right, 10); // Turn slightly right
                            break;
                        case 150:
                            ApplicationFunctionSet_SmartRobotCarMotionControl(Right, 30); // Turn right slowly
                            break;
                    }
     }
   }
   else //if (function_xxx(get_Distance, 20, 50))
   {
     ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 50);
   }
 }
 else
 {
   first_is = true;
 }
}