/// @description Insert description here
// You can write your code in this editor
event_inherited();
just_attacked = false;

//Idle Sprites
sprites[sprite_states.idle, dir.right] = spr_HeroIdle;
sprites[sprite_states.idle, dir.left] = spr_HeroIdle;
sprites[sprite_states.idle, dir.up] = spr_HeroIdle;
sprites[sprite_states.idle, dir.down] = spr_HeroIdle;
//Movement Sprites
sprites[sprite_states.moving, dir.right] = spr_HeroRun;
sprites[sprite_states.moving, dir.left] = spr_HeroRun;
sprites[sprite_states.moving, dir.up] = spr_HeroRun;
sprites[sprite_states.moving, dir.down] = spr_HeroRun;
//Attack 1 Sprites
sprites[sprite_states.attack, dir.right] = spr_HeroAttack1;
sprites[sprite_states.attack, dir.left] = spr_HeroAttack1;
sprites[sprite_states.attack, dir.up] = spr_HeroAttack1;
sprites[sprite_states.attack, dir.down] = spr_HeroAttack1;

// Death
sprites[sprite_states.death, dir.right] = spr_DefaultDead;
sprites[sprite_states.death, dir.left] = spr_DefaultDead;
sprites[sprite_states.death, dir.up] = spr_DefaultDead;
sprites[sprite_states.death, dir.down] = spr_DefaultDead;

//Specific Variables
charSpeed = 5;
tile_distance = 6;
current_node_x = x;
current_node_y = y;
attack = 50;
defense = 100;