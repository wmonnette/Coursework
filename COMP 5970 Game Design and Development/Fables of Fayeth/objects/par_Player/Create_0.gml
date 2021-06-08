/// @description Enums, Sprites, States, and Tile Distances
enum sprite_states {
	
	idle,
	moving,
	attack,
	hit,
	death
	
}

enum dir 
{
	right,
	up,
	left,
	down
}

current_state = sprite_states.idle;
direction_facing = dir.right;
charSpeed = 5;

tile_distance = 3;
original_tile_distance = tile_distance;
tile_size = 64;
pixel_distance = tile_distance * tile_size;
has_moved = false;
just_attacked = false;
just_hit = false;