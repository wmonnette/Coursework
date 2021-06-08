/// @description Instance Variables

//Move Speed
move_speed = 200; //pixels per second - increase to upgrade spped

//Movement Inputs
movement_inputs[0] = ord("D");
movement_inputs[1] = ord("W");
movement_inputs[2] = ord("A");
movement_inputs[3] = ord("S");

//Dashing Variables
dashing = false;
can_dash = true;
stamina = 3; // seconds - subtract from to decrease dash cooldown

//Jumping Variables
jumping = false;
phy_fixed_rotation = true;