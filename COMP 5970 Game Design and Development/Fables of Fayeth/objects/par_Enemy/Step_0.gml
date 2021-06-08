/// @description Sprites and States
sprite_index = sprites[current_state];
pixel_distance = tile_distance * tile_size;

if (just_attacked == true) && (image_index >= image_number -1)
{
	alarm[0] = 1;
}
if (just_hit == true) && (image_index >= image_number -1)
{
	alarm[1] = 1;
}
debug1 = string(current_state) + "State";
show_debug_message(debug1);
debug2 = string(just_attacked) + "Attacked";
show_debug_message(debug2);
