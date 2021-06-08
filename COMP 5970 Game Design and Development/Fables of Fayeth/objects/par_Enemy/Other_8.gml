/// @description Ending Move State
if (has_moved == true) 
{
	global.selected.current_state = sprite_states.idle;

	image_blend = c_gray;
}