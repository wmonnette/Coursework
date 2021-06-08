/// @description Insert description here
// You can write your code in this editor
image_xscale = -1;
event_inherited();
just_attacked = false;
//Idle Sprites
sprites[sprite_states.idle, dir.right] = spr_EnemySwordIdle;
sprites[sprite_states.idle, dir.left] = spr_EnemySwordIdle;
sprites[sprite_states.idle, dir.up] = spr_EnemySwordIdle;
sprites[sprite_states.idle, dir.down] = spr_EnemySwordIdle;
//Run Sprites
sprites[sprite_states.moving, dir.right] = spr_EnemySwordRun;
sprites[sprite_states.moving, dir.left] = spr_EnemySwordRun;
sprites[sprite_states.moving, dir.up] = spr_EnemySwordRun;
sprites[sprite_states.moving, dir.down] = spr_EnemySwordRun;
//Hit Sprites
sprites[sprite_states.hit, dir.right] = spr_EnemySwordHit;
sprites[sprite_states.hit, dir.left] = spr_EnemySwordHit;
sprites[sprite_states.hit, dir.up] = spr_EnemySwordHit;
sprites[sprite_states.hit, dir.down] = spr_EnemySwordHit;
// Death
sprites[sprite_states.death, dir.right] = spr_DefaultDead;
sprites[sprite_states.death, dir.left] = spr_DefaultDead;
sprites[sprite_states.death, dir.up] = spr_DefaultDead;
sprites[sprite_states.death, dir.down] = spr_DefaultDead;


//Specific Variables
charSpeed = 5;
tile_distance = 6;
attack = 50;
defense = 100;

just_attacked = false;
has_moved = false;
has_target = false;

current_node_x = x;
current_node_y = y;