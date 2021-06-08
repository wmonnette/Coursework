/// @description Global Variables
global.selected = noone;
global.enemy = noone;
global.state = turn_states.player_turn;
global.moving = false;
global.attacking = false;
global.attack_travel_x = 0;
global.attack_travel_y = 0;
global.damage_dealt = 0;

global.ai_selected = noone;
global.ai_id = 1;
global.ai_active = false;

//loop variables - check entire grid
row = 0;