/// @description Insert description here
// You can write your code in this editor
event_inherited();

if (instance_position(x+64, y, par_Enemy))
{
	instance_create_layer(x+64, y, "Instances", obj_TileAttack);
	
}
if (instance_position(x-64, y, par_Enemy))
{
	instance_create_layer(x-64, y, "Instances", obj_TileAttack);
	
}
if (instance_position(x, y+64, par_Enemy))
{
	instance_create_layer(x, y+64, "Instances", obj_TileAttack);
	
}
if (instance_position(x, y-64, par_Enemy))
{
	instance_create_layer(x, y-64, "Instances", obj_TileAttack);
	
}
if (instance_position(x+64, y+64, par_Enemy))
{
	instance_create_layer(x+64, y+64, "Instances", obj_TileAttack);
	
}
if (instance_position(x+64, y-64, par_Enemy))
{
	instance_create_layer(x+64, y-64, "Instances", obj_TileAttack);
	
}
if (instance_position(x-64, y+64, par_Enemy))
{
	instance_create_layer(x-64, y+64, "Instances", obj_TileAttack);
	
}
if (instance_position(x-64, y-64, par_Enemy))
{
	instance_create_layer(x-64, y-64, "Instances", obj_TileAttack);
	
}