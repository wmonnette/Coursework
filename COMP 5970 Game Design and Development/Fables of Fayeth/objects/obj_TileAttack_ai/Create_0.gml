/// @description Creates attack tiles
event_inherited();
if (global.selected.just_attacked == false ) {
	my_owner = instance_nearest(x,y,par_Enemy);
	global.enemy = my_owner;

	if (instance_position(x+64,y,par_Enemy)) {
		if (!instance_position(x+64,y,obj_TileAttack)) {
			instance_create_layer(x+64,y,"Instances",obj_TileAttack);
		}	
	}

	if (instance_position(x-64,y,par_Enemy)) {
		if (!instance_position(x-64,y,obj_TileAttack)) {
			instance_create_layer(x-64,y,"Instances",obj_TileAttack);
		}
	}

	if (instance_position(x,y+64,par_Enemy)) {
		if (!instance_position(x,y+64,obj_TileAttack)) {
			instance_create_layer(x,y+64,"Instances",obj_TileAttack);	
		}
	}

	if (instance_position(x,y-64,par_Enemy)) {
		if (!instance_position(x,y-64,obj_TileAttack)) {	
			instance_create_layer(x,y-64,"Instances",obj_TileAttack);	
		}
	}

	if (instance_position(x+64,y+64,par_Enemy)) {
		if (!instance_position(x+64,y+64, obj_TileAttack)) {
			instance_create_layer(x+64,y+64,"Instances",obj_TileAttack);	
		}
	}

	if (instance_position(x+64,y-64,par_Enemy)) {
		if (!instance_position(x+64,y-64,obj_TileAttack)) {	
			instance_create_layer(x+64,y-64,"Instances",obj_TileAttack);	
		}
	}

	if (instance_position(x-64,y+64,par_Enemy)) {
		if (!instance_position(x-64,y+64, obj_TileAttack)) {
			instance_create_layer(x-64,y+64,"Instances",obj_TileAttack);	
		}
	}

	if (instance_position(x-64,y-64,par_Enemy)) {
		if (!instance_position(x-64,y-64,obj_TileAttack)) {		
			instance_create_layer(x-64,y-64,"Instances",obj_TileAttack);	
		}
	}

	image_blend = c_red;
}