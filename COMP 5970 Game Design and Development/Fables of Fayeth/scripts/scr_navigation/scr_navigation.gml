/// @function scr_naviagtion(start_x, start_y, end_x, end_y, speed)
/// @param start_x
/// @param start_y
/// @param end_x
/// @param end_y
/// @param speed


var start_x = argument0;
var start_y = argument1;
var end_x = argument2;
var end_y = argument3;
var charSpeed = argument4;


if !(mp_grid_path(global.map_grid, global.navigate, start_x, start_y, end_x, end_y, 1)) {
	
	show_message("Unable to navigate");
	return false;
} 
else {
	mp_grid_path(global.map_grid, global.navigate, start_x, start_y, end_x, end_y, 1);
	global.selected.current_state = sprite_states.moving;
	path_start(global.navigate, charSpeed, 0, false);
}
