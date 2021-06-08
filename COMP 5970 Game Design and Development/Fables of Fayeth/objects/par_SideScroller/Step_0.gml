/// @description Insert description here
// You can write your code in this editor

var seconds_passed = delta_time/1000000;
var move_speed_this_frame = move_speed*seconds_passed;

var move_xinput = 0;
var move_yinput = 0;
 
for ( var i = 0; i < array_length_1d(movement_inputs); i++){
    var this_key = movement_inputs[i];
    if keyboard_check(this_key) {
        var this_angle = i*90;
        move_xinput += lengthdir_x(1, this_angle);
        move_yinput += lengthdir_y(1, this_angle);
    }
	
}
if keyboard_check_pressed(vk_control)
{
	dashing = true;
}
if keyboard_check_pressed(vk_space)
{
	jumping = true;
}


var moving = (point_distance(0,0,move_xinput,move_yinput) > 0 );
if moving  {
	if (jumping == true)
	{
		var jump_dir = point_direction(0,0,move_xinput,move_yinput);
		jump(move_speed_this_frame, jump_dir);
		
	}
	if (dashing == false) && (jumping == false)
	{
		var move_dir = point_direction(0,0,move_xinput,0);
		move(move_speed_this_frame,  move_dir);
	} else if ((dashing == true) && (can_dash == true) && (jumping == false))
	{
		var dash_dir = point_direction(0,0,move_xinput,move_yinput);
		dash(move_speed_this_frame,  dash_dir);
		alarm[0] = delta_time * stamina; //stamina seconds
	}
}