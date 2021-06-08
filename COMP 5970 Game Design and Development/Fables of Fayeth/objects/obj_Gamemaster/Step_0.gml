/// @description Global States
switch(global.state)
{
	case turn_states.player_turn: 
		scr_state_player_turn();
		break;
	
	case turn_states.ai_turn:
		scr_state_ai_turn();
		break;
}

if (keyboard_check_pressed(ord("R"))) {
	if (global.state == turn_states.player_turn) {
		
		with (par_Player) {
		pixel_distance = original_tile_distance;
		just_attacked = false;
	}
	

	
	global.state = turn_states.ai_turn;
	} else {
			with (par_Enemy) {
			pixel_distance = original_tile_distance;
			just_attacked = false;
			}
			
			global.state = turn_states.player_turn;
	}
	
}

