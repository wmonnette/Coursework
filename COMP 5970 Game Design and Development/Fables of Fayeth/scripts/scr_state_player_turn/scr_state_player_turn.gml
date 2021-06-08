

if(instance_position(mouse_x, mouse_y, par_Player) && (mouse_check_button_pressed(mb_left))) 
{
	
	if (global.moving == false && global.attacking == false) 
	{
		var player = instance_nearest(mouse_x, mouse_y, par_Player);
	
		global.selected = player;
		if (player.has_moved == false) 
		{
		
			with(par_Tile) 
			{
				instance_destroy();
			}
			scr_place_tiles();
		}
	}
}

else if (!instance_position(mouse_x,mouse_y,par_Player) && mouse_check_button_pressed(mb_left))
{
	if (global.moving == false && global.attacking == false)
	{
		global.selected = noone;
		with (obj_TileWalkable) {instance_destroy();}
		with (obj_TileAttack) {instance_destroy();}
	}
}

if ((global.selected != noone) && (mouse_check_button_pressed(mb_right)) 
	 && (global.selected.has_moved == false)) 
{
	
	if (instance_position(mouse_x, mouse_y, obj_TileWalkable))
	{
		global.moving = true;
		with (global.selected)
		{
			scr_navigation(x, y, round((mouse_x+32)/64)*64-32, round(((mouse_y+32)/64)*64-32), global.selected.charSpeed);
			global.selected.has_moved = true;
		}
	} else if (instance_position(mouse_x, mouse_y, obj_TileAttack))
	{
		global.enemy = instance_position(mouse_x, mouse_y, par_Enemy);
		global.attacking = true;
		with(global.selected)
		{
			if (distance_to_object(obj_TileAttack) > 13)
			{
				global.moving = true;
				scr_calculate_dist();
				current_state = sprite_states.moving;
				scr_navigation(x, y, round(global.attack_travel_x*64)/64, round(global.attack_travel_y*64)/64, global.selected.charSpeed);
				pixel_distance = path_get_length(global.navigate);
			}
		}
		with (par_Tile) 
		{
			instance_destroy();
		}
	
		
	}
}

if(global.moving == true) 
{
	with (global.selected)
	{
		if (path_index == -1) 
		{
			current_node_x = x;
			current_node_y = y;
			global.moving = false;
			with(par_Tile) 
			{
				instance_destroy();
			}
		}
	}
}

if (global.attacking == true) 
{
	if (global.moving == false)
	{
		with(global.selected)
		{
			scr_melee_attack();
			just_attacked = true;
		}
	}
}