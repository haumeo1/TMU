void ApplicationFunctionSet::ApplicationFunctionSet_Obstacle(void)
{
    static bool first_is = true;
    if (Application_SmartRobotCarxxx0.Functional_Mode == ObstacleAvoidance_mode)
    {
        uint8_t switc_ctrl = 0;
        uint16_t get_Distance;

        // Set servo to 90 degrees initially
        if (first_is == true) 
        {
            AppServo.DeviceDriverSet_Servo_control(90 /* Position_angle */);
            first_is = false;
        }
 

        // Stop the robot if it leaves the ground
        if (Car_LeaveTheGround == false)
        {
            ApplicationFunctionSet_SmartRobotCarMotionControl(stop_it, 0);
            return;
        }

        AppULTRASONIC.DeviceDriverSet_ULTRASONIC_Get(&get_Distance /* out */);

        // Perform ultrasonic distance detection from 0° (left) to 180° (right)
        for (int angle = 0; angle <= 180; angle += 30) 
        {
            AppServo.DeviceDriverSet_Servo_control(angle /* Position_angle */);
            delay_xxx(1);  // Small delay to allow servo to move

            AppULTRASONIC.DeviceDriverSet_ULTRASONIC_Get(&get_Distance /* out */);

            // If obstacle is detected within 20 cm
            if (function_xxx(get_Distance, 0, 20)) 
            {
                ApplicationFunctionSet_SmartRobotCarMotionControl(stop_it, 0);  // Stop the car

                // Handling based on the current angle
                if (angle == 180) 
                {
                    // Obstacle detected at 180° (rightmost), reverse and turn right
                    ApplicationFunctionSet_SmartRobotCarMotionControl(Backward, 30);
                    delay_xxx(500);
                    if (Car_LeaveTheGround == false)
                                {
                                    ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 10);
                                }
                    delay_xxx(50);
                    ApplicationFunctionSet_SmartRobotCarMotionControl(Right, 30);
                    delay_xxx(50);
                } 
                else if (angle == 0) 
                {
                    // Obstacle detected at 0° (leftmost), reverse and turn left
                    ApplicationFunctionSet_SmartRobotCarMotionControl(Backward, 30);
                    delay_xxx(500);
                    if (Car_LeaveTheGround == false)
                                {
                                    ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 10);
                                    return;
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
                first_is = true;
                break;  // Break the loop once an obstacle is detected
            }
        }

        // If no obstacles within 20 cm, move forward slowly
        ApplicationFunctionSet_SmartRobotCarMotionControl(Forward, 30);
    }
    else
    {
        first_is = true;  // Reset state when not in obstacle avoidance mode
    }
}