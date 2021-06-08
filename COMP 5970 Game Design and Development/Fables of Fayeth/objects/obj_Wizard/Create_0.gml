/// @description Insert description here
// You can write your code in this editor
event_inherited();
just_attacked = false;

//Idle Sprites
sprites[sprite_states.idle, dir.right] = spr_wizardIdle;
sprites[sprite_states.idle, dir.left] = spr_wizardIdle;
sprites[sprite_states.idle, dir.up] = spr_wizardIdle;
sprites[sprite_states.idle, dir.down] = spr_wizardIdle;
//Movement Sprites
sprites[sprite_states.moving, dir.right] = spr_wizardRun;
sprites[sprite_states.moving, dir.left] = spr_wizardRun;
sprites[sprite_states.moving, dir.up] = spr_wizardRun;
sprites[sprite_states.moving, dir.down] = spr_wizardRun;
//Attack1 Sprites
sprites[sprite_states.attack, dir.right] = spr_wizardAttack1;
sprites[sprite_states.attack, dir.left] = spr_wizardAttack1;
sprites[sprite_states.attack, dir.up] = spr_wizardAttack1;
sprites[sprite_states.attack, dir.down] = spr_wizardAttack1;

// Death
sprites[sprite_states.death, dir.right] = spr_DefaultDead;
sprites[sprite_states.death, dir.left] = spr_DefaultDead;
sprites[sprite_states.death, dir.up] = spr_DefaultDead;
sprites[sprite_states.death, dir.down] = spr_DefaultDead;

//Specific Variables
charSpeed = 8;
tile_distance = 4;
attack = 50;
defense = 100;

current_node_x = x;
current_node_y = y;