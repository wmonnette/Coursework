/// @description Sprites, States, and Tile Distances

current_state = sprite_states.idle;
direction_facing = dir.left;

charSpeed = 5;

tile_distance = 3;
original_tile_distance = tile_distance;
tile_size = 64;
pixel_distance = tile_distance * tile_size;
has_moved = false;
just_attacked = false;
just_hit = false;