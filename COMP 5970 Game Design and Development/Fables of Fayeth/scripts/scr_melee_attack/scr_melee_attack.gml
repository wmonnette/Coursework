/// @function scr_melee_attack

if (current_state != sprite_states.attack)
{
	
	if (global.enemy.x < x) {
		image_xscale = -1;	
	}
	just_attacked = true;
	image_index = 0;
	current_state = sprite_states.attack;
}

if (image_index >= image_number - 1) {
	current_state = sprite_states.idle;
	
	global.damage_dealt = irandom(attack);
	global.enemy.defense -= global.damage_dealt;
	var damage = instance_create_depth(global.enemy.x,global.enemy.y,0,obj_damage_dealt);
	damage.y = global.enemy.y - 20;
	
	if (global.enemy.defense <= 0) {
		current_state = sprite_states.death;
		global.enemy.image_index = 0;
	}
	
	global.attacking = false;
	image_xscale = 1;
}