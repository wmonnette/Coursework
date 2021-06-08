/// @description Sprite Indexing & State Machine

sprite_index = sprites[current_state, direction_facing];
pixel_distance = tile_distance * tile_size;

if (just_attacked == true) && (image_index >= image_number -1)
{
	alarm[0] = 1;
}
if (just_hit == true) && (image_index >= image_number -1)
{
	alarm[1] = 1;
}
