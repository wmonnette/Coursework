/// @description Insert description here
// You can write your code in this editor
event_inherited();
just_attacked = false;

//Idle Sprites
sprites[sprite_states.idle, dir.right] = spr_DefaultIdle;
sprites[sprite_states.idle, dir.left] = spr_DefaultIdle;
sprites[sprite_states.idle, dir.up] = spr_DefaultIdle;
sprites[sprite_states.idle, dir.down] = spr_DefaultIdle;
//MovingSprites
sprites[sprite_states.moving, dir.right] = spr_DefaultRight;
sprites[sprite_states.moving, dir.left] = spr_DefaultLeft;
sprites[sprite_states.moving, dir.up] = spr_DefaultUp;
sprites[sprite_states.moving, dir.down] = spr_DefaultDown;
//Attack1 Sprites
sprites[sprite_states.attack, dir.right] = spr_DefaultAttack;
sprites[sprite_states.attack, dir.down] = spr_DefaultAttack;
sprites[sprite_states.attack, dir.left] = spr_DefaultAttack;
sprites[sprite_states.attack, dir.up] = spr_DefaultAttack;

// Death
sprites[sprite_states.death, dir.right] = spr_DefaultDead;
sprites[sprite_states.death, dir.left] = spr_DefaultDead;
sprites[sprite_states.death, dir.up] = spr_DefaultDead;
sprites[sprite_states.death, dir.down] = spr_DefaultDead;

//Specific Variables
charSpeed = 4;

tile_distance = 4;

current_node_x = x;
current_node_y = y;
attack = 50;
defense = 100;