if (!sprite_states.attack) {
	if (global.enemy.x > x-5) {image_xscale = 1;}
	current_state = sprite_states.attack //set sprite to melee
	image_index = 0;
}
 //if (image_index >= image_number-1) {

	just_attacked = true;
	current_state = sprite_states.idle //**Make sprite idle
	global.damage_dealt = irandom(attack);
	global.enemy.defense -= global.damage_dealt;
	var damage = instance_create_depth(global.enemy.x,global.enemy.y,0,obj_damage_dealt);
	damage.y = global.enemy.y - 20;
	
	if (global.enemy.defense <= 0) {
		current_state = sprite_states.death;
		global.enemy.image_index = 0;
	}
	
	image_xscale = -1;
	with (obj_TileAttack_ai) {instance_destroy();}
	global.enemy = noone;
	just_attacked = true;
	if (instance_number(par_Player) < 1) {global.state = turn_states.fail_state}
// }