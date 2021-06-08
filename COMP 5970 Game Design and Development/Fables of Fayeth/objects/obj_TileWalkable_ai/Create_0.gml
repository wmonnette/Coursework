/// @description Insert description here
// You can write your code in this editor
event_inherited();

if (global.ai_selected.just_attacked == false) {
	if (instance_position(x+64, y, par_Player))
	{
		instance_create_layer(x+64, y, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x-64, y, par_Player))
	{
		instance_create_layer(x-64, y, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x, y+64, par_Player))
	{
		instance_create_layer(x, y+64, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x, y-64, par_Player))
	{
		instance_create_layer(x, y-64, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x+64, y+64, par_Player))
	{
		instance_create_layer(x+64, y+64, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x+64, y-64, par_Player))
	{
		instance_create_layer(x+64, y-64, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x-64, y+64, par_Player))
	{
		instance_create_layer(x-64, y+64, "Instances", obj_TileAttack_ai);
	
	}
	if (instance_position(x-64, y-64, par_Player))
	{
		instance_create_layer(x-64, y-64, "Instances", obj_TileAttack_ai);
	
	}
}