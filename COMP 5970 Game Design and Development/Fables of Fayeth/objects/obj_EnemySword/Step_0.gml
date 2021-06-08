/// @description Insert description here
// You can write your code in this editor
event_inherited();
pixel_distance = tile_distance * tile_size;

if (xprevious > x) && (yprevious == y)
{
	direction_facing = dir.left;
} else if (xprevious < x) && (yprevious == y)
{
	direction_facing = dir.right;
} else if (yprevious > y) 
{
	direction_facing = dir.up;
} else if (yprevious < y) 
{
	direction_facing = dir.down;
}

//if (current_state == spr_DefaultDead) {
//	if (image_index >= image_index - 1) {
//		instance_destroy();
//	}
//}
sprite_index = sprites[current_state, direction_facing];