/// @description Options menu code - Resolution control
// You can write your code in this editor

if (keyboard_check_pressed(vk_up)) && (display_width > starting_height * global.window_scale) {

	global.window_scale += 0.5
	
	window_set_size(starting_height*global.window_scale, starting_width * global.window_scale);
	
	if (display_width <= starting_height * global.window_scale) 
	{
		
		window_set_position(0,0);
	} 
	else if (display_width > starting_height * global.window_scale) 
	{

		if (set_position == false) 
		{
			alarm[0] = 1;
			set_position = true;
		}
	}
} 
else if ((keyboard_check_pressed(vk_down)) && (global.window_scale >= 1)) 
{
	
	global.window_scale -= .5;
	
	window_set_size(starting_height*global.window_scale, starting_width * global.window_scale);
	
	if (display_width <= starting_height * global.window_scale) 
	{
		
		window_set_position(0,0);
	} 
	else if (display_width > starting_height * global.window_scale) 
	{
		
		if (set_position == false) {
			alarm[0] = 1;
			set_position = true;
		}
	}
} 