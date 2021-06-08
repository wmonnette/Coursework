if (instance_number(par_Player) < 1) {global.state = turn_states.fail_state;}

if (global.selected == noone) {
		if (global.ai_active == false) {
			ai_active = instance_number(par_Enemy) - global.ai_id;
			global.selected = instance_find(par_Enemy, ai_active);
			
			scr_place_tiles_ai();
			global.ai_active = true;
		
		}
}

with (global.selected) {
	if (global.ai_active == true) {
		nearest_target = instance_nearest(global.selected.x,global.selected.y,par_Player);
		nearest_move = instance_nearest(nearest_target.x, nearest_target.y,obj_TileWalkable_ai);
		nearest_attack = instance_nearest(global.selected.x,global.selected.y,obj_TileAttack_ai);
	}
	
	if (has_moved == false) {
		current_state = sprite_states.moving;
		scr_navigation(global.selected.x,global.selected.y, round(nearest_move.x/64)*64, round(nearest_move.y/64)*64, global.selected.charSpeed);
	}
	
	if (path_index == -1) {

		if (has_moved == false) {sprite_index = sprite_states.idle;}
		has_moved = true;
		if (instance_exists(obj_TileAttack_ai)) { global.enemy = instance_position(nearest_attack.x, nearest_attack.y, par_Player)}
		if (global.enemy != noone)  {scr_melee_attack_ai();}
		else { just_attacked = true;}
		with (obj_TileWalkable_ai) {instance_destroy();}
		current_node_x = round(global.selected.x/64)*64;
		current_node_y = round(global.selected.y/64)*64; 
		
		if (just_attacked == true && has_moved == true) {
			global.enemy = noone;
			global.ai_id += 1;
			global.selected = noone;
			global.ai_active = false;			
		}
	}
}

if (global.ai_id > instance_number(par_Enemy)) {
	global.state = turn_states.player_turn;
	global.selected = noone;
	global.ai_id = 1;
	with (par_Enemy) {
		just_attacked = false;
		has_moved = false;
	}
}
		